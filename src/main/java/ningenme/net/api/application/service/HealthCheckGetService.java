package ningenme.net.api.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.application.generated.model.HealthCheckGetResponseView;
import ningenme.net.api.domain.service.HealthCheckService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HealthCheckGetService {

    private final HealthCheckService healthCheckService;

    public HealthCheckGetResponseView getHealthCheckGetResponseView() {
        return new HealthCheckGetResponseView()
            .ningenmeMysql(healthCheckService.isNingenmeMysqlConnected())
            .comicmeMysql(healthCheckService.isComicmeMysqlConnected())
            .comproMysql(healthCheckService.isComproMysqlConnected());
    }
}
