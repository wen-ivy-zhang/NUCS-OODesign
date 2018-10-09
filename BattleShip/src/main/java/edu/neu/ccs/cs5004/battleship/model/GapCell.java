package edu.neu.ccs.cs5004.battleship.model;

/**
 * Represents a cell that has at least one adjacent ship cell.
 */
public class GapCell extends AbstractWaterCell{
  /**
   * Creates a gap cell.
   * @param isHit represents whether the cell is hit
   */
  public GapCell(Boolean isHit) {
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
    result = 5 * result + 5;
    return result;
  }

  @Override
  public String toString() {
    return "GapCell{} " + super.toString();
  }

  /**
   * Return true if a ship could be placed on the cell and false otherwise.
   * @return true if a ship could be placed on the cell and false otherwise
   */
  @Override
  public Boolean placeShipOnCell() {
    return false;
  }

  /**
   * Return the cell after attack.
   * @return updated cell after attack
   */
  @Override
  public Cell attackCell() {
    return new GapCell(true);
  }
}
