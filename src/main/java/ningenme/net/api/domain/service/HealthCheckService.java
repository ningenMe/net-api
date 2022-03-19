package ningenme.net.api.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.infrastructure.mysql.HealthCheckMysqlRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HealthCheckService {
    private final HealthCheckMysqlRepository healthCheckMysqlRepository;

    public Boolean isMysqlConnected() {
        try {
            healthCheckMysqlRepository.check();
            return true;
        } catch (Exception ex) {
            log.error("mysql not connected");
            return false;
        }
    }
}
