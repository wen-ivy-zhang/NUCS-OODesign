package edu.neu.ccs.cs5004.battleship.model;

import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;

/**
 * Represents a cell has an explicit enemy ship on it.
 */
public class EnemyShipCell extends AbstractShipCell {

  /**
   * Creates an enemy ship cell.
   * @param isHit represents whether the cell is hit
   * @param isSunk represents whether the ship on the cell is sunk
   */
  public EnemyShipCell(Boolean isHit, Boolean isSunk) {
    super(isHit, isSunk);
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
    result = 13 * result + 13;
    return result;
  }

  @Override
  public String toString() {
    return "EnemyShipCell{} " + super.toString();
  }

  /**
   * Return the cell after attack.
   * @return updated cell after attack
   */
  public Cell attackCell() {

    throw new InvalidCallException("Shouldn't call attackCell on enemy ship cell. Enemy ship cell "
        + "is on guesses map");
  }

  /**
   * Return the result of attack a cell.
   * @return the result of attack a cell.
   */
  @Override
  public AttackResult attackResult() {
    if (this.getIsSunk()) {
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


