package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractShipCellTest {

  private AbstractShipCell abstractShipCell;
  private AbstractShipCell sameRefAbsShipCell;
  private AbstractShipCell sameStateAbsShipCell;
  private AbstractShipCell diffAbsShipCell;
  private Ship sunkShip;


  @Before
  public void setUp() throws Exception {
    abstractShipCell = new EnemyShipCell(false, false);
    sameRefAbsShipCell = abstractShipCell;
    sameStateAbsShipCell = new EnemyShipCell(false, false);
    diffAbsShipCell = new EnemyShipCell(true,false);
    sunkShip = new BattleShip(4, 4);
  }


  @Test
  public void getIsSunk() {
    Assert.assertEquals(false, abstractShipCell.getIsSunk());
  }

  @Test
  public void equals() {
    AbstractShipCell yetAnotherShipCell = new EnemyShipCell(false,false);
    AbstractShipCell nullShipCell = null;

    Assert.assertTrue(abstractShipCell.equals(abstractShipCell)); // reflexivity
    Assert.assertTrue(abstractShipCell.equals(sameRefAbsShipCell)); // trivial condition both reference same object
    Assert.assertEquals(abstractShipCell.equals(sameStateAbsShipCell),
        sameStateAbsShipCell.equals(abstractShipCell)); // symmetry
    Assert.assertEquals(abstractShipCell.equals(sameStateAbsShipCell)
            && sameStateAbsShipCell.equals(yetAnotherShipCell),
        yetAnotherShipCell.equals(abstractShipCell)); // transitivity
    Assert.assertFalse(abstractShipCell.equals(diffAbsShipCell)); // objects have different state
    Assert.assertFalse(abstractShipCell.equals(nullShipCell)); // shipCell is not null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(abstractShipCell.equals(sameRefAbsShipCell),
        abstractShipCell.hashCode() == sameRefAbsShipCell.hashCode());
    Assert.assertEquals(abstractShipCell.equals(sameStateAbsShipCell),
        abstractShipCell.hashCode() == sameStateAbsShipCell.hashCode());
    Assert.assertFalse(abstractShipCell.hashCode() == diffAbsShipCell.hashCode());
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertFalse(abstractShipCell.placeShipOnCell());
  }

  @Test
  public void markCellSunk() {
    abstractShipCell.markCellSunk();
    Assert.assertEquals(true, abstractShipCell.getIsSunk());
    Assert.assertEquals(true, abstractShipCell.getIsHit());
  }


  @Test
  public void markShipCellSunk() {
    abstractShipCell.markCellSunk();
    Assert.assertEquals(new EnemyShipCell(true, true), abstractShipCell);
  }
}