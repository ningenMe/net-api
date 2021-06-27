//package ningenme.net.api.common.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Bean
//    PasswordEncoder passwordEncoder() {
//      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//    @Value("${ningenme.net.secret}")
//    String secret;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//      http
//              .authorizeRequests()
//              .mvcMatchers(HttpMethod.GET ,"/v1/**").permitAll()
//              .mvcMatchers("/v1/login").permitAll()
//              .anyRequest().authenticated()
//
//              .and()
//              .formLogin()
//
//              .and()
//              .logout()
//
//              .and()
//              .addFilter(new NingenmeNetApiAuthenticationFilter(authenticationManager(),secret))
//              .addFilter(new NingenmeNetApiAuthorizationFilter(authenticationManager(),secret))
//
//              .csrf()
//              .disable()
//
//              .headers()
//              .cacheControl()
//              .disable()
//
//              .and()
//              .cors()
//              .configurationSource(getConfigurationSource());
//    }
//
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
//
//    private CorsConfigurationSource getConfigurationSource() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
//        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
//        corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL);
//        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/v1/**", corsConfiguration);
//        return urlBasedCorsConfigurationSource;
//    }
//}