package ningenme.net.api.common.config;

import ningenme.net.api.common.filter.LoggingFilter;
import ningenme.net.api.common.filter.NetApiAuthenticationFilter;
import ningenme.net.api.common.filter.NetApiAuthorizationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${net.api.encrypt-secret}")
    private String secret;
    @Value("${net.api.domain}")
    private String domain;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers(HttpMethod.GET , "/v1/**").permitAll()
                .mvcMatchers(HttpMethod.POST ,"/v1/login").permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin()

                .and()
                .logout()

                .and()
                .addFilterBefore(new LoggingFilter(),NetApiAuthenticationFilter.class)
                .addFilter(new NetApiAuthenticationFilter(authenticationManager(),secret,domain))
                .addFilter(new NetApiAuthorizationFilter(authenticationManager(),secret))

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