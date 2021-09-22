package ningenme.net.api.application.controller.problemPut;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProblemPutRequest {
  @JsonProperty("url")
  private String url;
  @JsonProperty("estimation")
  private Integer estimation;
}
