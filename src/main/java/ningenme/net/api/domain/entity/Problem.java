package ningenme.net.api.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import ningenme.net.api.domain.value.Estimation;
import ningenme.net.api.domain.value.Url;

@Data
@Builder
public class Problem {

    @NonNull
    private final Url url;
    @NonNull
    private final Estimation estimation;

    public String getJson() {
        return String.format("{\"url\":\"%s\",\"estimation\":\"%d\"}",
                             url.getValue(),
                             estimation.getValue());
    }
}
