package ningenme.net.api.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.NetUser;
import ningenme.net.api.infrastructure.mysql.NetUserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NetUserService {
  private final NetUserRepository netUserRepository;

  public void post(@NonNull final NetUser netUser) {
    netUserRepository.post(netUser);
  }
}
