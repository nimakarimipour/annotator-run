package de.zuellich.meal_planner.pinterest.datatypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.annotation.Nullable;

/** Represents a list of boards. Helper for JSON serialization. */
public class BoardList {

  @Nullable @JsonProperty(value = "data")
  private List<Board> boards;

  @Nullable public List<Board> getBoards() {
    return boards;
  }

  public void setBoards(List<Board> boards) {
    this.boards = boards;
  }
}
