package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;


public class MapTest {

  private Map map;
  private Map sameRefMap;
  private Map sameStateMap;
  private Map diffMap;
  private OpenSeaCell openSeaCell;
  private EnemyShipCell enemyShipCell;
  private Cell[][] cells;
  private Position posnA1;
  private Position posnB2;
  private Submarine submarine;

  @Before
  public void setUp() throws Exception {
    map = new Map();
    sameRefMap = map;
    sameStateMap = new Map();
    diffMap = new Map();
    openSeaCell = new OpenSeaCell(false);
    enemyShipCell = new EnemyShipCell(false, false);
    posnA1 = new Position("A 1");
    posnB2 = new Position("B 2");
    diffMap.setCell(posnA1, enemyShipCell);
    submarine = new Submarine();
    cells = new Cell[10][10];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        cells[i][j] = openSeaCell;
      }
    }
  }

  @Test
  public void getCells() {
    Assert.assertArrayEquals(cells, map.getCells());
//    List<Cell> neighbors = map.getCell(posnA1).getCellObeservers();
//    for (Cell neighbor : neighbors) {
//      System.out.println(neighbor);
//    }

  }

  @Test
  public void getCell() {
    Assert.assertEquals(openSeaCell, map.getCell(posnA1));
    Assert.assertEquals(enemyShipCell, diffMap.getCell(posnA1));
  }

  @Test
  public void setCell() {
    diffMap.setCell(posnB2, enemyShipCell);
    Assert.assertEquals(enemyShipCell, diffMap.getCell(posnB2));
  }

  @Test
  public void prettyPrint() {
    IConsolePrinter printer = IConsolePrinter.createDebugView();
    map.prettyPrint(printer);
    BattleShip battleShip = new BattleShip(4, 0);
    SpecificShipCell specificShipCell = new SpecificShipCell(false, false, battleShip);
    GapCell gapCell = new GapCell(false);
    map.setCell(new Position("A 1"), specificShipCell);
    map.setCell(new Position("B 2"), gapCell);
    map.setCell(new Position("C 3"), enemyShipCell);
    map.setCell(new Position("D 4"), gapCell);
    map.setCell(new Position("E 5"), specificShipCell);
    map.setCell(new Position("F 6"), gapCell);
    map.setCell(new Position("G 7"), enemyShipCell);
    map.setCell(new Position("H 8"), gapCell);
    map.setCell(new Position("I 9"), specificShipCell);
    map.setCell(new Position("J 10"), gapCell);
    map.prettyPrint(printer);

  }

  @Test
  public void equals() {
    Map nullMap = null;
    Map yetAnoherMap = new Map();

    // reflexivity
    Assert.assertTrue(map.equals(map));
    // trivial condition both reference the same object
    Assert.assertTrue(map.equals(sameRefMap));
    // symmetry
    Assert.assertEquals(map.equals(sameStateMap), sameStateMap.equals(map));
    //transitivity
    Assert.assertEquals(map.equals(sameStateMap) &&
            sameStateMap.equals(yetAnoherMap),
        yetAnoherMap.equals(map));
    //objects are different
    Assert.assertFalse(map.equals(diffMap));
    // printer is NOT null
    Assert.assertFalse(map.equals(nullMap));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(map.equals(sameRefMap),
        map.hashCode() == sameRefMap.hashCode());
    Assert.assertEquals(map.equals(sameStateMap),
        map.hashCode() == sameStateMap.hashCode());
    Assert.assertEquals(map.equals(diffMap),
        map.hashCode() == diffMap.hashCode());
  }

  @Test
  public void testToString() {

    StringBuilder cellString = new StringBuilder();
    for (int i = 0; i < map.getCells().length; i++) {
      for (int j = 0; j < map.getCells()[0].length; j++) {
        cellString = cellString.append(cells[i][j].toString()).append("\n");
      }
    }
    String tempRes ="Map{"
        + "map=" + cellString
        + '}';
    Assert.assertEquals(tempRes, map.toString());
  }

  @Test
  public void checkPosition() {
    Assert.assertTrue(map.checkPosition(new Position("A 3"),
        Direction.HORIZONTAL, 4));
    Assert.assertFalse(map.checkPosition(new Position("I 1"),
        Direction.HORIZONTAL, 3));
    Assert.assertFalse(map.checkPosition(new Position("A 9"),
        Direction.VERTICAL, 3));
    Assert.assertFalse(diffMap.checkPosition(new Position("A 1"),
        Direction.VERTICAL, 3));
  }



  @Test
  public void getNextPosition() {
    Assert.assertEquals(new Position("B 1"),
        map.getNextPosition(posnA1, Direction.HORIZONTAL));
    Assert.assertEquals(new Position("A 2"),
        map.getNextPosition(posnA1, Direction.VERTICAL));

  }

  @Test
  public void setShipCells() {

    Position posn = new Position("B 2");
    map.setShipCells(posn, Direction.HORIZONTAL, submarine);
    int numOfCells = submarine.getSize();

    for (int i = 0; i < numOfCells; i++) {

    }
    for (int i = 0; i < numOfCells; i++) {
      Assert.assertEquals(map.getCell(posn),
          new SpecificShipCell(false, false, submarine));
      if (i == numOfCells - 1) {
        break;
      }
      posn = map.getNextPosition(posn, Direction.HORIZONTAL);
    }
  }

  @Test
  public void updateCellsAroundShipCell() {
    GapCell gapCell = new GapCell(false);
    diffMap.updateCellsAroundShipCell(posnA1);
    Assert.assertEquals(gapCell, diffMap.getCell(new Position("A 2")));
    Assert.assertEquals(gapCell, diffMap.getCell(new Position("B 2")));
    Assert.assertEquals(gapCell, diffMap.getCell(new Position("B 1")));

  }

  @Test
  public void updateCellsAroundShip() {
    Position posn = new Position("B 2");
    map.setShipCells(posn, Direction.HORIZONTAL, submarine);
    map.updateCellsAroundShip(posn, Direction.HORIZONTAL, submarine.getSize());
    cells = map.getCells();
    int row = posn.getRowIndex();
    int column = posn.getColumnIndex();
    for (int i = row - 1; i <= row + 1; i++) {
      for (int j = column -1; j <= column + 2; j++) {
        if ((i == row && j == column) || (i == row && j == column + 1)) {
          continue;
        }
        Assert.assertEquals(new GapCell(false), cells[i][j]);
      }
    }
  }

  @Test(expected = InvalidArgumentException.class)
  public void placeShipOnMap() {
    map.placeShipOnMap(new Position("A 10"), Direction.VERTICAL, submarine);
  }

  @Test
  public void placeShipOnMap1() {
    Position posn = new Position("B 2");
    map.setShipCells(posn, Direction.HORIZONTAL, submarine);
    map.updateCellsAroundShip(posn, Direction.HORIZONTAL, submarine.getSize());
    cells = map.getCells();
    int row = posn.getRowIndex();
    int column = posn.getColumnIndex();
    int numOfCells = submarine.getSize();

    for (int i = 0; i < numOfCells; i++) {
      Assert.assertEquals(map.getCell(posn),
          new SpecificShipCell(false, false, submarine));
      if (i == numOfCells - 1) {
        break;
      }
      posn = map.getNextPosition(posn, Direction.HORIZONTAL);
    }

    for (int i = row - 1; i <= row + 1; i++) {
      for (int j = column -1; j <= column + 2; j++) {
        if ((i == row && j == column) || (i == row && j == column + 1)) {
          continue;
        }
        Assert.assertEquals(new GapCell(false), cells[i][j]);
      }
    }
  }

  @Test
  public void getNeignborCells() {
    List<Position> neighbors = map.getNeighborCells(posnA1);
    List<Position> expectedNeighbors = new ArrayList<>();
    expectedNeighbors.add(new Position("B 1"));
    expectedNeighbors.add(new Position("A 2"));
    expectedNeighbors.add(new Position("B 2"));
    Assert.assertEquals(expectedNeighbors, neighbors);
  }


}