package ningenme.net.api.application.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import ningenme.net.api.application.generated.model.MonthCountView;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;

/**
 * BlogsPostedCountsGetResponseView
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-07T02:50:31.307122+09:00[Asia/Tokyo]")
public class BlogsPostedCountsGetResponseView   {
  @JsonProperty("monthCounts")
  @Valid
  private List<MonthCountView> monthCounts = null;

  public BlogsPostedCountsGetResponseView monthCounts(List<MonthCountView> monthCounts) {
    this.monthCounts = monthCounts;
    return this;
  }

  public BlogsPostedCountsGetResponseView addMonthCountsItem(MonthCountView monthCountsItem) {
    if (this.monthCounts == null) {
      this.monthCounts = new ArrayList<MonthCountView>();
    }
    this.monthCounts.add(monthCountsItem);
    return this;
  }

  /**
   * Get monthCounts
   * @return monthCounts
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<MonthCountView> getMonthCounts() {
    return monthCounts;
  }

  public void setMonthCounts(List<MonthCountView> monthCounts) {
    this.monthCounts = monthCounts;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlogsPostedCountsGetResponseView blogsPostedCountsGetResponse = (BlogsPostedCountsGetResponseView) o;
    return Objects.equals(this.monthCounts, blogsPostedCountsGetResponse.monthCounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(monthCounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlogsPostedCountsGetResponseView {\n");
    
    sb.append("    monthCounts: ").append(toIndentedString(monthCounts)).append("\n");
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

