package de.zuellich.meal_planner.pinterest.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.annotation.Nullable;

/** */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PinList {

  @Nullable @JsonProperty(value = "data")
  private List<Pin> pins;

  @Nullable @JsonProperty(value = "page")
  private PagingInformation page;

  @Nullable public List<Pin> getPins() {
    return pins;
  }

  public void setPins(List<Pin> pins) {
    this.pins = pins;
  }

  @Nullable public PagingInformation getPage() {
    return page;
  }

  public void setPage(PagingInformation page) {
    this.page = page;
  }
}
