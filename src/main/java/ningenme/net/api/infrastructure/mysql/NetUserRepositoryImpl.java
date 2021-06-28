package ningenme.net.api.infrastructure.mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.NetUser;
import ningenme.net.api.domain.repository.mysql.NetUserRepository;
import ningenme.net.api.infrastructure.mysql.mapper.NetUserMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NetUserRepositoryImpl implements NetUserRepository {

  private final NetUserMapper netUserMapper;

  @Override
  public void post(@NonNull NetUser netUser) {
    netUserMapper.insert(netUser.getNetUserId().getValue(),netUser.getEncryptedPassword().getValue());
  }
}
