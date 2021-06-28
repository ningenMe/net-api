package ningenme.net.api.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import ningenme.net.api.application.controller.applicationMetaLatestGet.ApplicationMetaLatestGetResponse;
import ningenme.net.api.domain.value.ApplicationMetaId;
import ningenme.net.api.domain.value.CreatedTime;
import ningenme.net.api.infrastructure.mysql.dto.ApplicationMetaDto;

@Builder
@Data
public class ApplicationMeta {
  @NonNull
  private final ApplicationMetaId applicationMetaId;
  @NonNull
  private final CreatedTime createdTime;

  public ApplicationMetaLatestGetResponse getApplicationMetaLatestGetResponse() {
    return ApplicationMetaLatestGetResponse.of(applicationMetaId.getValue(), createdTime.toString());
  }

  public static ApplicationMeta of(@NonNull final ApplicationMetaDto applicationMetaDto) {
    return ApplicationMeta.builder()
                          .applicationMetaId(ApplicationMetaId.of(applicationMetaDto.getApplicationMetaId()))
                          .createdTime(CreatedTime.of(applicationMetaDto.getCreatedTime()))
                          .build();
  }
}
