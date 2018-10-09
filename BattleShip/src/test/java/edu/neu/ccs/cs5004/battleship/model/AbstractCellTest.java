package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;

public class AbstractCellTest {

  private AbstractCell abstractCell;
  private AbstractCell sameRefAbstractCell;
  private AbstractCell sameStateAbstractCell;
  private AbstractCell diffAbstractCell;

  @Before
  public void setUp() throws Exception {
    abstractCell = new OpenSeaCell(false);
    sameRefAbstractCell = abstractCell;
    sameStateAbstractCell = new OpenSeaCell(false);
    diffAbstractCell = new OpenSeaCell(true);
  }

  @Test
  public void equals() {
    AbstractCell yetAnotherAbstractCell = new OpenSeaCell(false);
    AbstractCell nullAbstractCell = null;

    Assert.assertTrue(abstractCell.equals(abstractCell)); // reflexivity
    Assert.assertTrue(abstractCell.equals(sameRefAbstractCell)); // trivial condition both reference same object
    Assert.assertEquals(abstractCell.equals(sameStateAbstractCell), sameStateAbstractCell.equals(abstractCell)); // symmetry
    Assert.assertEquals(abstractCell.equals(sameStateAbstractCell)
            && sameStateAbstractCell.equals(yetAnotherAbstractCell),
        yetAnotherAbstractCell.equals(abstractCell)); // transitivity
    Assert.assertFalse(abstractCell.equals(diffAbstractCell)); // objects have different state
    Assert.assertFalse(abstractCell.equals(nullAbstractCell)); // abstractCell is not null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(abstractCell.equals(sameRefAbstractCell),
        abstractCell.hashCode() == sameRefAbstractCell.hashCode());
    Assert.assertEquals(abstractCell.equals(sameStateAbstractCell),
        abstractCell.hashCode() == sameStateAbstractCell.hashCode());
    Assert.assertFalse(abstractCell.hashCode() == diffAbstractCell.hashCode());
  }

  @Test
  public void getIsHit() {
    Assert.assertEquals(false, abstractCell.getIsHit());
  }

  @Test
  public void setHit() {
  }

  @Test
  public void registerObserver() {
  }

  @Test
  public void notifyObserver() {
    IConsolePrinter printer = IConsolePrinter.createDebugView();
    IMap map = IMap.createEmptyMap();
    Position p1 = new Position("A 3");
    Position p2 = new Position("A 4");
    Position p3 = new Position("A 5");
    Position p4 = new Position("C 4");
    map.setCell(p1, new EnemyShipCell(true, false));
    map.setCell(p2, new EnemyShipCell(true, false));
    map.setCell(p3, new EnemyShipCell(true, true));
    map.setCell(p4, new EnemyShipCell(true, false));
    System.out.println("before notify observers, map is:");
    printer.toConsole(map);
    map.getCell(p3).notifyObserver();
    System.out.println("after notify observers, map is:");
    printer.toConsole(map);

    Assert.assertEquals(true, map.getCell(p1).getIsSunk());
    Assert.assertEquals(true, map.getCell(p2).getIsSunk());
    Assert.assertEquals(false, map.getCell(p4).getIsSunk());
  }

  @Test
  public void update() {


  }

}