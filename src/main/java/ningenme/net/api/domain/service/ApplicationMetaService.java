package ningenme.net.api.domain.service;

import ningenme.net.api.domain.entity.ApplicationMeta;
import ningenme.net.api.domain.value.ApplicationMetaId;

public interface ApplicationMetaService {
  ApplicationMeta getApplicationMeta(ApplicationMetaId applicationMetaId);
}
