package de.zuellich.meal_planner.pinterest.datatypes;

import java.util.List;
import javax.annotation.Nullable;

/**
 * Represents the listing of a board. Includes the board with its information and the list of pins
 * included.
 */
public class BoardListing {

  @Nullable private Board board;

  @Nullable private List<Pin> pins;

  @Nullable public Board getBoard() {
    return board;
  }

  public void setBoard(@Nullable Board board) {
    this.board = board;
  }

  @Nullable public List<Pin> getPins() {
    return pins;
  }

  public void setPins(List<Pin> pins) {
    this.pins = pins;
  }
}
