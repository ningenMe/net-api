package ningenme.net.api.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ApplicationMeta;
import ningenme.net.api.domain.value.ApplicationMetaId;
import ningenme.net.api.infrastructure.mysql.ApplicationMetaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationMetaService {

  private final ApplicationMetaRepository applicationMetaRepository;

  public ApplicationMeta getLatestOne(@NonNull final ApplicationMetaId applicationMetaId) {
    return applicationMetaRepository.getLatestOne(applicationMetaId);
  }

  public void post(@NonNull ApplicationMetaId applicationMetaId) {
    applicationMetaRepository.post(applicationMetaId);
  }
}
