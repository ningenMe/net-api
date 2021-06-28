package ningenme.net.api.application;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(staticName = "of")
public class OkResponse {
  private final String message = "ok";
}
