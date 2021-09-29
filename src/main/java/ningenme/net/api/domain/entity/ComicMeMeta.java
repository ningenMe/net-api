package ningenme.net.api.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ComicMeMeta {
    @NonNull
    private final Integer publisherCount;
    @NonNull
    private final Integer creatorCount;
    @NonNull
    private final Integer workCount;
    @NonNull
    private final Integer comicCount;
}
