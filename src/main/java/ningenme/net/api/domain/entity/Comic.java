package ningenme.net.api.domain.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.ComicId;
import ningenme.net.api.domain.value.ComicName;
import ningenme.net.api.domain.value.Isbn13;
import ningenme.net.api.domain.value.PublishedDate;
import ningenme.net.api.domain.value.Url;
import ningenme.net.api.domain.value.WorkId;

@Data
@RequiredArgsConstructor
public class Comic {
    @NonNull
    private final ComicId comicId;
    @NonNull
    private final Isbn13 isbn13;
    @NonNull
    private final Url url;
    @NonNull
    private final WorkId workId;
    @NonNull
    private final ComicName comicName;
    @NonNull
    private final PublishedDate publishedDate;
}
