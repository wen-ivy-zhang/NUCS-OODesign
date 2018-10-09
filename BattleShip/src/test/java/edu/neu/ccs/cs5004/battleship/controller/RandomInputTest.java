package edu.neu.ccs.cs5004.battleship.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomInputTest {
  private IRandomInput randomInput;


  @Before
  public void setUp() throws Exception {
    this.randomInput = new RandomInput();
  }

  @Test
  public void generateRandomPosition() {
    this.randomInput.generateRandomPosition();
  }

  @Test
  public void generateRandomDirection() {
    this.randomInput.generateRandomDirection();
  }
}

