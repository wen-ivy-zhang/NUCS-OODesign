package edu.neu.ccs.cs5004.battleship.model;


/**
 * Represents the sunk attack result.
 */
public class Sunk implements AttackResult{

  /**
   * Get the result after attacking a cell as a string.
   *
   * @return attack result as a string
   */
  @Override
  public String getAttackResult() {
    return "Sunk – the cell is a part of the ship and all the other cells of the ship were hit";
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
    return 5;
  }

  @Override
  public String toString() {
    return "Sunk{}";
  }
}
