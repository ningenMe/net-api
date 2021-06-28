package ningenme.net.api.domain.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class RawPassword {
  @NonNull
  private final String value;

  private static final Pattern REGEX_PATTERN = Pattern.compile("^[a-zA-Z0-9]{8,100}$");
  private static final Pattern REGEX_PATTERN_NO_DIGIT = Pattern.compile("[A-Za-z]+");
  private static final Pattern REGEX_PATTERN_NO_LOWER = Pattern.compile("[A-Z0-9]+");
  private static final Pattern REGEX_PATTERN_NO_UPPER = Pattern.compile("[a-z0-9]+");


  public static RawPassword of(@NonNull final String value) {

    if (!REGEX_PATTERN.matcher(value).matches()) {
      throw new IllegalArgumentException("invalid password");
    }

    if (
            REGEX_PATTERN_NO_DIGIT.matcher(value).matches()
            || REGEX_PATTERN_NO_LOWER.matcher(value).matches()
            || REGEX_PATTERN_NO_UPPER.matcher(value).matches()
    ) {
      throw new IllegalArgumentException("invalid password");
    }

    return new RawPassword(value);
  }
}
