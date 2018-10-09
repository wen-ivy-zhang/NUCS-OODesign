package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HitTest {

  private Hit hit;
  private Hit sameRefHit;
  private Hit sameStateHit;


  @Before
  public void setUp() throws Exception {
    hit = new Hit();
    sameRefHit = hit;
    sameStateHit = new Hit();
  }

  @Test
  public void getAttackResult() {
    String hitResult = "Hit – the cell is a part of the ship, but there are other cells that " +
        "have not been hit yet";
    Assert.assertEquals(hitResult, hit.getAttackResult());
  }

  @Test
  public void equals(){
    Hit nullHit = null;
    Hit yetAnotherhIT = new Hit();

    Assert.assertTrue(hit.equals(hit)); // reflexivity
    Assert.assertTrue(hit.equals(sameRefHit)); // trivial condition both reference same object
    Assert.assertEquals(hit.equals(sameStateHit), sameStateHit.equals(hit)); // symmetry
    Assert.assertEquals(hit.equals(sameStateHit)
            && sameStateHit.equals(yetAnotherhIT),
        yetAnotherhIT.equals(hit)); // transitivity
    Assert.assertFalse(hit.equals(nullHit)); // hit is not null
  }

  @Test
  public void testHashCode(){
    Assert.assertEquals(hit.equals(sameRefHit),
        hit.hashCode() == sameRefHit.hashCode());
    Assert.assertEquals(hit.equals(sameStateHit),
        hit.hashCode() == sameStateHit.hashCode());
  }

  @Test
  public void testToString(){
    Assert.assertEquals("Hit{}", hit.toString());
  }
}