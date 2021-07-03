package ningenme.net.api.common.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
public class LoggingFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    final UUID uuid = UUID.randomUUID();
    Boolean isLogging = !isHealthCheckRequest((HttpServletRequest) request);
    if(isLogging) log.info(getRequestInfo((HttpServletRequest) request,uuid));
    chain.doFilter(request,response);
    if(isLogging) log.info(getResponseInfo((HttpServletResponse) response,uuid));
  }

  @Override
  public void destroy() {

  }

  private Boolean isHealthCheckRequest(final HttpServletRequest request) {
    return request.getRequestURI().startsWith("/v1/healthcheck");
  }

  private String getRequestInfo(final HttpServletRequest request,final UUID uuid) throws IOException{
    String info = "";
    {
      info += "request :";
      info += uuid.toString();
      info += ", ";
    }
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

  private String getResponseInfo(final HttpServletResponse response,final UUID uuid) {
    String info = "";
    {
      info += "response:";
      info += uuid.toString();
      info += ", ";
    }
    {
      info += " status: ";
      info += response.getStatus();
      info += ", ";
    }
    {
      info += " headers: ";
      info += response.getHeaderNames();
      info += ", ";
    }
    return info;
  }
}
