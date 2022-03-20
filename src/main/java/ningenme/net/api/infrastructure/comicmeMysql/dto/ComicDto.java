package ningenme.net.api.infrastructure.comicmeMysql.dto;

import lombok.Data;
import lombok.NonNull;
import ningenme.net.api.domain.entity.Comic;
import ningenme.net.api.domain.value.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ComicDto {
    private Integer comicId;
    private String isbn13;
    private String url;
    private Integer workId;
    private String comicName;
    private LocalDate publishedDate;
    private String workName;
    private String publisherName;

    public static List<Comic> getComicList(@NonNull final List<ComicDto> comicDtoList) {
        return comicDtoList.stream().map(ComicDto::getComic).collect(Collectors.toList());
    }

    private Comic getComic() {
        return new Comic(
            ComicId.of(comicId),
            Isbn13.of(isbn13),
            Url.of(url),
            WorkId.of(workId),
            ComicName.of(comicName),
            PublishedDate.of(publishedDate),
            WorkName.of(workName),
            PublisherName.of(publisherName)
        );
    }
}
