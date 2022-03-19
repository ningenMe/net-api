package ningenme.net.api.application.service;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.generated.model.HealthCheckGetResponseView;
import ningenme.net.api.domain.service.HealthCheckService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthCheckGetService {

    private final HealthCheckService healthCheckService;

    public HealthCheckGetResponseView getHealthCheckGetResponseView() {
        return new HealthCheckGetResponseView().mysql(
            healthCheckService.isMysqlConnected()
        );
    }
}
