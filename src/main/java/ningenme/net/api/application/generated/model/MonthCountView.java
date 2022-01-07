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
 * MonthCountView
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class MonthCountView   {
  @JsonProperty("month")
  private String month;

  @JsonProperty("count")
  private Integer count;

  public MonthCountView month(String month) {
    this.month = month;
    return this;
  }

  /**
   * Get month
   * @return month
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Pattern(regexp = "^\\d{4}-(0[1-9]|1[012])$") 
  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public MonthCountView count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * minimum: 0
   * @return count
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Min(0) 
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MonthCountView monthCount = (MonthCountView) o;
    return Objects.equals(this.month, monthCount.month) &&
        Objects.equals(this.count, monthCount.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(month, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MonthCountView {\n");
    
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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

