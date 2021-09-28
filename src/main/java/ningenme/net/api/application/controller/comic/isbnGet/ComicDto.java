package ningenme.net.api.application.controller.comic.isbnGet;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.Comic;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ComicDto {

    private final Integer comicId;
    private final String isbn13;
    private final String url;
    private final Integer workId;
    private final String comicName;
    private final LocalDate publishedDate;

    private static ComicDto of(@NonNull final Comic comic) {
        return new ComicDto(
            comic.getComicId().getValue(),
            comic.getIsbn13().getValue(),
            comic.getUrl().getValue(),
            comic.getWorkId().getValue(),
            comic.getComicName().getValue(),
            comic.getPublishedDate().getValue()
        );
    }

    public static List<ComicDto> of(@NonNull final List<Comic> comicList) {
        return comicList.stream().map(ComicDto::of).collect(Collectors.toList());
    }
}
