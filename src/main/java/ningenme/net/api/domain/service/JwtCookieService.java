package ningenme.net.api.domain.service;

import io.jsonwebtoken.Jwts;
import lombok.NonNull;
import ningenme.net.api.common.config.NetApiCommonConfig;
import ningenme.net.api.common.config.NetApiSecurityConfig;
import ningenme.net.api.domain.value.NetUserId;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;

@Service
public class JwtCookieService {

  private final NetApiCommonConfig netApiCommonConfig;
  private final NetApiSecurityConfig netApiSecurityConfig;
  private final SecretKey secretKey;

  public JwtCookieService(final NetApiCommonConfig netApiCommonConfig, final NetApiSecurityConfig netApiSecurityConfig) {
    this.netApiCommonConfig = netApiCommonConfig;
    this.netApiSecurityConfig = netApiSecurityConfig;
    this.secretKey = new SecretKeySpec(netApiSecurityConfig.getSecret().getBytes(), netApiSecurityConfig.getAlgorithm());
  }

  public Cookie getJwtCookieByNetUserId(@NonNull final NetUserId netUserId) {
    final String jwtToken = getJwtToken(netUserId);
    return getCookie(jwtToken);
  }

  private String getJwtToken(final NetUserId netUserId) {
    final Date issuedAt = new Date();
    final Date expiresAt = new Date(issuedAt.getTime() + netApiSecurityConfig.getExpirationTime());
    return Jwts.builder()
               .setSubject(netUserId.getValue())
               .setExpiration(expiresAt)
               .signWith(secretKey)
               .compact();
  }

  private Cookie getCookie(final String token) {
    Cookie cookie = new Cookie(netApiSecurityConfig.getCookieName(), token);
    cookie.setHttpOnly(true);
    cookie.setSecure(true);
    cookie.setDomain(netApiCommonConfig.getDomain());
    return cookie;
  }

  public String getJwtTokenByRequest(@NonNull final HttpServletRequest httpServletRequest) {
    try {
      final Cookie[] cookies = httpServletRequest.getCookies();
      for (Cookie cookie: cookies) {
        if(Objects.equals(cookie.getName(), "MeCookie")) {
          return cookie.getValue();
        }
      }
    } catch (Exception ignored) {
    }
    return null;
  }

  public NetUserId getNetUserIdByJwtToken(final String jwtToken) {
    try {
      final String userId = Jwts.parserBuilder()
                                .setSigningKey(netApiSecurityConfig.getSecret().getBytes())
                                .build()
                                .parseClaimsJws(jwtToken)
                                .getBody()
                                .getSubject();
      return NetUserId.of(userId);
    } catch (Exception ex) {
      return null;
    }
  }

}
