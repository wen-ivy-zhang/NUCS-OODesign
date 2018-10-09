package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DestroyerTest {

  private Destroyer destroyer;
  private Destroyer sameRefDestroyer;
  private Destroyer sameStateDestroyer;
  private Destroyer diffDestroyer;


  @Before
  public void setUp() throws Exception {
    destroyer = new Destroyer(1,0);
    sameRefDestroyer = destroyer;
    sameStateDestroyer = new Destroyer(1,0);
    diffDestroyer = new Destroyer(1,1);
  }

  @Test
  public void equals() {
    Destroyer yetAnotherDestroyer = new Destroyer(1,0);
    Destroyer nullDestroyer = null;

    Assert.assertTrue(destroyer.equals(destroyer)); // reflexivity
    Assert.assertTrue(destroyer.equals(sameRefDestroyer)); // trivial condition both reference same object
    Assert.assertEquals(destroyer.equals(sameStateDestroyer),
        sameStateDestroyer.equals(destroyer)); // symmetry
    Assert.assertEquals(destroyer.equals(sameStateDestroyer)
            && sameStateDestroyer.equals(yetAnotherDestroyer),
        yetAnotherDestroyer.equals(destroyer)); // transitivity
    Assert.assertFalse(destroyer.equals(diffDestroyer)); // objects have different state
    Assert.assertFalse(destroyer.equals(nullDestroyer)); // cruiser is not null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(destroyer.equals(sameRefDestroyer), destroyer.hashCode() == sameRefDestroyer.hashCode());
    Assert.assertEquals(destroyer.equals(sameStateDestroyer), destroyer.hashCode() == sameStateDestroyer.hashCode());
    Assert.assertFalse(destroyer.hashCode() == diffDestroyer.hashCode());
  }

  @Test
  public void testToString() {
    String tempRes = "Destroyer{} " +
        "AbstractShip{" +
        "size=" + destroyer.getSize() +
        ", numOfHitCells=" + destroyer.getNumOfHitCells() +
        '}';
    Assert.assertEquals(tempRes, destroyer.toString());
  }
}