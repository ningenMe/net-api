package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.mysql.dto.ApplicationMetaDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ApplicationMetaMapper {

  @Select(
          "SELECT application_meta_id, created_time FROM application_metas ORDER BY created_time DESC LIMIT 1"
  )
  ApplicationMetaDto selectLatestOne(@Param("applicationMetaId") String applicationMetaId);

  @Select(
          "SELECT application_meta_id, created_time FROM application_metas ORDER BY created_time ASC"
  )
  List<ApplicationMetaDto> select(@Param("applicationMetaId") String applicationMetaId);

  @Insert(
          "INSERT INTO application_metas (application_meta_id) VALUES (#{applicationMetaId})"
  )
  void insert(@Param("applicationMetaId") String applicationMetaId);
}
