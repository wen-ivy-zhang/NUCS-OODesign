package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AttackResultTest {

  private AttackResult miss;
  private AttackResult hit;
  private AttackResult sunk;

  @Before
  public void setUp() throws Exception {
    miss = new Miss();
    hit = new Hit();
    sunk = new Sunk();
  }

  @Test
  public void getAttackResult() {

    String missResult = "Miss – the guessed cell does not contain a ship";
    String hitResult = "Hit – the cell is a part of the ship, but there are other cells that " +
        "have not been hit yet";
    String sunkResult = "Sunk – the cell is a part of the ship and all the other cells of " +
        "the ship were hit";

    Assert.assertEquals(missResult, miss.getAttackResult());
    Assert.assertEquals(hitResult, hit.getAttackResult());
    Assert.assertEquals(sunkResult, sunk.getAttackResult());
  }
}