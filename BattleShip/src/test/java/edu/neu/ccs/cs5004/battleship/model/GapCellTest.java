package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GapCellTest {

    private GapCell gapCell;
    private GapCell sameRefGapCell;
    private GapCell sameStateGapCell;
    private GapCell diffGapCell;


    @Before
    public void setUp() throws Exception {
      gapCell = new GapCell(false);
      sameRefGapCell = gapCell;
      sameStateGapCell = new GapCell(false);
      diffGapCell = new GapCell(true);
    }

    @Test
    public void equals() {
      GapCell yetAnotherGapCell = new GapCell(false);
      GapCell nullGapCell = null;

      Assert.assertTrue(gapCell.equals(gapCell)); // reflexivity
      Assert.assertTrue(gapCell.equals(sameRefGapCell)); // trivial condition both reference same object
      Assert.assertEquals(gapCell.equals(sameStateGapCell), sameStateGapCell.equals(gapCell)); // symmetry
      Assert.assertEquals(gapCell.equals(sameStateGapCell)
              && sameStateGapCell.equals(yetAnotherGapCell),
          yetAnotherGapCell.equals(gapCell)); // transitivity
      Assert.assertFalse(gapCell.equals(diffGapCell)); // objects have different state
      Assert.assertFalse(gapCell.equals(nullGapCell)); // cruiser is not null
    }

    @Test
    public void testHashCode() {
      Assert.assertEquals(gapCell.equals(sameRefGapCell), gapCell.hashCode() == sameRefGapCell.hashCode());
      Assert.assertEquals(gapCell.equals(sameStateGapCell), gapCell.hashCode() == sameStateGapCell.hashCode());
      Assert.assertFalse(gapCell.hashCode() == diffGapCell.hashCode());
    }

    @Test
    public void testToString() {
      String tempRes = "GapCell{} "
          + "WaterCell{} "
          + "AbstractCell{" +
          "isHit="
          + gapCell.getIsHit() +
          '}';
      Assert.assertEquals(tempRes, gapCell.toString());
    }

    @Test
    public void placeShipOnCell() {
      Assert.assertFalse(gapCell.placeShipOnCell());
    }
}