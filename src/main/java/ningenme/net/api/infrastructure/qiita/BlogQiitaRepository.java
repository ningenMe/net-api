package ningenme.net.api.infrastructure.qiita;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.Blog;
import ningenme.net.api.infrastructure.qiita.mapper.BlogQiitaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class BlogQiitaRepository {

  private final BlogQiitaMapper blogQiitaMapper;

  public List<Blog> getBlog() {
    try {
      return Blog.fromBlogQiitaDtoList(blogQiitaMapper.get());
    }
    catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

}
