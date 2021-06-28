package ningenme.net.api.common.filter;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Slf4j
public class NetApiAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private AuthenticationManager authenticationManager;

  private static final String AUTH_HEADER = "Authorization";
  private static final String AWS_AUTH_HEADER = "x-amzn-remapped-authorization";
  private static final String AUTH_PREFIX = "Bearer ";
  private static final Long EXPIRATION_TIME = 1000L * 60L * 60L * 12L; // 12 hour (ms)
  private static final String LOGIN_PATH = "/v1/login";
  private static final String USERNAME_PARAMETER = "email";
  private static final String PASSWORD_PARAMETER = "password";
  private static final String ACCESS_CONTROL_EXPOSE_HEADER = "Access-Control-Expose-Headers";
  private final String secret;

  public NetApiAuthenticationFilter(AuthenticationManager authenticationManager, String secret) {

    this.secret = secret;
    this.authenticationManager = authenticationManager;

    setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(LOGIN_PATH, HttpMethod.POST.name()));
    setUsernameParameter(USERNAME_PARAMETER);
    setPasswordParameter(PASSWORD_PARAMETER);
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException {
    try {
      return authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      httpServletRequest.getParameter(USERNAME_PARAMETER),
                      httpServletRequest.getParameter(PASSWORD_PARAMETER),
                      new ArrayList<>())
      );
    } catch (Exception ex) {
      throw ex;
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain, Authentication authentication) throws IOException, ServletException {
    User loginUser = (User)authentication.getPrincipal();
    Date issuedAt = new Date();
    Date expiresAt = new Date(issuedAt.getTime() + EXPIRATION_TIME);
    SecretKey secretKey = new SecretKeySpec(secret.getBytes(),"HmacSHA256");
    String token = Jwts.builder()
            .setSubject(loginUser.getUsername())
            .setExpiration(expiresAt)
            .signWith(secretKey)
            .compact();
    httpServletResponse.addHeader(ACCESS_CONTROL_EXPOSE_HEADER,AUTH_HEADER);
    httpServletResponse.addHeader(ACCESS_CONTROL_EXPOSE_HEADER,AWS_AUTH_HEADER);
    httpServletResponse.addHeader(AUTH_HEADER, AUTH_PREFIX + token);
  }
}