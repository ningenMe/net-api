package ningenme.net.api.application.controller.applicationMeta.latestGetDto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ApplicationMeta;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class ApplicationMetaLatestGetResponse {
  private final String applicationMetaId;
  private final String updateTime;

  public static ApplicationMetaLatestGetResponse of(@NonNull final ApplicationMeta applicationMeta) {
    return new ApplicationMetaLatestGetResponse(applicationMeta.getApplicationMetaId().getValue(),
                                                applicationMeta.getCreatedTime().toString());
  }
}
