package edu.neu.ccs.cs5004.battleship.model;

import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;

import java.util.List;



/**
 * Represents a cell in the map of a battle ship game.
 */
public interface Cell {

  /**
   * Return true if a ship could be placed on the cell and false otherwise.
   * @return true if a ship could be placed on the cell and false otherwise
   */
  Boolean placeShipOnCell();

  /**
   * Return the cell after attack.
   * @return updated cell after attack
   */
  Cell attackCell();

  /**
   * Get the result of attack a cell.
   * @return the result of attack a cell.
   */
  AttackResult attackResult();

  /**
   * Getter for property isHit.
   * @return the value for property isHit
   */
  Boolean getIsHit();

  /**
   * Getter for property isSunk.
   * @return value for property isSunk
   */
  Boolean getIsSunk();

  /**
   * Mark the ship cell as sunk.
   */
  void markCellSunk();

  /**
   * Setter for property cell observers.
   * @param cellObeservers value to set for property cell observers.
   */
  void setCellObeservers(List<Cell> cellObeservers);

  /**

   * Print the cell to the console.
   *
   * @param printer represents the {@code printer} used to print the cell
   */
  void prettyPrint(IConsolePrinter printer);

  /**
   * Notify the observers of the cell.
   */
  void notifyObserver();

  /**
   * Update the observer.
   */
  void update();


}
