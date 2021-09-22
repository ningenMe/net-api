package ningenme.net.api.domain.value;

import lombok.Data;
import lombok.NonNull;

@Data
public class Estimation {
    private final Integer value;

    public static Estimation of(@NonNull final Integer value) {
        return new Estimation(Math.max(value, 0));
    }
}
