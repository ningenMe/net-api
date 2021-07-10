package ningenme.net.api.infrastructure.qiita.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BlogQiitaDto {
  @SerializedName("title")
  String title;
  @SerializedName("url")
  String url;
  @SerializedName("created_at")
  String postedTime;
}
