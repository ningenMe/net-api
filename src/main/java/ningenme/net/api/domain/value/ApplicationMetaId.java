package ningenme.net.api.domain.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApplicationMetaId {
  NET_API("net-api"),
  NET_FRONT("net-front"),
  ;
  @NonNull
  private final String value;

  public static ApplicationMetaId of(final String value) {
    for (ApplicationMetaId applicationMetaId : ApplicationMetaId.values()) {
      if(Objects.equals(value, applicationMetaId.getValue())) {
        return applicationMetaId;
      }
    }
    throw new RuntimeException(value + "is an unknown application name");
  }
}
