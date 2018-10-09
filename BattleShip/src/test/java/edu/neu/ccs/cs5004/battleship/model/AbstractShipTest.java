package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractShipTest {

  private AbstractShip abstractShip;
  private AbstractShip sameRefAbstractShip;
  private AbstractShip sameStateAbstractShip;
  private AbstractShip diffAbstractShip;
  private AbstractShip sunkAbstractShip;


  @Before
  public void setUp() throws Exception {
    abstractShip = new BattleShip(4,1);
    sameRefAbstractShip = abstractShip;
    sameStateAbstractShip = new BattleShip(4,1);
    diffAbstractShip = new BattleShip(4,3);
    sunkAbstractShip = new BattleShip(4,4);
  }

  @Test
  public void equals() {
    AbstractShip yetAnotherAbstractShip = new BattleShip(4,1);
    AbstractShip nullAbstractShip = null;

    Assert.assertTrue(abstractShip.equals(abstractShip)); // reflexivity
    Assert.assertTrue(abstractShip.equals(sameRefAbstractShip)); // trivial condition both reference same object
    Assert.assertEquals(abstractShip.equals(sameStateAbstractShip),
        sameStateAbstractShip.equals(abstractShip)); // symmetry
    Assert.assertEquals(abstractShip.equals(sameStateAbstractShip)
            && sameStateAbstractShip.equals(yetAnotherAbstractShip),
        yetAnotherAbstractShip.equals(abstractShip)); // transitivity
    Assert.assertFalse(abstractShip.equals(diffAbstractShip)); // objects have different state
    Assert.assertFalse(abstractShip.equals(nullAbstractShip)); // cruiser is not null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(abstractShip.equals(sameRefAbstractShip), abstractShip.hashCode() == sameRefAbstractShip.hashCode());
    Assert.assertEquals(abstractShip.equals(sameStateAbstractShip), abstractShip.hashCode() == sameStateAbstractShip.hashCode());
    Assert.assertFalse(abstractShip.hashCode() == diffAbstractShip.hashCode());
  }

  @Test
  public void getSize() {
    Assert.assertEquals(new Integer(4), abstractShip.getSize());
  }

  @Test
  public void getNumOfHitCells() {
    Assert.assertEquals(new Integer(1), abstractShip.getNumOfHitCells());
  }

  @Test
  public void isSunk() {
    Assert.assertFalse(abstractShip.isSunk());
    Assert.assertTrue(sunkAbstractShip.isSunk());
  }

  @Test
  public void setNumOfHitCells() {
    abstractShip.setNumOfHitCells(2);
    Assert.assertEquals(new Integer(2), abstractShip.getNumOfHitCells());
  }

  @Test
  public void hitShip() {
    AbstractShip sunkBattleShip = new BattleShip(4, 4);
    AbstractShip battleShip = new BattleShip(4, 1);
    sunkBattleShip.hitShip();
    battleShip.hitShip();
    Assert.assertEquals(new Integer(2), battleShip.getNumOfHitCells());
    Assert.assertEquals(new Integer(4), sunkBattleShip.getNumOfHitCells());

  }

}