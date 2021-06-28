package ningenme.net.api.common.config;

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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
              .authorizeRequests()
              .mvcMatchers(HttpMethod.GET ,"/v1/**").permitAll()
              .mvcMatchers("/v1/login").permitAll()
//              .anyRequest().authenticated()

              .and()
              .formLogin()

              .and()
              .logout()

              .and()
              .addFilter(new NetApiAuthenticationFilter(authenticationManager(), secret))
              .addFilter(new NetApiAuthorizationFilter(authenticationManager(), secret))

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


//    private static final String[] AUTH_WHITELIST = {
//        "/swagger-resources/**",
//        "/swagger-ui.html",
//        "/v2/api-docs",
//        "/webjars/**"
//    };
//
//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers(AUTH_WHITELIST);
//    }
}