package ningenme.net.api.application.controller.applicationMeta.getDto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ApplicationMeta;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationMetaDto {
  private final String applicationMetaId;
  private final String updateTime;

  public static ApplicationMetaDto of(@NonNull final ApplicationMeta applicationMeta) {
    return new ApplicationMetaDto(applicationMeta.getApplicationMetaId().getValue(),
                                  applicationMeta.getCreatedTime().toString());
  }

}
