package ningenme.net.api.common.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class NetApiCommonConfig {
  @Value("${net.api.common.domain}")
  private String domain;
}
