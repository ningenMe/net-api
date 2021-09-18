package ningenme.net.api.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.Blog;
import ningenme.net.api.domain.entity.DiaryWithAround;
import ningenme.net.api.domain.value.BlogType;
import ningenme.net.api.domain.value.PostedDate;
import ningenme.net.api.infrastructure.mysql.BlogMysqlRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogService {

  private final BlogMysqlRepository blogMysqlRepository;

  public List<Blog> get(@NonNull final List<BlogType> blogTypeList) {
    return blogMysqlRepository.get(blogTypeList);
  }

  public void putDiaryLiked(@NonNull final PostedDate postedDate) {
    final Blog blog = blogMysqlRepository.getDiaryByPostedDate(postedDate);
    blogMysqlRepository.put(Collections.singletonList(blog.toBuilder().liked(blog.getLiked().plusOne()).build()));
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
