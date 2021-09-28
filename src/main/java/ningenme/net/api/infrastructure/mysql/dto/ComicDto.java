package ningenme.net.api.infrastructure.mysql.dto;

import lombok.Data;
import lombok.NonNull;
import ningenme.net.api.domain.entity.Comic;
import ningenme.net.api.domain.value.ComicId;
import ningenme.net.api.domain.value.ComicName;
import ningenme.net.api.domain.value.Isbn13;
import ningenme.net.api.domain.value.PublishedDate;
import ningenme.net.api.domain.value.Url;
import ningenme.net.api.domain.value.WorkId;

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

    private Comic getComic() {
        return new Comic(
                ComicId.of(comicId),
                Isbn13.of(isbn13),
                Url.of(url),
                WorkId.of(workId),
                ComicName.of(comicName),
                PublishedDate.of(publishedDate)
        );
    }

    public static List<Comic> getComicList(@NonNull final List<ComicDto> comicDtoList) {
        return comicDtoList.stream().map(ComicDto::getComic).collect(Collectors.toList());
    }
}
