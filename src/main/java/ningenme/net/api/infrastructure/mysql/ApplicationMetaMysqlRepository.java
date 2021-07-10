package ningenme.net.api.infrastructure.mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ApplicationMeta;
import ningenme.net.api.domain.value.ApplicationMetaId;
import ningenme.net.api.infrastructure.mysql.mapper.ApplicationMetaMysqlMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ApplicationMetaMysqlRepository {

  private final ApplicationMetaMysqlMapper applicationMetaMysqlMapper;

  public List<ApplicationMeta> get(@NonNull final ApplicationMetaId applicationMetaId) {
    return ApplicationMeta.fromApplicationMetaDtoList(
            applicationMetaMysqlMapper.select(applicationMetaId.getValue()));
  }

  public ApplicationMeta getLatestOne(@NonNull final ApplicationMetaId applicationMetaId) {
    return ApplicationMeta.of(
            applicationMetaMysqlMapper.selectLatestOne(applicationMetaId.getValue()));
  }

  public void post(@NonNull final ApplicationMetaId applicationMetaId) {
    applicationMetaMysqlMapper.insert(applicationMetaId.getValue());
  }
}
