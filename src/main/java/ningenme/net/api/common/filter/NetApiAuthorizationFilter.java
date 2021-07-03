package ningenme.net.api.common.filter;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.NetUser;
import ningenme.net.api.domain.service.JwtCookieService;
import ningenme.net.api.domain.service.NetUserService;
import ningenme.net.api.domain.value.NetUserId;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class NetApiAuthorizationFilter extends GenericFilterBean {

  private final JwtCookieService jwtCookieService;
  private final NetUserService netUserService;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    final String jwtToken = jwtCookieService.getJwtTokenByRequest((HttpServletRequest) request);

    final NetUserId netUserId = jwtCookieService.getNetUserIdByJwtToken(jwtToken);
    if(Objects.isNull(netUserId)) {
      chain.doFilter(request,response);
      return;
    }

    final NetUser netUser = netUserService.getNetUser(netUserId);
    if(Objects.isNull(netUser)) {
      chain.doFilter(request,response);
      return;
    }

    SecurityContextHolder.getContext().setAuthentication(netUser.getUsernamePasswordAuthenticationToken());
    chain.doFilter(request, response);
  }
}