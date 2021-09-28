package ningenme.net.api.domain.value;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Data
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PublishedDate {
  @NonNull
  private final LocalDate value;

  public static PublishedDate of(@NonNull final LocalDate value) {
    return new PublishedDate(value);
  }

}
