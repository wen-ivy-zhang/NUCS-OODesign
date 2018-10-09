package edu.neu.ccs.cs5004.battleship.model;


import java.util.Objects;

/**
 * Represents the position of a cell in the map.
 */
public class Position {

  private static final char FIRST_COLUMN = 'A';
  private static final char LAST_COLUMN = 'J';
  private static final int FIRST_ROW = 1;
  private static final int LAST_ROW = 10;

  private int row;
  private char column;


  /**
   * Creates a new position on the map.
   *
   * @param posn a string represents the position on the map. The string consists of column and row
   *             seperated by space，eg: "A 1". Column is from A to J. Row is from 1 to 10。
   * @throws InvalidArgumentException when invalid input is given.
   */
  public Position(String posn) {

    String[] pos = posn.split(" ");

    if (pos.length < 2) {
      throw new InvalidArgumentException("Not enough input, expect column and row separated "
          + "by space.");
    }

    if (pos.length > 2) {
      throw new InvalidArgumentException("Too much input, expect only column and row separated "
          + "by space.");
    }

    if (pos[0].length() != 1) {
      throw new InvalidArgumentException("Expect letter from A to J representing column, "
          + "given: " + pos[0]);
    }

    char newColumn = Character.toUpperCase(pos[0].charAt(0));
    if (newColumn < FIRST_COLUMN || newColumn > LAST_COLUMN) {
      throw new InvalidArgumentException("Expect letter from A to J representing column, "
          + "given: " + newColumn);
    } else {
      this.column = newColumn;
    }

    try {
      int newRow = Integer.parseInt(pos[1]);
      if (newRow < FIRST_ROW || newRow > LAST_ROW) {
        throw new InvalidArgumentException("Expect number from 1 to 10 representing row, given: "
            + newRow);
      } else {
        this.row = newRow;
      }
    } catch (NumberFormatException e) {
      throw new InvalidArgumentException("Expect number from 1 to 10 representing row, given: "
          + pos[1]);
    }
  }


  /**
   * Creates a new position.
   *
   * @param row represent the row on the map
   * @param column represent the column on the map
   */
  public Position(int row, char column) {

    if (row < FIRST_ROW || row > LAST_ROW) {
      throw new InvalidArgumentException("Expect number from 1 to 10 representing row, given: "
          + row);
    } else {
      this.row = row;
    }

    if (column < FIRST_COLUMN || column > LAST_COLUMN) {
      throw new InvalidArgumentException("Expect letter from A to J representing column, "
          + "given: " + column);
    } else {
      this.column = column;
    }
  }

  /**
   * Creates a new position.
   *
   * @param row represent the row on the map
   * @param column represent the column on the map
   */
  public Position(int row, int column) {

    if (row + 1 < FIRST_ROW || row + 1 > LAST_ROW) {
      throw new InvalidArgumentException("Expect number from 1 to 10 representing row, given: "
          + (row + 1));
    } else {
      this.row = row + 1;
    }

    char columnInChar = Character.toChars(column + FIRST_COLUMN)[0];
    if (columnInChar < FIRST_COLUMN || columnInChar > LAST_COLUMN) {
      throw new InvalidArgumentException("Expect letter from A to J representing column, "
          + "given: " + column);
    } else {
      this.column = columnInChar;
    }
  }

  /**
   * Getter for property row.
   *
   * @return value for property row
   */
  public int getRow() {
    return row;
  }

  /**
   * Getter for property column.
   *
   * @return value for property column.
   */
  public char getColumn() {
    return column;
  }

  /**
   * Get the row index on the map.
   *
   * @return the row index on the map
   */
  public int getRowIndex() {
    return row - FIRST_ROW;
  }

  /**
   * Get the column index on the map.
   *
   * @return the row index on the map
   */
  public int getColumnIndex() {
    return column - FIRST_COLUMN;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Position position = (Position) object;
    return row == position.row
        && column == position.column;
  }

  @Override
  public int hashCode() {

    return Objects.hash(row, column);
  }

  @Override
  public String toString() {
    return "Position{"
        + "row=" + row
        + ", column=" + column
        + '}';
  }
}


