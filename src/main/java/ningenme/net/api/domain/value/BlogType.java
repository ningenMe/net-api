package ningenme.net.api.domain.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum BlogType {
  HATENA("HATENA"),
  QIITA("QIITA"),
  AMEBA("AMEBA"),
  NINGENME_NET("NINGENME_NET"),
  ;
  private final String value;
  public static BlogType of(@NonNull final String value) {
    for (BlogType blogType: BlogType.values()) {
      if(Objects.equals(blogType.getValue(),value)) {
        return blogType;
      }
    }
    throw new RuntimeException(value + "is an unknown blog type");
  }
}
