package ningenme.net.api.domain.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class NetUserId {
  private static final Pattern REGEX_PATTERN = Pattern.compile("^[a-zA-Z0-9]{1,100}$");

  private final String value;
  public static NetUserId of(@NonNull final String value) {
    if (!REGEX_PATTERN.matcher(value).matches()) {
      throw new IllegalArgumentException("invalid netUserId");
    }
    return new NetUserId(value);
  }
}
