package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShipTest {

  Ship battleShip;
  Ship cruiser;
  Ship submarine;
  Ship destroyer;
  Ship sunkBattleShip;
  Ship sunkCruiser;
  Ship sunkSubmarine;
  Ship sunkDestroyer;

  @Before
  public void setUp() throws Exception {
    battleShip = new BattleShip(4,1);
    sunkBattleShip = new BattleShip(4, 4);
    cruiser = new Cruiser(3,1);
    sunkCruiser = new Cruiser(3,3);
    submarine = new Submarine(2,1);
    sunkSubmarine = new Submarine(2,2);
    destroyer = new Destroyer(1,0);
    sunkDestroyer = new Destroyer(1,1);
  }

  @Test
  public void hitShip() {
    battleShip.hitShip();
    BattleShip battleShipAfterHit = new BattleShip(4, 2);
    Assert.assertEquals(battleShipAfterHit, battleShip);
  }

  @Test
  public void isSunk() {
    Assert.assertFalse(battleShip.isSunk());
    Assert.assertFalse(cruiser.isSunk());
    Assert.assertFalse(submarine.isSunk());
    Assert.assertFalse(destroyer.isSunk());
    Assert.assertTrue(sunkBattleShip.isSunk());
    Assert.assertTrue(sunkCruiser.isSunk());
    Assert.assertTrue(sunkSubmarine.isSunk());
    Assert.assertTrue(sunkDestroyer.isSunk());
  }
}