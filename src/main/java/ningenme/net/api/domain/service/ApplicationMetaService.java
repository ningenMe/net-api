package ningenme.net.api.domain.service;

import lombok.NonNull;
import ningenme.net.api.domain.entity.ApplicationMeta;
import ningenme.net.api.domain.value.ApplicationMetaId;

public interface ApplicationMetaService {
  ApplicationMeta getLatestOne(@NonNull final ApplicationMetaId applicationMetaId);
  void post(@NonNull final ApplicationMetaId applicationMetaId);
}
