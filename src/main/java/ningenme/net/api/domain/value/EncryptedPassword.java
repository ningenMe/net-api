package ningenme.net.api.domain.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class EncryptedPassword {

  @NonNull
  private final String value;

  private final static PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

  public static EncryptedPassword of(@NonNull final RawPassword rawPassword) {
    return new EncryptedPassword(passwordEncoder.encode(rawPassword.getValue()));
  }
  public static EncryptedPassword of(@NonNull final String password) {
    return new EncryptedPassword(password);
  }
}
