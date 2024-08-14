package de.zuellich.meal_planner.pinterest.datatypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Nullable;

/**
 * A helper POJO to handle the board result wrapped in data. Jackson configuration doesn't seem so
 * simple...
 */
public class BoardRequest {

  @Nullable @JsonProperty(value = "data")
  private Board board;

  @Nullable public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }
}
