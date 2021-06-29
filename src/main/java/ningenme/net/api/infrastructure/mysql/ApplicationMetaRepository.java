package ningenme.net.api.infrastructure.mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ApplicationMeta;
import ningenme.net.api.domain.value.ApplicationMetaId;
import ningenme.net.api.infrastructure.mysql.mapper.ApplicationMetaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ApplicationMetaRepository {

  private final ApplicationMetaMapper applicationMetaMapper;

  public List<ApplicationMeta> get(@NonNull final ApplicationMetaId applicationMetaId) {
    return ApplicationMeta.of(
            applicationMetaMapper.select(applicationMetaId.getValue()));
  }

  public ApplicationMeta getLatestOne(@NonNull final ApplicationMetaId applicationMetaId) {
    return ApplicationMeta.of(
            applicationMetaMapper.selectLatestOne(applicationMetaId.getValue()));
  }

  public void post(@NonNull final ApplicationMetaId applicationMetaId) {
    applicationMetaMapper.insert(applicationMetaId.getValue());
  }
}
