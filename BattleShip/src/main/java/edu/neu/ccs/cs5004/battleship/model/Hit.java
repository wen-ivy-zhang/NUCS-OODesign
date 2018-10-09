package edu.neu.ccs.cs5004.battleship.model;


/**
 * Represents the hit attack result.
 */
public class Hit implements AttackResult {

  /**
   * Get the result after attacking a cell as a string.
   *
   * @return attack result as a string
   */
  @Override
  public String getAttackResult() {
    return "Hit – the cell is a part of the ship, but there are other cells that have not been "
        + "hit yet";
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public int hashCode() {
    return 23;
  }

  @Override
  public String toString() {
    return "Hit{}";
  }
}
