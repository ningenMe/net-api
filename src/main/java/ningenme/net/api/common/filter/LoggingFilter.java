package ningenme.net.api.common.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class LoggingFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    log.info(getRequestInfo((HttpServletRequest) request));
    chain.doFilter(request,response);
    log.info(getResponseInfo((HttpServletResponse) response));
  }

  @Override
  public void destroy() {

  }

  private String getRequestInfo(HttpServletRequest request) throws IOException{
    String info = "request";
    {
      info += " method: ";
      info += request.getMethod();
      info += ", ";
    }
    {
      info += " uri: ";
      info += request.getRequestURI();
      info += ", ";
    }
    {
      info += " query: ";
      info += request.getQueryString();
      info += ", ";
    }
    {
      info += " cookie: ";
      info += Optional.ofNullable(request.getCookies())
                      .map(cookies -> Arrays.stream(cookies)
                                            .map(cookie -> cookie.getName() + ":" + cookie.getValue())
                                            .collect(Collectors.toList()))
                      .orElse(List.of());
      info += ", ";
    }
    return info;
  }

  private String getResponseInfo(HttpServletResponse response) {
    String info = "response";
    {
      info += " status: ";
      info += response.getStatus();
      info += ", ";
    }
    return info;
  }
}
