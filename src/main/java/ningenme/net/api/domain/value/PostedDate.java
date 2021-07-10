package ningenme.net.api.domain.value;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor(staticName = "of")
public class PostedDate {
  @NonNull
  private final LocalDate value;
}
