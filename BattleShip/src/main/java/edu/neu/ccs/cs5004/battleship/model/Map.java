package edu.neu.ccs.cs5004.battleship.model;

import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;

import java.util.ArrayList;
import java.util.List;



/**
 * Represents a 10 x 10 map in the battleship game.
 */
public class Map implements IMap {

  private static final int MAP_HEIGHT = 10;
  private static final int MAP_WIDTH = 10;
  private Cell[][] cells;

  /**
   * Creates a new map with only water cells.
   */
  public Map() {
    this.cells = new Cell[MAP_HEIGHT][MAP_WIDTH];
    for (int i = 0; i < MAP_HEIGHT; i++) {
      for (int j = 0; j < MAP_WIDTH; j++) {
        cells[i][j] = new OpenSeaCell(false);
      }
    }

    for (int i = 0; i < MAP_HEIGHT; i++) {
      for (int j = 0; j < MAP_WIDTH; j++) {
        Position posn = new Position(i, j);
        setNeighborAsObservers(posn);
      }
    }
  }


  /**
   * Getter for property cells.
   *
   * @return value for property cells.
   */
  public Cell[][] getCells() {
    Cell[][] copyCells = new Cell[MAP_HEIGHT][MAP_WIDTH];
    for (int i = 0; i < MAP_HEIGHT; i++) {
      for (int j = 0; j < MAP_WIDTH; j++) {
        copyCells[i][j] = cells[i][j];
      }
    }
    return copyCells;
  }

  /**
   * Get a cell from the map at the specific position.
   *
   * @param posn represents the position on the column
   * @return the cell at specific position.
   */
  @Override
  public Cell getCell(Position posn) {
    return cells[posn.getRowIndex()][posn.getColumnIndex()];
  }

  /**
   * Update a cell on the map at the specific position with {@code newCell}.
   *
   * @param posn represents the position on the column
   * @param newCell represents the new cell to be on the updated map
   */
  @Override
  public void setCell(Position posn, Cell newCell) {
    this.cells[posn.getRowIndex()][posn.getColumnIndex()] = newCell;
    setNeighborAsObservers(posn);
    List<Position> neighbors = getNeighborCells(posn);
    for (Position neighbor : neighbors) {
      setNeighborAsObservers(neighbor);
    }
  }

