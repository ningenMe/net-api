package ningenme.net.api.domain.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum NetUserRole {
  ADMIN("ADMIN"),
  USER("USER"),
  ;
  private final String value;
  public static NetUserRole of(@NonNull final String value) {
    for (NetUserRole netUserRole: NetUserRole.values()) {
      if(Objects.equals(netUserRole.getValue(),value)) {
        return netUserRole;
      }
    }
    throw new RuntimeException(value + "is an unknown net-user role name");
  }
}
