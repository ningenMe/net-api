package ningenme.net.api.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.value.BlogTitle;
import ningenme.net.api.domain.value.BlogType;
import ningenme.net.api.domain.value.PostedDate;
import ningenme.net.api.domain.value.Url;
import ningenme.net.api.infrastructure.mysql.dto.BlogDto;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@Slf4j
public class Blog {
  @NonNull
  private final BlogType blogType;
  @NonNull
  private final BlogTitle blogTitle;
  @NonNull
  private final PostedDate postedDate;
  @NonNull
  private final Url url;

  private BlogDto getBlogDto() {
    BlogDto blogDto = new BlogDto();
    {
      blogDto.setBlogType(blogType.getValue());
      blogDto.setBlogTitle(blogTitle.getValue());
      blogDto.setPostedDate(postedDate.getValue());
      blogDto.setUrl(url.getValue());
    }
    return blogDto;
  }

  private static Blog of(@NonNull final BlogDto blogDto) {
    log.info(blogDto.toString());
    return Blog.builder()
               .blogType(BlogType.of(blogDto.getBlogType()))
               .blogTitle(BlogTitle.of(blogDto.getBlogTitle()))
               .postedDate(PostedDate.of(blogDto.getPostedDate()))
               .url(Url.of(blogDto.getUrl()))
               .build();
  }

  public static List<BlogDto> getBlogDtoList(@NonNull final List<Blog> blogList) {
    return blogList.stream()
                   .map(Blog::getBlogDto)
                   .collect(Collectors.toList());
  }

  public static List<Blog> of(@NonNull final List<BlogDto> blogDtoList) {
    return blogDtoList.stream()
                      .map(Blog::of)
                      .collect(Collectors.toList());
  }
}
