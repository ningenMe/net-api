package ningenme.net.api.common.config;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.common.filter.LoggingFilter;
import ningenme.net.api.common.filter.NetApiAuthorizationFilter;
import ningenme.net.api.common.handler.CookieAuthenticationSuccessHandler;
import ningenme.net.api.domain.value.NetUserRole;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final LoggingFilter loggingFilter;
    private final CookieAuthenticationSuccessHandler cookieAuthenticationSuccessHandler;
    private final NetApiSecurityConfig netApiSecurityConfig;
    private final NetApiAuthorizationFilter netApiAuthorizationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers(HttpMethod.GET , "/v1/**").permitAll()
                .mvcMatchers(HttpMethod.POST, "/v1/net/users").hasAuthority(NetUserRole.ADMIN.getValue())
                .mvcMatchers(HttpMethod.POST, "/v1/application-metas/**").hasAuthority(NetUserRole.ADMIN.getValue())
                .anyRequest().authenticated()

                //login
                .and()
                .formLogin()
                .loginProcessingUrl(netApiSecurityConfig.getLoginPath())
                .permitAll()
                .usernameParameter(netApiSecurityConfig.getUserNameParameter())
                .passwordParameter(netApiSecurityConfig.getPasswordParameter())
                .successHandler(cookieAuthenticationSuccessHandler)

                .and()
                .addFilterBefore(loggingFilter, UsernamePasswordAuthenticationFilter.class)

                .sessionManagement()
                .disable()


                .addFilterBefore(netApiAuthorizationFilter,UsernamePasswordAuthenticationFilter.class)

                .csrf()
                .disable()

                .headers()
                .cacheControl()
                .disable()

                .and()
                .cors()
                .configurationSource(getConfigurationSource());
    }

    private CorsConfigurationSource getConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL);
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/v1/**", corsConfiguration);
        return urlBasedCorsConfigurationSource;
    }
}