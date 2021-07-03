package ningenme.net.api.infrastructure.mysql.mapper;

import lombok.NonNull;
import ningenme.net.api.infrastructure.mysql.dto.NetUserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NetUserMapper {

  @Insert(
          "INSERT INTO net_users (net_user_id,password) VALUES (#{netUserId}, #{password})"
  )
  void insert(
          @Param("netUserId") @NonNull final String netUserId,
          @Param("password") @NonNull final String password);

  @Select(
          "SELECT net_user_id, password, role FROM net_users WHERE net_user_id = #{netUserId}"
  )
  NetUserDto select(
          @Param("netUserId") @NonNull final String netUserId);
}
