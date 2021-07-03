package ningenme.net.api.common.handler;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.service.JwtCookieService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CookieAuthenticationFailureHandler implements AuthenticationFailureHandler {

  private final JwtCookieService jwtCookieService;

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
  }
}
