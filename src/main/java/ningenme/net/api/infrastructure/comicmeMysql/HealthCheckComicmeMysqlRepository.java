package ningenme.net.api.infrastructure.comicmeMysql;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.infrastructure.comicmeMysql.mapper.HealthCheckComicmeMysqlMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HealthCheckComicmeMysqlRepository {
    private final HealthCheckComicmeMysqlMapper healthCheckComicmeMysqlMapper;

    public void check() {
        healthCheckComicmeMysqlMapper.select();
    }
}
