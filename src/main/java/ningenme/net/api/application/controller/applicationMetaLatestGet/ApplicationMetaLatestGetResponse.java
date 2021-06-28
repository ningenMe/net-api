package ningenme.net.api.application.controller.applicationMetaLatestGet;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Data
public class ApplicationMetaLatestGetResponse {
  private final String applicationMetaId;
  private final String updateTime;
}
