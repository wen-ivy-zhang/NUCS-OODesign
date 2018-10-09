package edu.neu.ccs.cs5004.battleship.model;

/**
 * Represents the miss attack result.
 */
public class Miss implements AttackResult {
  /**
   * Get the result after attacking a cell as a string.
   *
   * @return attack result as a string
   */
  @Override
  public String getAttackResult() {
    return "Miss – the guessed cell does not contain a ship";
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
    return 3;
  }

  @Override
  public String toString() {
    return "Miss{}";
  }
}
