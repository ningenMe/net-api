package ningenme.net.api.common.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class NetApiSecurityConfig {
    private String cookieName = "MeCookie";
    private Long expirationTime = 1000L * 60L * 60L * 12L; // 12 hour (ms)
    private String loginPath = "/v1/login";
    private String userNameParameter = "email";
    public String passwordParameter = "password";
    @Value("${net.api.security.encrypt-secret}")
    private String secret;
    @Value("${net.api.security.encrypt-algorithm}")
    private String algorithm;
}
