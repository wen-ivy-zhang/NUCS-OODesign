package edu.neu.ccs.cs5004.battleship.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.battleship.model.EnemyShipCell;
import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.OpenSeaCell;
import edu.neu.ccs.cs5004.battleship.model.Position;
import edu.neu.ccs.cs5004.battleship.view.GameView;
import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;

public class SmartStrategyTest {
  SmartStrategy smartStrategy;
  IMap battleMap;
  Position posnC2;
  Position posnB1;
  Position posnB2;
  Position posnB3;
  Position posnB4;
  IConsolePrinter printer;

  @Before
  public void setUp() throws Exception {
    smartStrategy = new SmartStrategy();
    printer = new GameView();
    battleMap = IMap.createEmptyMap();
    posnC2 = new Position("C 2");
    posnB1 = new Position("B 1");
    posnB2 = new Position("B 2");
    posnB3 = new Position("B 3");
    posnB4 = new Position("B 4");

  }

  @Test
  public void chooseCellToAttack() {
    System.out.println(smartStrategy.chooseCellToAttack(battleMap));
    battleMap.setCell(posnB2, new EnemyShipCell(true, false));
    Assert.assertEquals(posnC2, smartStrategy.chooseCellToAttack(battleMap));
    battleMap.setCell(posnB3, new EnemyShipCell(true, false));
    Assert.assertEquals(posnB1, smartStrategy.chooseCellToAttack(battleMap));

  }

  @Test
  public void findPotentialShipCell() {
    Assert.assertTrue(smartStrategy.findPotentialShipCell(battleMap) == null);
    battleMap.setCell(posnB2, new EnemyShipCell(true, false));
    Assert.assertEquals(posnC2, smartStrategy.findPotentialShipCell(battleMap));
    battleMap.setCell(posnB3, new EnemyShipCell(true, false));
    Assert.assertEquals(posnB1, smartStrategy.findPotentialShipCell(battleMap));
    battleMap.setCell(posnB1, new OpenSeaCell(true));
    Assert.assertEquals(posnB4, smartStrategy.findPotentialShipCell(battleMap));

  }

  @Test
  public void findSurroundingShipCell() {
    battleMap.setCell(new Position("I 6"), new EnemyShipCell(true, false));
    battleMap.setCell(new Position("I 7"), new EnemyShipCell(true, false));
    battleMap.setCell(new Position("I 8"), new EnemyShipCell(true, false));
    battleMap.setCell(new Position("I 9"), new OpenSeaCell(true));
    Assert.assertEquals(new Position("I 5"),
        smartStrategy.findSurroundingShipCell(battleMap, new Position("I 6")));
    Assert.assertEquals(null,
        smartStrategy.findSurroundingShipCell(battleMap, new Position("I 8")));
  }

  @Test
  public void getSurroundingCells() {
    List<Position> expected = new ArrayList<>();
    expected.add(new Position("A 2"));
    expected.add(new Position("B 1"));
    Assert.assertEquals(expected, smartStrategy.getSurroundingCells(new Position("A 1")));
  }

  @Test
  public void calculateShipCellPosition() {
    Assert.assertEquals(new Position("B 10"),
        smartStrategy.calculateShipCellPosition(new Position("B 9"),
            new Position("B 8")));

    Assert.assertEquals(new Position("F 1"),
        smartStrategy.calculateShipCellPosition(new Position("E 1"),
            new Position("D 1")));
  }

  @Test
  public void checkIsGapCell() {
    battleMap.setCell(posnC2, new EnemyShipCell(true, false));
    Assert.assertTrue(smartStrategy.checkIsGapCell(battleMap, posnB2));
    Assert.assertFalse(smartStrategy.checkIsGapCell(battleMap, posnB4));
  }
}