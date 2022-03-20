package ningenme.net.api.infrastructure.comicmeMysql.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface WorkMysqlMapper {

    @Select(
        "SELECT COUNT(work_id) FROM works"
    )
    Integer selectCount();

}
