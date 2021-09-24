package ningenme.net.api.application.controller.netUser.postDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NetUserPostRequest {
  @JsonProperty("userId")
  private String netUserId;
  @JsonProperty("password")
  private String password;
}
