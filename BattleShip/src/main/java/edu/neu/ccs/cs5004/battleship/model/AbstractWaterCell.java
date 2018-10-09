package edu.neu.ccs.cs5004.battleship.model;

import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;

/**
 * Represents the common properties of a water cell.
 */
public abstract class AbstractWaterCell extends AbstractCell implements WaterCell{

  /**
   * Creates a water cell.
   * @param isHit represents whether the cell is hit
   */
  public AbstractWaterCell(Boolean isHit) {
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
    result = 31 * result + 31;
    return result;
  }


  @Override
  public String toString() {
    return "WaterCell{} " + super.toString();
  }

  /**
   * Get the result of attack a cell.
   * @return the result of attack a cell.
   */
  public AttackResult attackResult() {
    return new Miss();
  }


  /**
   * Getter for property isSunk.
   * @return value for property isSunk
   * @throws InvalidArgumentException when called getIsSunk on water cell.
   */
  public Boolean getIsSunk() {
    throw new InvalidCallException("Water cell can't be sunk");
  }

  /**
   * Mark the ship cell as sunk.
   *
   * @throws InvalidArgumentException when called marKCellSunk on water cell.
   */
  @Override
  public void markCellSunk() {
    throw new InvalidCallException("Can't mark water cell as sunk.");
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
