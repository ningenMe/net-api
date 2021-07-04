package ningenme.net.api.domain.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import java.util.regex.Pattern;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class NetUserId {
  private static final Pattern REGEX_PATTERN = Pattern.compile("^[a-z0-9_]{3,20}$");

  private final String value;
  public static NetUserId of(@NonNull final String value) {
    if (!REGEX_PATTERN.matcher(value).matches()) {
      throw new IllegalArgumentException(value + " is invalid netUserId");
    }
    return new NetUserId(value);
  }

  public static NetUserId of(@NonNull final Authentication authentication) {
    final String value = ((User) authentication.getPrincipal()).getUsername();
    return NetUserId.of(value);
  }
}
