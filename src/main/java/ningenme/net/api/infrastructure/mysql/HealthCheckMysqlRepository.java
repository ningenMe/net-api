package ningenme.net.api.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.infrastructure.mysql.mapper.HealthCheckMysqlMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HealthCheckMysqlRepository {
    private final HealthCheckMysqlMapper healthCheckMysqlMapper;

    public void check() {
        healthCheckMysqlMapper.select();
    }
}
