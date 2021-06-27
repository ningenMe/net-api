package ningenme.net.api.domain.serviceImpl;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.object.ApplicationMeta;
import ningenme.net.api.domain.repository.mysql.ApplicationMetaRepository;
import ningenme.net.api.domain.service.ApplicationMetaService;
import ningenme.net.api.domain.value.ApplicationMetaId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationMetaServiceImpl implements ApplicationMetaService {

  private final ApplicationMetaRepository applicationMetaRepository;
  @Override
  public ApplicationMeta getApplicationMeta(ApplicationMetaId applicationMetaId) {
    return applicationMetaRepository.getApplicationMeta(applicationMetaId);
  }
}
