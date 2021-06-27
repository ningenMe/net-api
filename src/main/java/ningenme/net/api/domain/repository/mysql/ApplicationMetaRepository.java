package ningenme.net.api.domain.repository.mysql;

import lombok.NonNull;
import ningenme.net.api.domain.object.ApplicationMeta;
import ningenme.net.api.domain.value.ApplicationMetaId;

public interface ApplicationMetaRepository {
  ApplicationMeta getApplicationMeta(@NonNull final ApplicationMetaId applicationMetaId);
}
