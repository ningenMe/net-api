package ningenme.net.api.application.controller.diaryGet;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.controller.diaryGet.dto.BlogDto;
import ningenme.net.api.domain.entity.Blog;

import java.util.Optional;


@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class DiaryGetResponse {

  private final BlogDto prev;
  private final BlogDto curr;
  private final BlogDto next;

  public static DiaryGetResponse of(
          final Blog prevBlog,
          @NonNull final Blog currBlog,
          final Blog nextBlog
                                   ) {
    return new DiaryGetResponse(
            Optional.ofNullable(prevBlog).map(BlogDto::of).orElse(null),
            BlogDto.of(currBlog),
            Optional.ofNullable(nextBlog).map(BlogDto::of).orElse(null)
    );
  }

}
