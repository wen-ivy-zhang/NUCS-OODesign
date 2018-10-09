package edu.neu.ccs.cs5004.battleship.model;

/**
 * Represents a destroyer in the battleship game.
 */
public class Destroyer extends AbstractShip {

  /**
   * Creates a destroyer.
   * @param size number of cells that a destroyer occupies, which is 1
   * @param numOfHitCells the number of cells that were hit, which is betwwen 0 and 1 inclusively
   */
  public Destroyer(Integer size, Integer numOfHitCells) {
    super(size, numOfHitCells);
  }

  /**
   * Creates a destroyer with default size 1.
   */
  public Destroyer() {
    super(1, 0);
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
    result = 11 * result + 11;
    return result;
  }

  @Override
  public String toString() {
    return "Destroyer{} " + super.toString();
  }
}
