package edu.neu.ccs.cs5004.battleship.model;

import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;

import java.util.Objects;


/**
 *  Represents a cell that has a shipt occupies this cell.
 */
public class SpecificShipCell extends AbstractShipCell {

  private Ship ship;

  /**
   * Creates a specific ship cell.
   *
   * @param isHit  represents whether the cell is hit
   * @param isSunk represents whether the ship on the cell is sunk
   * @param ship   represents the ship on the cell
   */
  public SpecificShipCell(Boolean isHit, Boolean isSunk, Ship ship) {
    super(isHit, isSunk);
    this.ship = ship;
  }

  /**
   * Getter for property ship.
   *
   * @return value for property ship
   */
  public Ship getShip() {
    return ship;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    SpecificShipCell that = (SpecificShipCell) object;
    return Objects.equals(ship, that.ship);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), ship);
  }

  @Override
  public String toString() {
    return "SpecificShipCell{"
        + "ship=" + ship
        + "} "
        + super.toString();
  }

  /**
   * Return the cell after attack.
   *
   * @return updated cell after attack
   */
  public Cell attackCell() {
    getShip().hitShip();
    return new SpecificShipCell(true, getShip().isSunk(), getShip());
  }


  /**
   * Return the result of attack a cell.
   *
   * @return the result of attack a cell.
   */
  @Override
  public AttackResult attackResult() {
    if ((getShip().getNumOfHitCells() + 1) == getShip().getSize()) {
      return new Sunk();
    } else {
      return new Hit();
    }
  }

  /**
   * Print the cell to the console.
   *
   * @param printer represents the {@code printer} used to print the cell
   */
  @Override
  public void prettyPrint(IConsolePrinter printer) {
    printer.toConsole(this);

  }
}

