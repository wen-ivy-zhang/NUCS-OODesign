package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CruiserTest {

  private Cruiser cruiser;
  private Cruiser sameRefCruiser;
  private Cruiser sameStateCruiser;
  private Cruiser diffCruiser;


  @Before
  public void setUp() throws Exception {
    cruiser = new Cruiser(3,1);
    sameRefCruiser = cruiser;
    sameStateCruiser = new Cruiser(3,1);
    diffCruiser = new Cruiser(3,3);
  }

  @Test
  public void equals() {
    Cruiser yetAnotherCruiser = new Cruiser(3,1);
    Cruiser nullCruiser= null;

    // reflexivity
    Assert.assertTrue(cruiser.equals(cruiser));
    // trivial condition both reference same object
    Assert.assertTrue(cruiser.equals(sameRefCruiser));
    // symmetry
    Assert.assertEquals(cruiser.equals(sameStateCruiser),
        sameStateCruiser.equals(cruiser));
    // transitivity
    Assert.assertEquals(cruiser.equals(sameStateCruiser)
            && sameStateCruiser.equals(yetAnotherCruiser),
        yetAnotherCruiser.equals(cruiser));
    // objects have different state
    Assert.assertFalse(cruiser.equals(diffCruiser));
    // cruiser is not null
    Assert.assertFalse(cruiser.equals(nullCruiser));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(cruiser.equals(sameRefCruiser),
        cruiser.hashCode() == sameRefCruiser.hashCode());
    Assert.assertEquals(cruiser.equals(sameStateCruiser),
        cruiser.hashCode() == sameStateCruiser.hashCode());
    Assert.assertEquals(cruiser.equals(diffCruiser),
        cruiser.hashCode() == diffCruiser.hashCode());
  }

  @Test
  public void testToString() {
    String tempRes = "Cruiser{} " +
        "AbstractShip{" +
        "size=" + cruiser.getSize() +
        ", numOfHitCells=" + cruiser.getNumOfHitCells() +
        '}';
    Assert.assertEquals(tempRes, cruiser.toString());
  }
}