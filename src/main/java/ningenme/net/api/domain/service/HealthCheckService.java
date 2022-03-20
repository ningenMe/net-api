package ningenme.net.api.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.infrastructure.comicmeMysql.HealthCheckComicmeMysqlRepository;
import ningenme.net.api.infrastructure.comproMysql.HealthCheckComproMysqlRepository;
import ningenme.net.api.infrastructure.ningenmeMysql.HealthCheckNingenmeMysqlRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HealthCheckService {
    private final HealthCheckNingenmeMysqlRepository healthCheckNingenmeMysqlRepository;
    private final HealthCheckComicmeMysqlRepository healthCheckComicmeMysqlRepository;
    private final HealthCheckComproMysqlRepository healthCheckComproMysqlRepository;

    public Boolean isNingenmeMysqlConnected() {
        try {
            healthCheckNingenmeMysqlRepository.check();
            return true;
        } catch (Exception ex) {
            log.error("ningenme mysql not connected");
            return false;
        }
    }

    public Boolean isComicmeMysqlConnected() {
        try {
            healthCheckComicmeMysqlRepository.check();
            return true;
        } catch (Exception ex) {
            log.error("comicme mysql not connected");
            return false;
        }
    }

    public Boolean isComproMysqlConnected() {
        try {
            healthCheckComproMysqlRepository.check();
            return true;
        } catch (Exception ex) {
            log.error("compro mysql not connected");
            return false;
        }
    }

}
