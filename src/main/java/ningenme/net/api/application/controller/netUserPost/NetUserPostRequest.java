package ningenme.net.api.application.controller.netUserPost;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NetUserPostRequest {
  @JsonProperty("userId")
  private String netUserId;
  @JsonProperty("password")
  private String password;
}
