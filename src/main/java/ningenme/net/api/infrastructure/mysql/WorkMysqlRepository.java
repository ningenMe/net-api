package ningenme.net.api.infrastructure.mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.Comic;
import ningenme.net.api.domain.value.Isbn13;
import ningenme.net.api.infrastructure.mysql.dto.ComicDto;
import ningenme.net.api.infrastructure.mysql.mapper.ComicMysqlMapper;
import ningenme.net.api.infrastructure.mysql.mapper.WorkMysqlMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class WorkMysqlRepository {
  private final WorkMysqlMapper workMysqlMapper;

  public Integer getCount() {
      return workMysqlMapper.selectCount();
  }

}
