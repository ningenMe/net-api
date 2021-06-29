package ningenme.net.api.common.filter;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class NetApiAuthorizationFilter extends BasicAuthenticationFilter {

  private static final String AUTH_HEADER = "Authorization";
  private static final String AUTH_PREFIX = "Bearer ";
  private final String secret;

  public NetApiAuthorizationFilter(AuthenticationManager authenticationManager, String secret) {
    super(authenticationManager);
    this.secret = secret;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException {
    String header = httpServletRequest.getHeader(AUTH_HEADER);
    if(Objects.isNull(header) || !header.startsWith(AUTH_PREFIX)) {
      filterChain.doFilter(httpServletRequest,httpServletResponse);
      return;
    }

    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getUsernamePasswordAuthenticationToken(httpServletRequest);
    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    filterChain.doFilter(httpServletRequest,httpServletResponse);
  }

  private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(HttpServletRequest httpServletRequest) {
    String token = httpServletRequest.getHeader(AUTH_HEADER);

    if(Objects.isNull(token)) {
      return null;
    }

    String user = Jwts.parserBuilder()
                      .setSigningKey(secret.getBytes())
                      .build()
                      .parseClaimsJws(token.replace(AUTH_PREFIX,""))
                      .getBody()
                      .getSubject();

    if(Objects.isNull(user)) {
      return null;
    }

    return new UsernamePasswordAuthenticationToken(user,null, new ArrayList<>());
  }
}