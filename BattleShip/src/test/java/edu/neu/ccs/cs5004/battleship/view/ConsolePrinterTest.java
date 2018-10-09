package edu.neu.ccs.cs5004.battleship.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import edu.neu.ccs.cs5004.battleship.controller.GameResult;
import edu.neu.ccs.cs5004.battleship.controller.GameType;
import edu.neu.ccs.cs5004.battleship.controller.PlacementType;
import edu.neu.ccs.cs5004.battleship.model.Cruiser;
import edu.neu.ccs.cs5004.battleship.model.Direction;
import edu.neu.ccs.cs5004.battleship.model.EnemyShipCell;
import edu.neu.ccs.cs5004.battleship.model.Hit;
import edu.neu.ccs.cs5004.battleship.model.Map;
import edu.neu.ccs.cs5004.battleship.model.OpenSeaCell;
import edu.neu.ccs.cs5004.battleship.model.Position;
import edu.neu.ccs.cs5004.battleship.model.SpecificShipCell;
import edu.neu.ccs.cs5004.battleship.model.WaterCell;


public class ConsolePrinterTest {


  private ConsolePrinter printer;
  private ConsolePrinter sameRefPrinter;
  private ConsolePrinter sameStatePrinter;
  private ConsolePrinter diffPrinter;
  private StringBuilder tempView;
  private SpecificShipCell specificShipCell1;
  private SpecificShipCell specificShipCell2;
  private SpecificShipCell specificShipCell3;
  private EnemyShipCell enemyShipCell;
  private WaterCell waterCell;
  private Cruiser cruiser1;
  private Cruiser cruiser2;
  private Cruiser cruiser3;
  private EnemyShipCell enemyShipCell1;
  private EnemyShipCell enemyShipCell2;



  @Before
  public void setUp() throws Exception {
    this.tempView = new StringBuilder(10);
    printer = new DebugView();
    printer.view = this.tempView;
    System.out.println("checkpoint 0" + printer);
    sameRefPrinter = printer;
    sameStatePrinter = new DebugView();
    diffPrinter = new GameView();

    cruiser1 = new Cruiser();
    cruiser2 = new Cruiser(3,1 );
    cruiser3 = new Cruiser(3, 3);
    System.out.println("checkpoint 1");
    specificShipCell1 = new SpecificShipCell(false, false,cruiser1);
    System.out.println("checkpoint 2 " + specificShipCell1);
    specificShipCell2 = new SpecificShipCell(true,false,cruiser2);
    specificShipCell3 = new SpecificShipCell(true, true, cruiser3);
    enemyShipCell1 = new EnemyShipCell(true, true);
    enemyShipCell2 = new EnemyShipCell(true,false);

  }

  @Test
  public void toConsole() {
    Map map = new Map();
    printer.toConsole(map);
  }

  @Test
  public void printColumnIndex() {
    printer.printColumnIndex(10);
  }

  @Test
  public void equals() {
    ConsolePrinter nullPrinter = null;
    ConsolePrinter yetAnotherPrinter = new DebugView();

    // reflexivity
    Assert.assertTrue(printer.equals(printer));
    // trivial condition both reference the same object
    Assert.assertTrue(printer.equals(sameRefPrinter));
    // symmetry
    Assert.assertEquals(printer.equals(sameStatePrinter), sameStatePrinter.equals(printer));
    //transitivity
    Assert.assertEquals(printer.equals(sameStatePrinter) &&
            sameStatePrinter.equals(yetAnotherPrinter),
        yetAnotherPrinter.equals(printer));
    //objects are different
    Assert.assertFalse(printer.equals(diffPrinter));
    // printer is NOT null
    Assert.assertFalse(printer.equals(nullPrinter));
  }

  @Test
  public void testHashCode() {
    Assert.assertTrue(
        printer.hashCode() == sameRefPrinter.hashCode());
    Assert.assertTrue(
        printer.hashCode() == sameStatePrinter.hashCode());

  }

  @Test
  public void testToString() {
    String tempRes = "DebugView{} ConsolePrinter{view=}";
    Assert.assertEquals(tempRes, printer.toString());
  }

  @Test
  public void toConsole1() {

   StringBuilder temp1 = new StringBuilder(10);
   temp1.append(printer.LIVE);
   StringBuilder temp2 = new StringBuilder(10);
   temp2.append(printer.LIVE);
   temp2.append(printer.HIT);
   StringBuilder temp3 = new StringBuilder(10);
   temp3.append(printer.LIVE);
   temp3.append(printer.HIT);
   temp3.append(printer.SUNK);
   printer.toConsole(specificShipCell1);
   Assert.assertEquals(printer.view.toString(), temp1.toString());
   printer.toConsole(specificShipCell2);
   Assert.assertEquals(printer.view.toString(), temp2.toString());
   printer.toConsole(specificShipCell3);
   Assert.assertEquals(printer.view.toString(), temp3.toString());


  }


