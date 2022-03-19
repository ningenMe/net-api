package ningenme.net.api.application.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * HealthCheckGetResponseView
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class HealthCheckGetResponseView   {
  @JsonProperty("mysql")
  private Boolean mysql;

  public HealthCheckGetResponseView mysql(Boolean mysql) {
    this.mysql = mysql;
    return this;
  }

  /**
   * Get mysql
   * @return mysql
  */
  @ApiModelProperty(value = "")


  public Boolean getMysql() {
    return mysql;
  }

  public void setMysql(Boolean mysql) {
    this.mysql = mysql;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HealthCheckGetResponseView healthCheckGetResponse = (HealthCheckGetResponseView) o;
    return Objects.equals(this.mysql, healthCheckGetResponse.mysql);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mysql);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealthCheckGetResponseView {\n");
    
    sb.append("    mysql: ").append(toIndentedString(mysql)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

