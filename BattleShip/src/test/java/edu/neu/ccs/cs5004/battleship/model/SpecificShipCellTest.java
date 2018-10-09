package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpecificShipCellTest {


  private Ship ship;
  private Ship sunkShip;
  private SpecificShipCell specificShipCell;
  private SpecificShipCell sameRefSpecificShipCell;
  private SpecificShipCell sameStateSpecificShipCell;
  private SpecificShipCell diffSpecificShipCell;

  @Before
  public void setUp() throws Exception {
    ship = new BattleShip(4, 1);
    sunkShip = new BattleShip(4,4);
    specificShipCell = new SpecificShipCell(false, false, ship);
    sameRefSpecificShipCell = specificShipCell;
    sameStateSpecificShipCell = new SpecificShipCell(false,false, ship);
    diffSpecificShipCell = new SpecificShipCell(true,false, ship);
  }

  @Test
  public void getShip() {
    Assert.assertEquals(new BattleShip(4,1),
        specificShipCell.getShip());
  }

  @Test
  public void equals() {
    SpecificShipCell yetAnotherSpecificShipCell = new SpecificShipCell(false,false, ship);
    SpecificShipCell nullSpecificShipCell = null;

    Assert.assertTrue(specificShipCell.equals(specificShipCell)); // reflexivity
    Assert.assertTrue(specificShipCell.equals(sameRefSpecificShipCell)); // trivial condition both reference same object
    Assert.assertEquals(specificShipCell.equals(sameStateSpecificShipCell),
        sameStateSpecificShipCell.equals(specificShipCell)); // symmetry
    Assert.assertEquals(specificShipCell.equals(sameStateSpecificShipCell)
            && sameStateSpecificShipCell.equals(yetAnotherSpecificShipCell),
        yetAnotherSpecificShipCell.equals(specificShipCell)); // transitivity
    Assert.assertFalse(specificShipCell.equals(diffSpecificShipCell)); // objects have different state
    Assert.assertFalse(specificShipCell.equals(nullSpecificShipCell)); // specificShipCell is not null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(specificShipCell.equals(sameRefSpecificShipCell),
        specificShipCell.hashCode() == sameRefSpecificShipCell.hashCode());
    Assert.assertEquals(specificShipCell.equals(sameStateSpecificShipCell),
        specificShipCell.hashCode() == sameStateSpecificShipCell.hashCode());
    Assert.assertFalse(specificShipCell.hashCode() == diffSpecificShipCell.hashCode());
  }

  @Test
  public void testToString() {
    String tempRes = "SpecificShipCell{" +
        "ship=" + ship.toString() +
        "} " +
        "ShipCell{" +
        "isSunk=" + specificShipCell.getIsSunk() +
        '}' +
        " AbstractCell{" +
        "isHit=" + specificShipCell.getIsHit() +
        '}';
    Assert.assertEquals(tempRes, specificShipCell.toString());
  }

  @Test
  public void attackCell() {
    Ship attackedShip = new BattleShip(4, 2);
    SpecificShipCell attackedSpecificShipCell =
        new SpecificShipCell(true, false, attackedShip);
    Assert.assertEquals(attackedSpecificShipCell, specificShipCell.attackCell());
  }

  @Test
  public void attackResult() {
    Assert.assertEquals(new Hit(), specificShipCell.attackResult());
    Cruiser cruiser = new Cruiser(3,2);
    Assert.assertEquals(new Sunk(),
        new SpecificShipCell(false, false, cruiser).attackResult());
  }
}