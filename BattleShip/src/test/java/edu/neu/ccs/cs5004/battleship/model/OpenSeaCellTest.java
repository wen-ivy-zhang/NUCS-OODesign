package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OpenSeaCellTest {
  private OpenSeaCell osc;
  private OpenSeaCell sameRefOsc;
  private OpenSeaCell sameStateOsc;
  private OpenSeaCell diffOsc;


  @Before
  public void setUp() throws Exception {
    osc = new OpenSeaCell(false);
    sameRefOsc = osc;
    sameStateOsc = new OpenSeaCell(false);
    diffOsc = new OpenSeaCell(true);
  }

  @Test
  public void equals() {
    OpenSeaCell yetAnotherOsc = new OpenSeaCell(false);
    OpenSeaCell nullOsc = null;

    Assert.assertTrue(osc.equals(osc)); // reflexivity
    Assert.assertTrue(osc.equals(sameRefOsc)); // trivial condition both reference same object
    Assert.assertEquals(osc.equals(sameStateOsc), sameStateOsc.equals(osc)); // symmetry
    Assert.assertEquals(osc.equals(sameStateOsc)
            && sameStateOsc.equals(yetAnotherOsc),
        yetAnotherOsc.equals(osc)); // transitivity
    Assert.assertFalse(osc.equals(diffOsc)); // objects have different state
    Assert.assertFalse(osc.equals(nullOsc)); // openSeaCell is not null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(osc.equals(sameRefOsc), osc.hashCode() == sameRefOsc.hashCode());
    Assert.assertEquals(osc.equals(sameStateOsc), osc.hashCode() == sameStateOsc.hashCode());
    Assert.assertFalse(osc.hashCode() == diffOsc.hashCode());
  }

  @Test
  public void testToString() {
    String tempRes = "OpenSeaCell{}"
        + "WaterCell{} "
        + "AbstractCell{" +
        "isHit="
        + osc.getIsHit() +
        '}';
    Assert.assertEquals(tempRes, osc.toString());
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertTrue(osc.placeShipOnCell());
  }
}