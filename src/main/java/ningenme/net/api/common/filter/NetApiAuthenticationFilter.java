package ningenme.net.api.common.filter;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.common.config.NetApiAuthConfig;
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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Slf4j
public class NetApiAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private AuthenticationManager authenticationManager;

  private final String secret;
  private final String domain;

  public NetApiAuthenticationFilter(AuthenticationManager authenticationManager, String secret, String domain) {

    this.secret = secret;
    this.domain = domain;
    this.authenticationManager = authenticationManager;

    setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(NetApiAuthConfig.LOGIN_PATH, HttpMethod.POST.name()));
    setUsernameParameter(NetApiAuthConfig.USERNAME_PARAMETER);
    setPasswordParameter(NetApiAuthConfig.PASSWORD_PARAMETER);
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException {
    try {
      return authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      httpServletRequest.getParameter(NetApiAuthConfig.USERNAME_PARAMETER),
                      httpServletRequest.getParameter(NetApiAuthConfig.PASSWORD_PARAMETER),
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
    Date expiresAt = new Date(issuedAt.getTime() + NetApiAuthConfig.EXPIRATION_TIME);
    SecretKey secretKey = new SecretKeySpec(secret.getBytes(),"HmacSHA256");
    String token = Jwts.builder()
                       .setSubject(loginUser.getUsername())
                       .setExpiration(expiresAt)
                       .signWith(secretKey)
                       .compact();
    httpServletResponse.addCookie(getCookie(token));
  }

  private Cookie getCookie(final String token) {
    Cookie cookie = new Cookie(NetApiAuthConfig.COOKIE_NAME, token);
    cookie.setHttpOnly(true);
    cookie.setSecure(true);
    cookie.setDomain(domain);
    return cookie;
  }
}