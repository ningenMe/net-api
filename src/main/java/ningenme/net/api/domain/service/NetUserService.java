package ningenme.net.api.domain.service;

import lombok.NonNull;
import ningenme.net.api.domain.entity.NetUser;

public interface NetUserService {
  void post(@NonNull final NetUser netUser);
}