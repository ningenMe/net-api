package ningenme.net.api.application.controller.comic.isbnGet;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.Comic;

import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class IsbnGetResponse {

  private final List<ComicDto> comics;

  public static IsbnGetResponse of(@NonNull final List<Comic> comicList) {
    return new IsbnGetResponse(ComicDto.of(comicList));
  }

}
