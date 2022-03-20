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
  @JsonProperty("ningenmeMysql")
  private Boolean ningenmeMysql;

  @JsonProperty("comicmeMysql")
  private Boolean comicmeMysql;

  @JsonProperty("comproMysql")
  private Boolean comproMysql;

  public HealthCheckGetResponseView ningenmeMysql(Boolean ningenmeMysql) {
    this.ningenmeMysql = ningenmeMysql;
    return this;
  }

  /**
   * Get ningenmeMysql
   * @return ningenmeMysql
  */
  @ApiModelProperty(value = "")


  public Boolean getNingenmeMysql() {
    return ningenmeMysql;
  }

  public void setNingenmeMysql(Boolean ningenmeMysql) {
    this.ningenmeMysql = ningenmeMysql;
  }

  public HealthCheckGetResponseView comicmeMysql(Boolean comicmeMysql) {
    this.comicmeMysql = comicmeMysql;
    return this;
  }

  /**
   * Get comicmeMysql
   * @return comicmeMysql
  */
  @ApiModelProperty(value = "")


  public Boolean getComicmeMysql() {
    return comicmeMysql;
  }

  public void setComicmeMysql(Boolean comicmeMysql) {
    this.comicmeMysql = comicmeMysql;
  }

  public HealthCheckGetResponseView comproMysql(Boolean comproMysql) {
    this.comproMysql = comproMysql;
    return this;
  }

  /**
   * Get comproMysql
   * @return comproMysql
  */
  @ApiModelProperty(value = "")


  public Boolean getComproMysql() {
    return comproMysql;
  }

  public void setComproMysql(Boolean comproMysql) {
    this.comproMysql = comproMysql;
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
    return Objects.equals(this.ningenmeMysql, healthCheckGetResponse.ningenmeMysql) &&
        Objects.equals(this.comicmeMysql, healthCheckGetResponse.comicmeMysql) &&
        Objects.equals(this.comproMysql, healthCheckGetResponse.comproMysql);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ningenmeMysql, comicmeMysql, comproMysql);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealthCheckGetResponseView {\n");
    
    sb.append("    ningenmeMysql: ").append(toIndentedString(ningenmeMysql)).append("\n");
    sb.append("    comicmeMysql: ").append(toIndentedString(comicmeMysql)).append("\n");
    sb.append("    comproMysql: ").append(toIndentedString(comproMysql)).append("\n");
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

