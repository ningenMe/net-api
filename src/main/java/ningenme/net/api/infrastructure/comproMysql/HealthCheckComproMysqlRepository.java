package ningenme.net.api.infrastructure.comproMysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.infrastructure.comproMysql.mapper.HealthCheckComproMysqlMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HealthCheckComproMysqlRepository {
    private final HealthCheckComproMysqlMapper healthCheckComproMysqlMapper;

    public void check() {
        healthCheckComproMysqlMapper.select();
    }
}
