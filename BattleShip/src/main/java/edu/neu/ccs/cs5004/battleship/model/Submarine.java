package edu.neu.ccs.cs5004.battleship.model;

/**
 * Represents a Submarine in the battleship game.
 */
public class Submarine extends AbstractShip {

  /**
   * Creates a submarine.
   * @param size number of cells that a submarine occupies, which is 2
   * @param numOfHitCells the number of cells that were hit, which is betwwen 0 and 2 inclusively
   */
  public Submarine(Integer size, Integer numOfHitCells) {
    super(size, numOfHitCells);
  }

  /**
   * Creates a submarine with default size 2.
   */
  public Submarine() {
    super(2, 0);
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
    return "Submarine{} " + super.toString();
  }
}


