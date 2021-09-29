package ningenme.net.api.application.controller.comicMe.metaGet;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ComicMeMeta;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class ComicMeMetaGetResponse {

    private final Integer publisherCount;
    private final Integer creatorCount;
    private final Integer workCount;
    private final Integer comicCount;

    public static ComicMeMetaGetResponse of(@NonNull final ComicMeMeta comicMeMeta) {
        return new ComicMeMetaGetResponse(
            comicMeMeta.getPublisherCount(),
            comicMeMeta.getCreatorCount(),
            comicMeMeta.getWorkCount(),
            comicMeMeta.getComicCount()
        );
    }

}
