package ningenme.net.api.infrastructure.mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ApplicationMeta;
import ningenme.net.api.domain.value.ApplicationMetaId;
import ningenme.net.api.infrastructure.mysql.mapper.ApplicationMetaMapper;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ApplicationMetaRepository {

  private final ApplicationMetaMapper applicationMetaMapper;

  public ApplicationMeta getLatestOne(@NonNull final ApplicationMetaId applicationMetaId) {
    return ApplicationMeta.of(
            applicationMetaMapper.selectLatestOne(applicationMetaId.getValue()));
  }

  public void post(@NonNull final ApplicationMetaId applicationMetaId) {
    applicationMetaMapper.insert(applicationMetaId.getValue());
  }
}
