package edu.neu.ccs.cs5004.battleship.model;

/**
 * Represents a cell that has no adjacent ship cells.
 */
public class OpenSeaCell extends AbstractWaterCell {

  /**
   * Creates an open sea cell.
   * @param isHit represents whether the cell is hit
   */
  public OpenSeaCell(Boolean isHit) {
    super(isHit);
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
    result = 17 * result + 17;
    return result;
  }

  @Override
  public String toString() {
    return "OpenSeaCell{}" + super.toString();
  }

  /**
   * Return true if a ship could be placed on the cell and false otherwise.
   * @return true if a ship could be placed on the cell and false otherwise
   */
  @Override
  public Boolean placeShipOnCell() {
    return true;
  }

  /**
   * Return the cell after attack.
   * @return updated cell after attack
   */
  @Override
  public Cell attackCell() {
    return new OpenSeaCell(true);
  }
}

