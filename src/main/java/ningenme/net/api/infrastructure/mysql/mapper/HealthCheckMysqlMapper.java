package ningenme.net.api.infrastructure.mysql.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HealthCheckMysqlMapper {

    @Select(
        "SELECT 1"
    )
    Integer select();
}
