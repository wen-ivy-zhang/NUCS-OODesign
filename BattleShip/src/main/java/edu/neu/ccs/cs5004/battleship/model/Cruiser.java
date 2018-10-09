package edu.neu.ccs.cs5004.battleship.model;

/**
 * Represents a Cruiser in the battleship game.
 */
public class Cruiser extends AbstractShip {

  /**
   * Creates a cruiser.
   * @param size number of cells that a cruiser occupies, which is 3
   * @param numOfHitCells the number of cells that were hit, which is betwwen 0 and 3 inclusively
   */
  public Cruiser(Integer size, Integer numOfHitCells) {
    super(size, numOfHitCells);
  }

  /**
   * Creates a cruiser with default size 3.
   */
  public Cruiser() {
    super(3,0);
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
    return "Cruiser{} " + super.toString();
  }
}
