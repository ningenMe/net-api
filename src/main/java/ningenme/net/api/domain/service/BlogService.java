package ningenme.net.api.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.Blog;
import ningenme.net.api.domain.value.BlogType;
import ningenme.net.api.infrastructure.hatena.BlogHatenaRepository;
import ningenme.net.api.infrastructure.mysql.BlogMysqlRepository;
import ningenme.net.api.infrastructure.qiita.BlogQiitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogService {

  private final BlogHatenaRepository blogHatenaRepository;
  private final BlogQiitaRepository blogQiitaRepository;
  private final BlogMysqlRepository blogMysqlRepository;

  public void processBlog() {
    {
      log.info("process hatena start");
      final List<Blog> blogList = blogHatenaRepository.getBlog();
      blogMysqlRepository.post(blogList);
      log.info("process hatena end");
    }
    {
      log.info("process qiita start");
      final List<Blog> blogList = blogQiitaRepository.getBlog();
      blogMysqlRepository.post(blogList);
      log.info("process qiita end");
    }
  }

  public List<Blog> get(@NonNull final List<BlogType> blogTypeList) {
    return blogMysqlRepository.get(blogTypeList);
  }
}
