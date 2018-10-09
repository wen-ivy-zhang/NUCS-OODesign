package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CellTest {
  private Cell openSeaCell;
  private Cell gapCell;
  private Cell enemyShipCell;
  private Cell specificShipCell;
  private Cell sunkSpecificShipCell;
  private Ship notYetSunkShip;
  private Ship sunkShip;


  @Before
  public void setUp() throws Exception {
    notYetSunkShip = new BattleShip(4, 3);
    sunkShip = new BattleShip(4,4);
    openSeaCell = new OpenSeaCell(false);
    gapCell = new GapCell(false);
    enemyShipCell = new EnemyShipCell(false, false);
    specificShipCell = new SpecificShipCell(false, false, notYetSunkShip);
    sunkSpecificShipCell = new SpecificShipCell(true, true,sunkShip);
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertTrue(openSeaCell.placeShipOnCell());
    Assert.assertFalse(gapCell.placeShipOnCell());
    Assert.assertFalse(enemyShipCell.placeShipOnCell());
    Assert.assertFalse(specificShipCell.placeShipOnCell());
  }

  @Test
  public void attackCell1() {
    Cell attackedGapCell = new GapCell(true);
    Cell attackedOpenSeaCell = new OpenSeaCell(true);
    Assert.assertEquals(attackedGapCell, gapCell.attackCell());
    Assert.assertEquals(attackedOpenSeaCell, openSeaCell.attackCell());
    Assert.assertEquals(sunkSpecificShipCell, specificShipCell.attackCell());
  }

  @Test (expected = InvalidCallException.class)
  public void attackCell2() {
    enemyShipCell.attackCell();
  }

  @Test
  public void attackResult() {
    Assert.assertEquals(new Miss(),  openSeaCell.attackResult());
    Assert.assertEquals(new Miss(),  gapCell.attackResult());
    Assert.assertEquals(new Hit(),  enemyShipCell.attackResult());
    Assert.assertEquals(new Sunk(),  specificShipCell.attackResult());
  }
}