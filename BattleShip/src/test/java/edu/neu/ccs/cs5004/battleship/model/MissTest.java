package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MissTest {

  private Miss miss;
  private Miss sameRefMiss;
  private Miss sameStateMiss;

  @Before
  public void setUp() throws Exception {
    miss = new Miss();
    sameRefMiss = miss;
    sameStateMiss = new Miss();
  }

  @Test
  public void getAttackResult() {
    String missResult = "Miss – the guessed cell does not contain a ship";
    Assert.assertEquals(missResult, miss.getAttackResult());
  }

  @Test
  public void equals(){
    Miss nullMiss = null;
    Miss yetAnotherMiss = new Miss();

    Assert.assertTrue(miss.equals(miss)); // reflexivity
    Assert.assertTrue(miss.equals(sameRefMiss)); // trivial condition both reference same object
    Assert.assertEquals(miss.equals(sameStateMiss), sameStateMiss.equals(miss)); // symmetry
    Assert.assertEquals(miss.equals(sameStateMiss)
            && sameStateMiss.equals(yetAnotherMiss),
        yetAnotherMiss.equals(miss)); // transitivity
    Assert.assertFalse(miss.equals(nullMiss)); // hit is not null
  }

  @Test
  public void testHashCode(){
    Assert.assertEquals(miss.equals(sameRefMiss),
        miss.hashCode() == sameRefMiss.hashCode());
    Assert.assertEquals(miss.equals(sameStateMiss),
        miss.hashCode() == sameStateMiss.hashCode());
  }

  @Test
  public void testToString(){
    Assert.assertEquals("Miss{}", miss.toString());
  }
}