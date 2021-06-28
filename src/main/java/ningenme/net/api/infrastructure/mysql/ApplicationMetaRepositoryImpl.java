package ningenme.net.api.infrastructure.mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ApplicationMeta;
import ningenme.net.api.domain.repository.mysql.ApplicationMetaRepository;
import ningenme.net.api.domain.value.ApplicationMetaId;
import ningenme.net.api.infrastructure.mysql.mapper.ApplicationMetaMapper;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ApplicationMetaRepositoryImpl implements ApplicationMetaRepository {

  private final ApplicationMetaMapper applicationMetaMapper;

  @Override
  public ApplicationMeta getLatestOne(@NonNull final ApplicationMetaId applicationMetaId) {
    return ApplicationMeta.of(
            applicationMetaMapper.selectLatestOne(applicationMetaId.getValue()));
  }
}
