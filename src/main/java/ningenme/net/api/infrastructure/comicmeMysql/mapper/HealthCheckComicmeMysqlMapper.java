package ningenme.net.api.infrastructure.comicmeMysql.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HealthCheckComicmeMysqlMapper {

    @Select(
        "SELECT 1 FROM healthchecks"
    )
    Integer select();
}
