package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.mysql.dto.ApplicationMetaDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ApplicationMetaMapper {

  @Select(
          "SELECT application_meta_id, created_time FROM application_metas ORDER BY created_time DESC LIMIT 1"
  )
  ApplicationMetaDto selectApplicationMetaDto(@Param("applicationMetaId") String applicationMetaId);
}
