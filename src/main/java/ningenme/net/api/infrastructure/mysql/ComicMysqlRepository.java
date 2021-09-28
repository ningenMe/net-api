package ningenme.net.api.infrastructure.mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.Comic;
import ningenme.net.api.domain.value.Isbn13;
import ningenme.net.api.infrastructure.mysql.dto.ComicDto;
import ningenme.net.api.infrastructure.mysql.mapper.ComicMysqlMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ComicMysqlRepository {
  private final ComicMysqlMapper comicMysqlMapper;

  public List<Comic> get(@NonNull final List<Isbn13> isbn13List) {
    if(CollectionUtils.isEmpty(isbn13List)) {
      log.info("isbn13List is empty");
      return List.of();
    }
    return ComicDto.getComicList(comicMysqlMapper.select(isbn13List.stream().map(Isbn13::getValue).collect(Collectors.toList())));
  }

}
