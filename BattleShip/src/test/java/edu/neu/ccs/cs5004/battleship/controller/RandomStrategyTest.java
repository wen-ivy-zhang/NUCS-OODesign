package edu.neu.ccs.cs5004.battleship.controller;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.view.DebugView;
import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;

public class RandomStrategyTest {

  RandomStrategy randomStrategy;
  IMap emptyMap;
  IConsolePrinter printer;

  @Before
  public void setUp() throws Exception {
    randomStrategy = new RandomStrategy();
    emptyMap = IMap.createEmptyMap();
    printer = new DebugView();
  }

  @Test
  public void chooseCellToAttack() {
    System.out.println(randomStrategy.chooseCellToAttack(emptyMap));
  }
}