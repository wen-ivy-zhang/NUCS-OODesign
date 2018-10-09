package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractWaterCellTest {

  private AbstractWaterCell absWaterCell;
  private AbstractWaterCell sameRefAbsWaterCell;
  private AbstractWaterCell sameStateAbsWaterCell;
  private AbstractWaterCell diffAbsWaterCell;
  private AbstractWaterCell gapCell;


  @Before
  public void setUp() throws Exception {
    absWaterCell = new OpenSeaCell(false);
    sameRefAbsWaterCell = absWaterCell;
    sameStateAbsWaterCell = new OpenSeaCell(false);
    diffAbsWaterCell = new OpenSeaCell(true);
    gapCell = new GapCell(false);
  }

  @Test
  public void equals() {
    AbstractWaterCell yetAnotherAbsWaterCell = new OpenSeaCell(false);
    AbstractWaterCell nullAbsWaterCell = null;

    Assert.assertTrue(absWaterCell.equals(absWaterCell)); // reflexivity
    Assert.assertTrue(absWaterCell.equals(sameRefAbsWaterCell)); // trivial condition both reference same object
    Assert.assertEquals(absWaterCell.equals(sameStateAbsWaterCell), sameStateAbsWaterCell.equals(absWaterCell)); // symmetry
    Assert.assertEquals(absWaterCell.equals(sameStateAbsWaterCell)
            && sameStateAbsWaterCell.equals(yetAnotherAbsWaterCell),
        yetAnotherAbsWaterCell.equals(absWaterCell)); // transitivity
    Assert.assertFalse(absWaterCell.equals(diffAbsWaterCell)); // objects have different state
    Assert.assertFalse(absWaterCell.equals(nullAbsWaterCell)); // absWaterCell is not null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(absWaterCell.equals(sameRefAbsWaterCell),
        absWaterCell.hashCode() == sameRefAbsWaterCell.hashCode());
    Assert.assertEquals(absWaterCell.equals(sameStateAbsWaterCell),
        absWaterCell.hashCode() == sameStateAbsWaterCell.hashCode());
    Assert.assertFalse(absWaterCell.hashCode() == diffAbsWaterCell.hashCode());
  }


  @Test
  public void attackResult() {
    Assert.assertEquals(new Miss(), absWaterCell.attackResult());
    Assert.assertEquals(new Miss(), gapCell.attackResult());
  }

  @Test
  public void attackCell() {
    AbstractWaterCell hitOpenSeaCell = new OpenSeaCell(true);
    Assert.assertEquals(hitOpenSeaCell, absWaterCell.attackCell());
    AbstractWaterCell hitGapCell = new GapCell(true);
    Assert.assertEquals(hitGapCell, gapCell.attackCell());
  }
}