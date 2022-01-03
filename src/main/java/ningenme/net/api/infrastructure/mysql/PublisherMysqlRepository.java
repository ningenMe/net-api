package ningenme.net.api.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.infrastructure.mysql.mapper.CreatorMysqlMapper;
import ningenme.net.api.infrastructure.mysql.mapper.PublisherMysqlMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PublisherMysqlRepository {
  private final PublisherMysqlMapper publisherMysqlMapper;

  public Integer getCount() {
      return publisherMysqlMapper.selectCount();
  }

}
