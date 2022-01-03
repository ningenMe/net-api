package ningenme.net.api.infrastructure.mysql.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CreatorMysqlMapper {

    @Select(
        "SELECT COUNT(creator_id) FROM creators"
    )
    Integer selectCount();

}
