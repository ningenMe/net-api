package ningenme.net.api.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import ningenme.net.api.application.controller.netUserPost.NetUserPostRequest;
import ningenme.net.api.domain.value.EncryptedPassword;
import ningenme.net.api.domain.value.NetUserId;
import ningenme.net.api.domain.value.RawPassword;

@Data
@Builder
public class NetUser {
  @NonNull
  private final NetUserId netUserId;
  private final EncryptedPassword encryptedPassword;

  public static NetUser of(@NonNull final NetUserPostRequest netUserPostRequest) {
    return NetUser
            .builder()
            .netUserId(NetUserId.of(netUserPostRequest.getNetUserId()))
            .encryptedPassword(EncryptedPassword.of(RawPassword.of(netUserPostRequest.getPassword())))
            .build();
  }
}
