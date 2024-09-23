package de.zuellich.meal_planner.pinterest.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.annotation.Nullable;

/** */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PagingInformation {

  @Nullable private String cursor;

  @Nullable private String next;

  @Nullable public String getCursor() {
    return cursor;
  }

  public void setCursor(String cursor) {
    this.cursor = cursor;
  }

  @Nullable public String getNext() {
    return next;
  }

  public void setNext(String next) {
    this.next = next;
  }
}
