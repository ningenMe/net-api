package ningenme.net.api.domain.repository.mysql;

import lombok.NonNull;
import ningenme.net.api.domain.entity.NetUser;

public interface NetUserRepository {
  void post(@NonNull final NetUser netUser);
}
