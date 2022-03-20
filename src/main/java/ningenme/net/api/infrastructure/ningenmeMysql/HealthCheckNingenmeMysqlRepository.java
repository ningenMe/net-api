package ningenme.net.api.infrastructure.ningenmeMysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.infrastructure.ningenmeMysql.mapper.HealthCheckNingenmeMysqlMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HealthCheckNingenmeMysqlRepository {
    private final HealthCheckNingenmeMysqlMapper healthCheckNingenmeMysqlMapper;

    public void check() {
        healthCheckNingenmeMysqlMapper.select();
    }
}
