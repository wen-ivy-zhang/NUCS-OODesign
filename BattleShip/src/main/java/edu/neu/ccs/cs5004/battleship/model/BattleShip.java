package edu.neu.ccs.cs5004.battleship.model;

/**
 * Represents a battleship in the battleship game.
 */
public class BattleShip extends AbstractShip {

  /**
   * Creates a battleship.
   * @param size number of cells that a battleship occupies, which is 4
   * @param numOfHitCells the number of cells that were hit, which is betwwen 0 and 4 inclusively
   */
  public BattleShip(Integer size, Integer numOfHitCells) {
    super(size, numOfHitCells);
  }

  /**
   * Creates a battleship with default size 4.
   */
  public BattleShip() {
    super(4, 0);
  }

  @Override
  public boolean equals(Object object) {
    if (!super.equals(object)) {
      return false;
    }
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 7 * result + 7;
    return result;
  }

  @Override
  public String toString() {
    return "BattleShip{} " + super.toString();
  }

}
