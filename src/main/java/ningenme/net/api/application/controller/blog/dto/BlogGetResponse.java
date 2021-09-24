package ningenme.net.api.application.controller.blog.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.Blog;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class BlogGetResponse {

  private final List<BlogDto> blogs;

  public static BlogGetResponse of(@NonNull final List<Blog> blogList) {
    return new BlogGetResponse(
            blogList.stream().map(BlogDto::of)
                    .collect(Collectors.toList())
    );
  }

}
