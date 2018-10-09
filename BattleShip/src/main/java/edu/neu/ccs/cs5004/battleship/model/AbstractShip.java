package edu.neu.ccs.cs5004.battleship.model;

import java.util.Objects;

/**
 * Represents the comman properties of ship in battleship game.
 */
public abstract class AbstractShip implements Ship{

  private Integer size;
  private Integer numOfHitCells;

  /**
   * Creates a ship.
   * @param size the number of cells a ship has, which is greater than 0 and less or equal to 4
   * @param numOfHitCells the number of cells that were hit, which is greater than 0 and less or
   *                      equal to ship size
   */
  public AbstractShip(Integer size, Integer numOfHitCells) {
    this.size = size;
    this.numOfHitCells = numOfHitCells;
  }

  /**
   * Getter for property size.
   * @return value for property size
   */
  public Integer getSize() {
    return size;
  }

  /**
   * Getter for property number of hit cells.
   * @return value for property number of hit cells
   */
  public Integer getNumOfHitCells() {
    return numOfHitCells;
  }

  /**
   * Setter for property num of hit cells.
   * @param numOfHitCells the value to set for property num of hit cells.
   */
  public void setNumOfHitCells(Integer numOfHitCells) {
    this.numOfHitCells = numOfHitCells;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    AbstractShip that = (AbstractShip) object;
    return Objects.equals(getSize(), that.getSize())
        && Objects.equals(getNumOfHitCells(), that.getNumOfHitCells());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getSize(), getNumOfHitCells());
  }

  @Override
  public String toString() {
    return "AbstractShip{"
        + "size=" + size
        + ", numOfHitCells=" + numOfHitCells
        + '}';
  }

  /**
   * Returns true is the ship has been sunk and false otherwise.
   *
   * @return true is the ship has been sunk and false otherwise
   */
  @Override
  public Boolean isSunk() {
    if (getNumOfHitCells().equals(getSize())) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Increase the number of hit cells by 1 if that number is still less than the ship's size.
   */
  public void hitShip() {
    if (getNumOfHitCells() < getSize()) {
      numOfHitCells = getNumOfHitCells() + 1;
    }
  }
}
