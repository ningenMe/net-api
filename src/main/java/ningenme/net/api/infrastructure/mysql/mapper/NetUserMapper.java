package ningenme.net.api.infrastructure.mysql.mapper;

import lombok.NonNull;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface NetUserMapper {

  @Insert(
          "INSERT INTO net_users (net_user_id,password) VALUES (#{netUserId}, #{password})"
  )
  void insert(
          @Param("netUserId") @NonNull final String netUserId,
          @Param("password") @NonNull final String password);
}
