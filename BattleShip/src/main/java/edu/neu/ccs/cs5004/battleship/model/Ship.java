package edu.neu.ccs.cs5004.battleship.model;

/**
 * Represent a ship in the battleship game.
 */
public interface Ship {

  /**
   * Increase the number of hit cells by 1 if that number is still less than the ship's size.
   */
  void hitShip();

  /**
   * Returns true is the ship has been sunk and false otherwise.
   * @return true is the ship has been sunk and false otherwise
   */
  Boolean isSunk();

  /**
   * Getter for property size.
   * @return value for property size
   */
  Integer getSize();

  /**
   * Getter for property number of hit cells.
   * @return value for property number of hit cells
   */
  Integer getNumOfHitCells();
}
