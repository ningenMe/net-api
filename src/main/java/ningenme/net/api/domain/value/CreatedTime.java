package ningenme.net.api.domain.value;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor(staticName = "of")
public class CreatedTime {
  @NonNull
  private final LocalDateTime value;

  @Override
  public String toString() {
    return value.toString();
  }
}
