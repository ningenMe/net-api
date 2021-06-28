package ningenme.net.api.domain.serviceImpl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ApplicationMeta;
import ningenme.net.api.domain.repository.mysql.ApplicationMetaRepository;
import ningenme.net.api.domain.service.ApplicationMetaService;
import ningenme.net.api.domain.value.ApplicationMetaId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationMetaServiceImpl implements ApplicationMetaService {

  private final ApplicationMetaRepository applicationMetaRepository;
  @Override
  public ApplicationMeta getLatestOne(@NonNull final ApplicationMetaId applicationMetaId) {
    return applicationMetaRepository.getLatestOne(applicationMetaId);
  }

  @Override
  public void post(@NonNull ApplicationMetaId applicationMetaId) {
    applicationMetaRepository.post(applicationMetaId);
  }
}
