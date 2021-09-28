package ningenme.net.api.domain.value;

import lombok.Data;
import lombok.NonNull;

@Data
public class WorkId {
    @NonNull
    private final Integer value;

    public static WorkId of(@NonNull final Integer value) {
        return new WorkId(value);
    }
}
