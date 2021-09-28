package ningenme.net.api.domain.value;

import lombok.Data;
import lombok.NonNull;

@Data
public class ComicId {
    @NonNull
    private final Integer value;

    public static ComicId of(@NonNull final Integer value) {
        return new ComicId(value);
    }
}
