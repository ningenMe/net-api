package ningenme.net.api.common.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NetApiAuthConfig {
  public static final String COOKIE_NAME = "MeCookie";
  public static final Long EXPIRATION_TIME = 1000L * 60L * 60L * 12L; // 12 hour (ms)
  public static final String LOGIN_PATH = "/v1/login";
  public static final String USERNAME_PARAMETER = "email";
  public static final String PASSWORD_PARAMETER = "password";
}
