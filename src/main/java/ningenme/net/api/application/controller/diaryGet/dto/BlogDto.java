package ningenme.net.api.application.controller.diaryGet.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.Blog;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BlogDto {
  private final String url;
  private final String type;
  private final String date;
  private final String title;
  private final Integer liked;

  public static BlogDto of(@NonNull final Blog blog) {
    return new BlogDto(
            blog.getUrl().getValue(),
            blog.getBlogType().getValue(),
            blog.getPostedDate().getValue().toString(),
            blog.getBlogTitle().getValue(),
            blog.getLiked().getValue()
    );
  }
}
