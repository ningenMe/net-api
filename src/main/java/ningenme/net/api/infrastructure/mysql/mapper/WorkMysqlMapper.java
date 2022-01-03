package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.mysql.dto.ComicDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WorkMysqlMapper {

    @Select(
        "SELECT COUNT(work_id) FROM works"
    )
    Integer selectCount();

}
