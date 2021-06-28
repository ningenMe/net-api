package ningenme.net.api.domain.serviceImpl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.NetUser;
import ningenme.net.api.domain.repository.mysql.NetUserRepository;
import ningenme.net.api.domain.service.NetUserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NetUserServiceImpl implements NetUserService {
  private final NetUserRepository netUserRepository;

  @Override
  public void post(@NonNull final NetUser netUser) {
    netUserRepository.post(netUser);
  }
}
