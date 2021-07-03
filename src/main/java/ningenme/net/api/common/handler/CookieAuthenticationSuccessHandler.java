package ningenme.net.api.common.handler;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.service.JwtCookieService;
import ningenme.net.api.domain.value.NetUserId;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CookieAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  private final JwtCookieService jwtCookieService;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    response.addCookie(
            jwtCookieService.getJwtCookieByNetUserId(NetUserId.of(authentication)));
  }
}