  @Test
  public void toConsole2() {
    StringBuilder temp1 = new StringBuilder();
    temp1.append(printer.SUNK);
    StringBuilder temp2 = new StringBuilder();
    temp2.append(printer.SUNK);
    temp2.append(printer.HIT);
    printer.toConsole(enemyShipCell1);
    Assert.assertEquals(printer.view.toString(), temp1.toString());
    printer.toConsole(enemyShipCell2);
    Assert.assertEquals(printer.view.toString(),temp2.toString());

  }


  @Test
  public void toConsole3() {
    StringBuilder temp1 = new StringBuilder();
    temp1.append(printer.ATTACK_WATER);
    StringBuilder temp2 = new StringBuilder();
    temp2.append(printer.ATTACK_WATER);
    temp2.append(printer.WATER);
    printer.toConsole(new OpenSeaCell(true));
    Assert.assertEquals(printer.view.toString(),temp1.toString());
    printer.toConsole(new OpenSeaCell(false));
    Assert.assertEquals(printer.view.toString(), temp2.toString());
  }



  @Test
  public void getUserInputGameMode1() throws UnsupportedEncodingException {
    String sampleUserInput1 = "D";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    Assert.assertEquals(GameType.DEBUG_MODE,printer.getUserInputGameMode(mockInputStream1));
    String sampleUserInput2 = "G";
    InputStream mockInputStream2 = new ByteArrayInputStream(sampleUserInput2.getBytes("UTF-8"));
    Assert.assertEquals(GameType.GAME_MODE, printer.getUserInputGameMode(mockInputStream2));
//    String sampleUserInput3 = "E";
//    InputStream mockInputStream3 = new ByteArrayInputStream(sampleUserInput3.getBytes("UTF-8"));
//    printer.getUserInputGameMode(mockInputStream3);
  }



//  @Test
//  public void getUserInputGameMode2() throws UnsupportedEncodingException {
//    String sampleUserInput1 = "1";
//    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
//    Assert.assertEquals("expect letter 'D' or letter 'G'given: 1",printer.getUserInputGameMode(mockInputStream1));
//  }


  @Test
  public void getUserInputPosition() throws UnsupportedEncodingException {
   String sampleUserInput = "A 10";
   InputStream mockInputStream = new ByteArrayInputStream(sampleUserInput.getBytes("UTF-8"));
   Assert.assertEquals(new Position(10,'A'), printer.getUserInputPosition(mockInputStream));
   }

  @Test
  public void getUserInputDirection() throws UnsupportedEncodingException {
    String sampleUserInput = "H";
    InputStream mockInputStream = new ByteArrayInputStream(sampleUserInput.getBytes("UTF-8"));
    Assert.assertEquals(Direction.HORIZONTAL,printer.getUserInputDirection(mockInputStream));
    String sampleUserInput1 = "V";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    Assert.assertEquals(Direction.VERTICAL, printer.getUserInputDirection(mockInputStream1));

  }

  @Test
  public void getUserInputPlacement() throws UnsupportedEncodingException {
    String sampleUserInput = "R";
    InputStream mockInputStream = new ByteArrayInputStream(sampleUserInput.getBytes("UTF-8"));
    Assert.assertEquals(PlacementType.RANDOM_PLACEMENT,printer.getUserInputPlacement(mockInputStream));
    String sampleUserInput1 = "U";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    Assert.assertEquals(PlacementType.USER_PLACEMENT, printer.getUserInputPlacement(mockInputStream1));
  }

  @Test
  public void displayErrorMessage() {
    printer.displayErrorMessage("error");
  }

  @Test
  public void printGreeting() {
    printer.printGreeting();
  }

  @Test
  public void startComputerShipPlacement() {
    printer.startComputerShipPlacement();
  }

  @Test
  public void startUserShipPlacement() {
    printer.startUserShipPlacement();
  }

  @Test
  public void completeComputerShipPlacement() {
    printer.completeComputerShipPlacement();
  }

  @Test
  public void completeUserShipPlacement() {
    printer.completeUserShipPlacement();
  }

  @Test
  public void startGameView() {
    printer.startGameView();

  }


  @Test
  public void userAttackView() {
    printer.userAttackView();
  }

  @Test
  public void computerAttackView() {
    printer.computerAttackView();
  }

  @Test
  public void displayAttackedPosition() {
    printer.displayAttackedPosition(new Position(3,5));
  }

  @Test
  public void displayAttackResult() {
    printer.displayAttackResult(new Hit());

  }

  @Test
  public void endGameView() {
    printer.endGameView(GameResult.USER_WIN);
  }


}
