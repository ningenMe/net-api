package ningenme.net.api.infrastructure.comproMysql.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HealthCheckComproMysqlMapper {

    @Select(
        "SELECT 1 FROM healthchecks"
    )
    Integer select();
}
