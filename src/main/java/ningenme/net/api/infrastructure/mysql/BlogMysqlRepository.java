package ningenme.net.api.infrastructure.mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.Blog;
import ningenme.net.api.infrastructure.mysql.mapper.BlogMysqlMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BlogMysqlRepository {
  private final BlogMysqlMapper blogMysqlMapper;

  public void post(@NonNull final List<Blog> blogList) {
    if(CollectionUtils.isEmpty(blogList)) {
      return;
    }
    blogMysqlMapper.insert(Blog.getBlogDtoList(blogList));
  }
}
