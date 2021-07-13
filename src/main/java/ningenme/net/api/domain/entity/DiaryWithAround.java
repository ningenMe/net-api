package ningenme.net.api.domain.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class DiaryWithAround {
  private final Blog prevBlog;
  @NonNull
  private final Blog currBlog;
  private final Blog nextBlog;
}
