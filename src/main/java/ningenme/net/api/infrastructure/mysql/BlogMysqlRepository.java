package ningenme.net.api.infrastructure.mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.Blog;
import ningenme.net.api.domain.value.BlogType;
import ningenme.net.api.domain.value.PostedDate;
import ningenme.net.api.infrastructure.mysql.dto.BlogDto;
import ningenme.net.api.infrastructure.mysql.mapper.BlogMysqlMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BlogMysqlRepository {
  private final BlogMysqlMapper blogMysqlMapper;

  public void post(@NonNull final List<Blog> blogList) {
    if(CollectionUtils.isEmpty(blogList)) {
      return;
    }
    blogMysqlMapper.insert(Blog.getBlogDtoList(blogList));
  }

  public List<Blog> get(@NonNull final List<BlogType> blogTypeList) {
    if(CollectionUtils.isEmpty(blogTypeList)) {
      log.info("blogTypeList is empty");
      return List.of();
    }
    return Blog.fromBlogDtoList(blogMysqlMapper.select(BlogType.of(blogTypeList)));
  }

  public Blog getDiaryByPostedDate(@NonNull final PostedDate postedDate) {
    final BlogDto blogDto = blogMysqlMapper.getDiaryByPostedDate(postedDate.getValue());
    if(Objects.isNull(blogDto)) {
      throw new RuntimeException("no blog");
    }
    return Blog.of(blogDto);
  }
}
