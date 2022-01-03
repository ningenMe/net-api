package ningenme.net.api.infrastructure.mysql.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PublisherMysqlMapper {

    @Select(
        "SELECT COUNT(publisher_id) FROM publishers"
    )
    Integer selectCount();

}
