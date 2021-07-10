package ningenme.net.api.domain.value;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class BlogTitle {
  private final String value;
}
