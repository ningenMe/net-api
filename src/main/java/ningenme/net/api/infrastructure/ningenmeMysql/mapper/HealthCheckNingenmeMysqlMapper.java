package ningenme.net.api.infrastructure.ningenmeMysql.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HealthCheckNingenmeMysqlMapper {

    @Select(
        "SELECT 1 FROM healthchecks"
    )
    Integer select();
}
