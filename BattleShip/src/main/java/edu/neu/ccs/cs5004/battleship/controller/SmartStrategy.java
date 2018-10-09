package edu.neu.ccs.cs5004.battleship.controller;

import edu.neu.ccs.cs5004.battleship.model.Cell;
import edu.neu.ccs.cs5004.battleship.model.EnemyShipCell;
import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.InvalidArgumentException;
import edu.neu.ccs.cs5004.battleship.model.Position;

import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements IStrategy {

  /**
   * Return a position on the map to be attacked.
   *
   * @param map represents the battle map.
   * @return a position on the map to be attacked.
   */
  @Override
  public Position chooseCellToAttack(IMap map) {
    Position cellToAttack;
    cellToAttack = findPotentialShipCell(map);
    if (cellToAttack == null) {
      do {
        IStrategy randomStrategy = IStrategy.createRandomStrategy();
        cellToAttack = randomStrategy.chooseCellToAttack(map);
      } while (checkIsGapCell(map, cellToAttack));
    }
    return cellToAttack;
  }


  /**
   * Search the map to find a potential ship cell.
   *
   * @param map represents a battle map
   * @return the position of potential ship cell.
   */
  public Position findPotentialShipCell(IMap map) {
    Position cellToAttack = null;
    Cell[][] cells = map.getCells();
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[0].length; j++) {
        Position cellPosition = new Position(i, j);
        Cell cell = map.getCell(cellPosition);
        if (cell instanceof EnemyShipCell && !cell.getIsSunk()) {
          cellToAttack = findSurroundingShipCell(map, cellPosition);
          if (cellToAttack != null) {
            return cellToAttack;
          }
        }
      }
    }
    return cellToAttack;
  }


  /**
   * Find the position of a potential ship cell surrounding the given ship cell.
   *
   * @param map          represents the battle ship.
   * @param cellPosition represents the given ship cell.
   * @return the position of potential ship cell.
   */
  public Position findSurroundingShipCell(IMap map, Position cellPosition) {

    Position cellToAttack = null;
    List<Position> surroundingCells = getSurroundingCells(cellPosition);
    for (Position surroundingCellPosition : surroundingCells) {
      Cell surroundingCell = map.getCell(surroundingCellPosition);
      if (surroundingCell instanceof EnemyShipCell) {
        cellToAttack = calculateShipCellPosition(cellPosition, surroundingCellPosition);
        if (cellToAttack != null && map.getCell(cellToAttack).getIsHit()) {
          cellToAttack = null;
        }
        break;
      }
      if (!surroundingCell.getIsHit()) {
        cellToAttack = surroundingCellPosition;
      }
    }
    return cellToAttack;
  }


  /**
   * Get the list of positions of cells surrounding the given cell.
   *
   * @param currentCell represents the given cell.
   * @return the list of positions of cells surrounding the given cell.
   */
  public List<Position> getSurroundingCells(Position currentCell) {
    List<Position> result = new ArrayList<>();
    int[][] coordinates = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int i = 0; i < 4; i++) {
      try {
        int newRow = currentCell.getRowIndex() + coordinates[i][0];
        int newColumn = currentCell.getColumnIndex() + coordinates[i][1];
        result.add(new Position(newRow, newColumn));
      } catch (InvalidArgumentException e) {
        continue;
      }
    }
    return result;
  }

  /**
   * Calculate the mirror position of current cell's surrounding cell.
   *
   * @param currentCell     represents current cell which is in the middle.
   * @param surroundingCell represents a cell surrounding current cell.
   * @return the mirror positon of surrounding cell.
   */
  public Position calculateShipCellPosition(Position currentCell, Position surroundingCell) {
    int row;
    int column;
    Position result;
    if (currentCell.getRowIndex() == surroundingCell.getRowIndex()) {
      column = currentCell.getColumnIndex()
          - (surroundingCell.getColumnIndex() - currentCell.getColumnIndex());
      row = currentCell.getRowIndex();
    } else {
      row = currentCell.getRowIndex()
          - (surroundingCell.getRowIndex() - currentCell.getRowIndex());
      column = currentCell.getColumnIndex();
    }
    try {
      result = new Position(row, column);
      return result;
    } catch (InvalidArgumentException e) {
      return null;
    }
  }

  /**
   * Check if the cell at given position is a gap cell.
   *
   * @param map          represents the battle map.
   * @param cellPosition represents the given position.
   * @return true if given cell is a gap cell, false otherwise.
   */
  public boolean checkIsGapCell(IMap map, Position cellPosition) {
    List<Position> neighbors = map.getNeighborCells(cellPosition);
    for (Position neighbor : neighbors) {
      if (map.getCell(neighbor) instanceof EnemyShipCell) {
        return true;
      }
    }
    return false;
  }
}
