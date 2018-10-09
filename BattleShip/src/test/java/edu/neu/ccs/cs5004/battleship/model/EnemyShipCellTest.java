package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnemyShipCellTest {

  private EnemyShipCell enemyShipCell;
  private EnemyShipCell sameRefEnemyShipCell;
  private EnemyShipCell sameStateEnemyShipCell;
  private EnemyShipCell diffEnemyShipCell;
  private EnemyShipCell sunkEnemyShipCell;


  @Before
  public void setUp() throws Exception {
    enemyShipCell = new EnemyShipCell(false, false);
    sameRefEnemyShipCell = enemyShipCell;
    sameStateEnemyShipCell = new EnemyShipCell(false,false);
    diffEnemyShipCell = new EnemyShipCell(true,false);
  }

  @Test
  public void equals() {
    EnemyShipCell yetAnotherEnemyCell = new EnemyShipCell(false,false);
    EnemyShipCell nullEnemyShipCell = null;

    Assert.assertTrue(enemyShipCell.equals(enemyShipCell)); // reflexivity
    Assert.assertTrue(enemyShipCell.equals(sameRefEnemyShipCell)); // trivial condition both reference same object
    Assert.assertEquals(enemyShipCell.equals(sameStateEnemyShipCell),
        sameStateEnemyShipCell.equals(enemyShipCell)); // symmetry
    Assert.assertEquals(enemyShipCell.equals(sameStateEnemyShipCell)
            && sameStateEnemyShipCell.equals(yetAnotherEnemyCell),
        yetAnotherEnemyCell.equals(enemyShipCell)); // transitivity
    Assert.assertFalse(enemyShipCell.equals(diffEnemyShipCell)); // objects have different state
    Assert.assertFalse(enemyShipCell.equals(nullEnemyShipCell)); // enemyShipCell is not null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(enemyShipCell.equals(sameRefEnemyShipCell),
        enemyShipCell.hashCode() == sameRefEnemyShipCell.hashCode());
    Assert.assertEquals(enemyShipCell.equals(sameStateEnemyShipCell),
        enemyShipCell.hashCode() == sameStateEnemyShipCell.hashCode());
    Assert.assertFalse(enemyShipCell.hashCode() == diffEnemyShipCell.hashCode());
  }

  @Test
  public void testToString() {
    String tempRes = "EnemyShipCell{} " +
        "ShipCell{" +
        "isSunk=" + enemyShipCell.getIsSunk() +
        '}' +
        " AbstractCell{" +
        "isHit=" + enemyShipCell.getIsHit() +
        '}';
    Assert.assertEquals(tempRes, enemyShipCell.toString());
  }

  @Test(expected = InvalidCallException.class)
  public void attackCell() {
    enemyShipCell.attackCell();
  }

  @Test
  public void attackResult() {
    sunkEnemyShipCell = new EnemyShipCell(true, true);
    Assert.assertEquals(new Hit(), enemyShipCell.attackResult());
    Assert.assertEquals(new Sunk(), sunkEnemyShipCell.attackResult());

  }

}