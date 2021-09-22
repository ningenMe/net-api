package ningenme.net.api.common.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class NetApiSqsConfig {
    @Value("${net.api.sqs.user-access-key-id}")
    private String userAccessKeyId;
    @Value("${net.api.sqs.user-secret-access-key}")
    private String userSecretAccessKey;
    @Value("${net.api.sqs.url-problem-sqs}")
    private String urlProblemSqs;
}