  /**
   * Print the map to the console.
   *
   * @param printer represents the printer used to print the map
   */
  @Override
  public void prettyPrint(IConsolePrinter printer) {
    printer.toConsole(this);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Map map1 = (Map) object;
    for (int i = 0; i < MAP_HEIGHT; i++) {
      for (int j = 0; j < MAP_WIDTH; j++) {
        if (!this.getCells()[i][i].equals(map1.getCells()[i][j])) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 0;
    for (int i = 0; i < MAP_HEIGHT; i++) {
      for (int j = 0; j < MAP_WIDTH; j++) {
        result = result * 31 + this.getCells()[i][j].hashCode();
      }
    }
    return result;
  }


  @Override
  public String toString() {
    StringBuilder cellString = new StringBuilder();
    for (int i = 0; i < MAP_HEIGHT; i++) {
      for (int j = 0; j < MAP_WIDTH; j++) {
        cellString = cellString.append(cells[i][j].toString()).append("\n");
      }
    }
    return "Map{"
        + "map=" + cellString
        + '}';
  }

  /**
   * Check whether there are num of cells available at the given position in the given direction.
   *
   * @param posn the position of the top left cell of the ship
   * @param direction the direction of the ship
   * @param numOfCells the number of cells that the ship occupies.
   * @return true if the position given is valid for placing the ship on map, false otherwise.
   */
  protected Boolean checkPosition(Position posn, Direction direction, int numOfCells) {

    for (int i = 0; i < numOfCells; i++) {
      if (!getCell(posn).placeShipOnCell()) {
        return false;
      }
      if (i == numOfCells - 1) {
        break;
      }
      try {
        posn = getNextPosition(posn, direction);

      } catch (InvalidArgumentException e) {
        return false;
      }
    }
    return true;
  }

  /**
   * Get given position's next position in the given direction.
   * @param posn the given position
   * @param direction the given direction
   * @return given position's next position in the given direction.
   */
  protected Position getNextPosition(Position posn, Direction direction) {
    int row;
    char column;

    if (direction == Direction.HORIZONTAL) {
      row = posn.getRow();
      column = Character.toChars(posn.getColumn() + 1)[0];
    } else {
      row = posn.getRow() + 1;
      column = posn.getColumn();
    }
    return new Position(row, column);
  }

  /**
   * Set the cells where the given ship is placed to be specific ship cells.
   * @param posn the top left cell of the ship
   * @param direction the direction of the ship
   * @param ship the given to be placed on the map
   */
  protected void setShipCells(Position posn, Direction direction, Ship ship) {

    int numOfCells = ship.getSize();

    for (int i = 0; i < numOfCells; i++) {
      setCell(posn, new SpecificShipCell(false, false, ship));
      if (i == numOfCells - 1) {
        break;
      }
      posn = getNextPosition(posn, direction);
    }
  }

  /**
   * Upadate the cells around ship cell to be gap cell.
   * @param posn the position of the ship cell.
   */
  protected void updateCellsAroundShipCell(Position posn) {

    List<Position> neighbors = getNeighborCells(posn);
    for (Position neighbor : neighbors) {
      if (getCell(neighbor).getClass() == OpenSeaCell.class) {
        setCell(neighbor, new GapCell(false));
      }
    }
  }


  /**
   * Set the cells around a ship to be gap cells.
   * @param posn the top left cell of the ship
   * @param direction the direction of the ship
   * @param numOfCells the number of cells that the ship occupies.
   */
  protected void updateCellsAroundShip(Position posn, Direction direction, int numOfCells) {

    for (int i = 0; i < numOfCells; i++) {
      updateCellsAroundShipCell(posn);
      if (i == numOfCells - 1) {
        break;
      }
      posn = getNextPosition(posn, direction);
    }
  }


  /**
   * Place a ship on the map.
   *
   * @param posn      the position of the top left cell of the ship.
   * @param direction the direction of the ship
   * @param ship      the ship to be placed on map
   * @throws InvalidArgumentException when it's not valid to place ship on the given position.
   */
  @Override
  public void placeShipOnMap(Position posn, Direction direction, Ship ship) {
    if (checkPosition(posn, direction, ship.getSize())) {
      setShipCells(posn, direction,ship);
      updateCellsAroundShip(posn, direction, ship.getSize());
    } else {
      throw new InvalidArgumentException("Can't place ship on given position: " + posn);
    }
  }

  /**
   * Get the positions of neighbor cells of the given cell.
   * @param posn represents the given cell.
   * @return the positions of given cell's neighbors.
   */
  public List<Position> getNeighborCells(Position posn) {
    int row = posn.getRow();
    char column = posn.getColumn();
    List<Position> neighbors = new ArrayList<>();
    Position newPosn;
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        try {
          newPosn = new Position(row + i, Character.toChars(column + j)[0]);
          if (newPosn.equals(posn)) {
            continue;
          }
          neighbors.add(newPosn);
        } catch (InvalidArgumentException e) {
          continue;
        }
      }
    }
    return neighbors;
  }

  /**
   * Set neighbor cells as observers of given cell.
   * @param posn represents the position of the given cell
   */
  protected void setNeighborAsObservers(Position posn) {
    List<Position> neighbors = getNeighborCells(posn);
    List<Cell> cellObservers = new ArrayList<>();
    for (Position neighbor : neighbors) {
      cellObservers.add(getCell(neighbor));
    }
    getCell(posn).setCellObeservers(cellObservers);
  }
}
