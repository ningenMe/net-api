package ningenme.net.api.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.Blog;
import ningenme.net.api.domain.entity.DiaryWithAround;
import ningenme.net.api.domain.value.BlogType;
import ningenme.net.api.domain.value.PostedDate;
import ningenme.net.api.infrastructure.ameba.BlogAmebaRepository;
import ningenme.net.api.infrastructure.github.BlogGithubRepository;
import ningenme.net.api.infrastructure.hatena.BlogHatenaRepository;
import ningenme.net.api.infrastructure.mysql.BlogMysqlRepository;
import ningenme.net.api.infrastructure.qiita.BlogQiitaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogService {

  private final BlogHatenaRepository blogHatenaRepository;
  private final BlogQiitaRepository blogQiitaRepository;
  private final BlogAmebaRepository blogAmebaRepository;
  private final BlogMysqlRepository blogMysqlRepository;
  private final BlogGithubRepository blogGithubRepository;

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
    {
      log.info("process ameba start");
      final List<Blog> blogList = blogAmebaRepository.getBlog();
      blogMysqlRepository.post(blogList);
      log.info("process ameba end");
    }
  }

  public void processDiary() {
    {
      log.info("process diary start");
      final List<Blog> blogList = blogGithubRepository.getBlog();
      blogMysqlRepository.post(blogList);
      log.info("process diary end");
    }
  }

  public List<Blog> get(@NonNull final List<BlogType> blogTypeList) {
    return blogMysqlRepository.get(blogTypeList);
  }

  public void putDiaryLiked(@NonNull final PostedDate postedDate) {
    final Blog blog = blogMysqlRepository.getDiaryByPostedDate(postedDate);
    blogMysqlRepository.post(Collections.singletonList(blog.toBuilder().liked(blog.getLiked().plusOne()).build()));
    log.info(blog.getUrl().getValue()+" diary was liked");
  }

  public DiaryWithAround getDiary(@NonNull final PostedDate postedDate) {
    final List<Blog> blogList = blogMysqlRepository.get(Collections.singletonList(BlogType.DIARY));
    Blog next = null;
    Blog curr = blogList.get(0);
    Blog prev = null;
    Integer index = 0;
    for (final Blog blog: blogList) {
      if(Objects.equals(blog.getPostedDate(),postedDate)) {
        break;
      }
      index += 1;
    }
    if(index >= blogList.size()) index = 0;
    curr = blogList.get(index);
    if(index - 1 >= 0) next = blogList.get(index - 1);
    if(index + 1 < blogList.size()) prev = blogList.get(index + 1);
    return DiaryWithAround.of(prev,curr,next);
  }
}
