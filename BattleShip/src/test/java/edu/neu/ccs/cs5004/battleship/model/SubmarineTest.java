package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubmarineTest {

  private Submarine submarine;
  private Submarine sameRefSubmarine;
  private Submarine sameStateSubmarine;
  private Submarine diffSubmarine;


  @Before
  public void setUp() throws Exception {
    submarine = new Submarine(2,1);
    sameRefSubmarine = submarine;
    sameStateSubmarine = new Submarine(2,1);
    diffSubmarine = new Submarine(2,2);
  }

  @Test
  public void equals() {
    Submarine yetAnotherSubmarine = new Submarine(2,1);
    Submarine nullSubmarine = null;

    Assert.assertTrue(submarine.equals(submarine)); // reflexivity
    Assert.assertTrue(submarine.equals(sameRefSubmarine)); // trivial condition both reference same object
    Assert.assertEquals(submarine.equals(sameStateSubmarine),
        sameStateSubmarine.equals(submarine)); // symmetry
    Assert.assertEquals(submarine.equals(sameStateSubmarine)
            && sameStateSubmarine.equals(yetAnotherSubmarine),
        yetAnotherSubmarine.equals(submarine)); // transitivity
    Assert.assertFalse(submarine.equals(diffSubmarine)); // objects have different state
    Assert.assertFalse(submarine.equals(nullSubmarine)); // cruiser is not null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(submarine.equals(sameRefSubmarine), submarine.hashCode() == sameRefSubmarine.hashCode());
    Assert.assertEquals(submarine.equals(sameStateSubmarine), submarine.hashCode() == sameStateSubmarine.hashCode());
    Assert.assertFalse(submarine.hashCode() == diffSubmarine.hashCode());
  }

  @Test
  public void testToString() {
    String tempRes = "Submarine{} " +
        "AbstractShip{" +
        "size=" + submarine.getSize() +
        ", numOfHitCells=" + submarine.getNumOfHitCells() +
        '}';
    Assert.assertEquals(tempRes, submarine.toString());
  }
}