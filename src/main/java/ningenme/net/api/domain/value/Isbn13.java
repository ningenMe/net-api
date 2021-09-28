package ningenme.net.api.domain.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Isbn13 {
  private static final Pattern REGEX_PATTERN = Pattern.compile("^[0-9]{13}$");

  @NonNull
  private final String value;

  public static Isbn13 of(@NonNull final String value) {
    if (!REGEX_PATTERN.matcher(value).matches()) {
      throw new IllegalArgumentException(value + " is invalid isbn13");
    }
    return new Isbn13(value);
  }

  public static List<Isbn13> of(@NonNull final List<String> valueList) {
      return valueList.stream().map(Isbn13::of).collect(Collectors.toList());
  }

}
