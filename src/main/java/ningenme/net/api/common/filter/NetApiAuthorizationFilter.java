package ningenme.net.api.common.filter;

import io.jsonwebtoken.Jwts;
import ningenme.net.api.common.config.NetApiAuthConfig;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class NetApiAuthorizationFilter extends BasicAuthenticationFilter {

  private final String secret;

  public NetApiAuthorizationFilter(AuthenticationManager authenticationManager, String secret) {
    super(authenticationManager);
    this.secret = secret;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException {
    final String cookie = getCookie(httpServletRequest);
    final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getUsernamePasswordAuthenticationToken(cookie);
    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    filterChain.doFilter(httpServletRequest,httpServletResponse);
  }

  private String getCookie(HttpServletRequest httpServletRequest) {
    final Cookie[] cookies = httpServletRequest.getCookies();
    if(Objects.isNull(cookies)) {
      return null;
    }
    for (Cookie cookie: cookies) {
      if(Objects.equals(cookie.getName(),NetApiAuthConfig.COOKIE_NAME)) {
        return cookie.getValue();
      }
    }
    return null;
  }

  private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(final String cookie) {
    if(Objects.isNull(cookie)) {
      return null;
    }

    final String user = Jwts.parserBuilder()
                      .setSigningKey(secret.getBytes())
                      .build()
                      .parseClaimsJws(cookie)
                      .getBody()
                      .getSubject();

    if(Objects.isNull(user)) {
      return null;
    }

    return new UsernamePasswordAuthenticationToken(user, null, List.of());
  }
}