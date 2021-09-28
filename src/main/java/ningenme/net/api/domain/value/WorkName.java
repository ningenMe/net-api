package ningenme.net.api.domain.value;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class WorkName {
    @NonNull
    private final String value;
}
