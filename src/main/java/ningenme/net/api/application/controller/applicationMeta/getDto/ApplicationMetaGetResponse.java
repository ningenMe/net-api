package ningenme.net.api.application.controller.applicationMeta.getDto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.ApplicationMeta;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class ApplicationMetaGetResponse {
  private final List<ApplicationMetaDto> applicationMetas;

  public static ApplicationMetaGetResponse of(@NonNull final List<ApplicationMeta> applicationMetas) {
    return new ApplicationMetaGetResponse(
            applicationMetas.stream()
                            .map(ApplicationMetaDto::of)
                            .collect(Collectors.toList())
    );
  }
}
