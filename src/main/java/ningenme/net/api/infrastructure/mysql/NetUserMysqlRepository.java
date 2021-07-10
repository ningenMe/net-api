package ningenme.net.api.infrastructure.mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.NetUser;
import ningenme.net.api.domain.value.NetUserId;
import ningenme.net.api.infrastructure.mysql.mapper.NetUserMysqlMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class NetUserMysqlRepository {

  private final NetUserMysqlMapper netUserMysqlMapper;

  public void post(@NonNull NetUser netUser) {
    netUserMysqlMapper.insert(netUser.getNetUserId().getValue(),
                         netUser.getEncryptedPassword().getValue(),
                         netUser.getNetUserRole().getValue()
                        );
  }

  public NetUser get(@NonNull final NetUserId netUserId) {
    try {
      return NetUser.of(netUserMysqlMapper.select(netUserId.getValue()));
    } catch (Exception ex) {
      return null;
    }
  }
}
