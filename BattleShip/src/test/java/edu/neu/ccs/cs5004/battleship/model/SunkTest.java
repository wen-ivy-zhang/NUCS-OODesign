package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SunkTest {

  private Sunk sunk;
  private Sunk sameRefSunk;
  private Sunk sameStateSunk;

  @Before
  public void setUp() throws Exception {
    sunk = new Sunk();
    sameRefSunk = sunk;
    sameStateSunk = new Sunk();
  }

  @Test
  public void getAttackResult() {
    String sunkResult = "Sunk – the cell is a part of the ship and all the other cells of " +
        "the ship were hit";
    Assert.assertEquals(sunkResult, sunk.getAttackResult());
  }

  @Test
  public void equals(){
    Sunk nullSunk = null;
    Sunk yetAnotherSunk = new Sunk();

    Assert.assertTrue(sunk.equals(sunk)); // reflexivity
    Assert.assertTrue(sunk.equals(sameRefSunk)); // trivial condition both reference same object
    Assert.assertEquals(sunk.equals(sameStateSunk), sameStateSunk.equals(sunk)); // symmetry
    Assert.assertEquals(sunk.equals(sameStateSunk)
            && sameStateSunk.equals(yetAnotherSunk),
        yetAnotherSunk.equals(sunk)); // transitivity
    Assert.assertFalse(sunk.equals(nullSunk)); // hit is not null
  }

  @Test
  public void testHashCode(){
    Assert.assertEquals(sunk.equals(sameRefSunk),
        sunk.hashCode() == sameRefSunk.hashCode());
    Assert.assertEquals(sunk.equals(sameStateSunk),
        sunk.hashCode() == sameStateSunk.hashCode());
  }

  @Test
  public void testToString(){
    Assert.assertEquals("Sunk{}", sunk.toString());
  }
}