package edu.neu.ccs.cs5004.battleship.model;

import java.util.Objects;

/**
 * Represents the common properties of a ship cell.
 */
public abstract class AbstractShipCell extends AbstractCell implements ShipCell{

  private Boolean isSunk;

  /**
   * Creates a ship cell.
   * @param isHit represents whether the cell is hit.
   * @param isSunk represents whether the ship on the cell is sunk
   */
  public AbstractShipCell(Boolean isHit, Boolean isSunk) {
    super(isHit);
    this.isSunk = isSunk;
  }

  /**
   * Setter for property isSunk.
   * @param sunk value for property isSunk.
   */
  public void setSunk(Boolean sunk) {
    isSunk = sunk;
  }

  /**
   * Getter for property isSunk.
   * @return value for property isSunk
   */
  public Boolean getIsSunk() {
    return isSunk;
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
    AbstractShipCell shipCell = (AbstractShipCell) object;
    return Objects.equals(getIsSunk(), shipCell.getIsSunk());
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), getIsSunk());
  }

  @Override
  public String toString() {
    return "ShipCell{"
        + "isSunk=" + isSunk
        + "} " + super.toString();
  }

  /**
   * Return true if a ship could be placed on the cell and false otherwise.
   * @return true if a ship could be placed on the cell and false otherwise
   */
  public Boolean placeShipOnCell() {
    return false;
  }


  /**
   * Mark the ship cell as sunk.
   */
  public void markCellSunk() {
    setHit(true);
    setSunk(true);
  }
}
