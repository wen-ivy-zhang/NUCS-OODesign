package edu.neu.ccs.cs5004.battleship.model;

import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;

import java.util.List;



/**
 * Represents a 10 x 10 map in the battleship game.
 */
public interface IMap {

  /**
   * Creates an empty map.
   * @return an empty map.
   */
  static IMap createEmptyMap() {
    return new Map();
  }

  /**
   * Getter for property cells.
   *
   * @return value for property cells.
   */
  Cell[][] getCells();


  /**
   * Get a cell from the map at the specific position on the map.
   *
   * @param posn represents the position on the map.
   * @return the cell at specific position.
   */
  Cell getCell(Position posn);


  /**
   * Update a cell on the map at the specific position with {@code newCell}.
   *
   * @param posn represents the position on the map.
   * @param newCell represents the new cell to be on the updated map
   */
  void setCell(Position posn, Cell newCell);

  /**
   * Print the map to the console.
   *
   * @param printer represents the {@code printer} used to print the map
   */
  void prettyPrint(IConsolePrinter printer);


  /**
   * Place a ship on the map.
   * @param posn the position of the top left cell of the ship.
   * @param direction the direction of the ship
   * @param ship the ship to be placed on map
   *
   * @throws InvalidArgumentException when it's not valid to place ship on the given position.
   */
  void placeShipOnMap(Position posn, Direction direction, Ship ship);

  /**
   * Get the positions of neighbor cells of the given cell.
   * @param posn represents the given cell.
   * @return the positions of given cell's neighbors.
   */
  List<Position> getNeighborCells(Position posn);
}
