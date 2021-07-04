package ningenme.net.api.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.application.controller.netUserPost.NetUserPostRequest;
import ningenme.net.api.domain.value.EncryptedPassword;
import ningenme.net.api.domain.value.NetUserId;
import ningenme.net.api.domain.value.NetUserRole;
import ningenme.net.api.domain.value.RawPassword;
import ningenme.net.api.infrastructure.mysql.dto.NetUserDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Data
@Builder(access = AccessLevel.PRIVATE)
@Slf4j
public class NetUser {
  @NonNull
  private final NetUserId netUserId;
  @NonNull
  private final NetUserRole netUserRole;
  private final EncryptedPassword encryptedPassword;

  public static NetUser of(@NonNull final NetUserPostRequest netUserPostRequest) {
    return NetUser
            .builder()
            .netUserId(NetUserId.of(netUserPostRequest.getNetUserId()))
            .netUserRole(NetUserRole.USER)
            .encryptedPassword(EncryptedPassword.of(RawPassword.of(netUserPostRequest.getPassword())))
            .build();
  }

  public static NetUser of(@NonNull final NetUserDto netUserDto) {
    return NetUser
            .builder()
            .netUserId(NetUserId.of(netUserDto.getNetUserId()))
            .netUserRole(NetUserRole.of(netUserDto.getRole()))
            .encryptedPassword(EncryptedPassword.of(RawPassword.of(netUserDto.getPassword())))
            .build();
  }

  public User getUser() {
    return new User(netUserId.getValue(),
                    encryptedPassword.getValue(),
                    AuthorityUtils.createAuthorityList(netUserRole.getValue()));
  }

  public UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken() {
    return new UsernamePasswordAuthenticationToken(
            netUserId.getValue(),
            null,
            AuthorityUtils.createAuthorityList(netUserRole.getValue())
    );
  }
}
