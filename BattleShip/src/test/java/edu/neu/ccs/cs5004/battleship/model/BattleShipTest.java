package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BattleShipTest {

  private BattleShip battleShip;
  private BattleShip sameRefBattleShip;
  private BattleShip sameStateBattleShip;
  private BattleShip diffBattleShip;


  @Before
  public void setUp() throws Exception {
    battleShip = new BattleShip(4,1);
    sameRefBattleShip = battleShip;
    sameStateBattleShip = new BattleShip(4,1);
    diffBattleShip = new BattleShip(4,3);
  }

  @Test
  public void equals() {
    BattleShip yetAnotherBattleShip = new BattleShip(4,1);
    BattleShip nullBattleShip = null;

    Assert.assertTrue(battleShip.equals(battleShip)); // reflexivity
    Assert.assertTrue(battleShip.equals(sameRefBattleShip)); // trivial condition both reference same object
    Assert.assertEquals(battleShip.equals(sameStateBattleShip),
        sameStateBattleShip.equals(battleShip)); // symmetry
    Assert.assertEquals(battleShip.equals(sameStateBattleShip)
            && sameStateBattleShip.equals(yetAnotherBattleShip),
        yetAnotherBattleShip.equals(battleShip)); // transitivity
    Assert.assertFalse(battleShip.equals(diffBattleShip)); // objects have different state
    Assert.assertFalse(battleShip.equals(nullBattleShip)); // cruiser is not null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(battleShip.equals(sameRefBattleShip), battleShip.hashCode() == sameRefBattleShip.hashCode());
    Assert.assertEquals(battleShip.equals(sameStateBattleShip), battleShip.hashCode() == sameStateBattleShip.hashCode());
    Assert.assertFalse(battleShip.hashCode() == diffBattleShip.hashCode());
  }

  @Test
  public void testToString() {
    String tempRes = "BattleShip{} " +
        "AbstractShip{" +
        "size=" + battleShip.getSize() +
        ", numOfHitCells=" + battleShip.getNumOfHitCells() +
        '}';
    Assert.assertEquals(tempRes, battleShip.toString());
  }
}