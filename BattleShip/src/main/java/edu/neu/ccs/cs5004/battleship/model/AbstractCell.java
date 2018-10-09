package edu.neu.ccs.cs5004.battleship.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the common properties of a cell in the map of the battleship game.
 */
public abstract class AbstractCell implements Cell {
  private Boolean isHit;
  private List<Cell> cellObeservers;

  /**
   * Creates a cell.
   * @param isHit represents whether the cell is hit, true means the cell was hit, false otherwise
   */
  public AbstractCell(Boolean isHit) {
    this.isHit = isHit;
    cellObeservers = new ArrayList<>();
  }

  /**
   * Getter for property isHit.
   * @return the value for property isHit
   */
  public Boolean getIsHit() {
    return isHit;
  }

  /**
   * Setter for property isHit.
   * @param hit the value set for property isHit.
   */
  public void setHit(Boolean hit) {
    isHit = hit;
  }

  /**
   * Setter for property cell observers.
   * @param cellObeservers value to set for property cell observers.
   */
  public void setCellObeservers(List<Cell> cellObeservers) {
    this.cellObeservers = cellObeservers;
  }

  /**
   * Notify the observers of the cell.
   */
  public void notifyObserver() {
    for (Cell observer : cellObeservers) {
      observer.update();
    }
  }

  /**
   * Update the observer and notify its neighbor observers.
   */
  public void update() {
    if (this instanceof AbstractShipCell && !getIsSunk()) {
      markCellSunk();
      notifyObserver();
    }
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    AbstractCell that = (AbstractCell) object;
    return Objects.equals(isHit, that.isHit);
  }

  @Override
  public int hashCode() {

    return Objects.hash(isHit);
  }

  @Override
  public String toString() {
    return "AbstractCell{"
        + "isHit=" + isHit
        + '}';
  }
}
