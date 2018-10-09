package edu.neu.ccs.cs5004.battleship.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.OpenSeaCell;
import edu.neu.ccs.cs5004.battleship.model.Position;
import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;



public class UserStrategyTest {

  IMap map;
  IConsolePrinter printer;
  InputStream stream;
  UserStrategy userStrategy;

  @Before
  public void setUp() throws Exception {
    map = IMap.createEmptyMap();
    printer = IConsolePrinter.createDebugView();
    map.setCell(new Position("B 2"), new OpenSeaCell(true));
    userStrategy = new UserStrategy(printer, stream);
  }

  @Test
  public void chooseCellToAttack() throws UnsupportedEncodingException {
    String userInput = "A 3";
    InputStream mockUserInput = new ByteArrayInputStream(userInput.getBytes("UTF-8"));
    this.userStrategy.stream = mockUserInput;
    Assert.assertTrue(new Position(3,'A').equals(this.userStrategy.chooseCellToAttack(map)));
  }
}