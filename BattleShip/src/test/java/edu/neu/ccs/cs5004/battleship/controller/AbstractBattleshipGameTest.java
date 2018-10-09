package edu.neu.ccs.cs5004.battleship.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;

import edu.neu.ccs.cs5004.battleship.model.BattleShip;
import edu.neu.ccs.cs5004.battleship.model.Cruiser;
import edu.neu.ccs.cs5004.battleship.model.EnemyShipCell;
import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.Position;
import edu.neu.ccs.cs5004.battleship.model.SpecificShipCell;
import edu.neu.ccs.cs5004.battleship.model.Submarine;
import edu.neu.ccs.cs5004.battleship.model.Sunk;
import edu.neu.ccs.cs5004.battleship.view.DebugView;
import edu.neu.ccs.cs5004.battleship.view.GameView;
import edu.neu.ccs.cs5004.battleship.view.IConsolePrinter;



public class AbstractBattleshipGameTest {
  private AbstractBattleshipGame debugGame;
  private AbstractBattleshipGame realGame;
  private AbstractBattleshipGame sameRefRealGame;
  private AbstractBattleshipGame sameStateRealGame;
  private AbstractBattleshipGame yetAnotherGame;
  private Integer  diffRealGame;
  private AbstractBattleshipGame nullRealGame;
  private MapController mapController;
  private ShipController shipController;
  private IConsolePrinter gameView;
  private IConsolePrinter debugView;
  private IMap userBattleMap;
  private IMap computerFleetMap;
  private Position p1;
  private Position p2;
  private Position p3;
  private Position p4;
  private Position p5;
  private Cruiser cruise;
  private Submarine submarine;
  private IConsolePrinter consolePrinter;

  @Before
  public void setUp() throws Exception {
    String userInput1 = "1\n";
    String userInput2 = "2\n";
    String userInput3 = "3\n";
    String userInput4 = "4";
    InputStream mockInputStream1 = new ByteArrayInputStream(userInput1.getBytes("UTF-8"));
    InputStream mockInputStream2 = new ByteArrayInputStream(userInput2.getBytes("UTF-8"));
    InputStream mockInputStream3 = new ByteArrayInputStream(userInput3.getBytes("UTF-8"));
    InputStream mockInputStream4 = new ByteArrayInputStream(userInput4.getBytes("UTF-8"));
    InputStream mockInputStreamAll1 =
        new SequenceInputStream(
            new SequenceInputStream(
                new SequenceInputStream(mockInputStream1, mockInputStream2), mockInputStream3), mockInputStream4);
    debugGame = new DebugMode(mockInputStreamAll1);
    realGame = new GameMode();
    sameRefRealGame = realGame;
    sameStateRealGame = new GameMode();
    yetAnotherGame = new GameMode();
    diffRealGame = new Integer (6);
    nullRealGame = null;
    mapController = new MapController();
    shipController = new ShipController();
    gameView = new GameView();
    debugView = new DebugView();
    userBattleMap = IMap.createEmptyMap();
    computerFleetMap = IMap.createEmptyMap();

    // set up computer fleet map.
    p1 = new Position("A 3");
    p2 = new Position("A 4");
    p3 = new Position("A 5");
    p4 = new Position("C 4");
    p5 = new Position("D 4");
    cruise = new Cruiser(3, 2);
    submarine = new Submarine();

    computerFleetMap.setCell(p1, new SpecificShipCell(true, false, cruise));
    computerFleetMap.setCell(p2, new SpecificShipCell(true, false, cruise));
    computerFleetMap.setCell(p3, new SpecificShipCell(false, false, cruise));
    computerFleetMap.setCell(p4, new SpecificShipCell(true, false, submarine));
    computerFleetMap.setCell(p5, new SpecificShipCell(false, false, submarine));


    // set up user battle map.
    userBattleMap.setCell(p1, new EnemyShipCell(true, false));
    userBattleMap.setCell(p2, new EnemyShipCell(true, false));
    userBattleMap.setCell(p4, new EnemyShipCell(true, false));
  }

  @Test
  public void getMapController() {
    Assert.assertEquals(mapController, realGame.getMapController());

  }

  @Test
  public void getShipController() {
    Assert.assertEquals(shipController, realGame.getShipController());
  }

  @Test
  public void getConsolePrinter() {
    Assert.assertEquals(gameView, realGame.getConsolePrinter());
    Assert.assertEquals(debugView, debugGame.getConsolePrinter());
  }


  @Test
  public void setConsolePrinter() {
    realGame.setConsolePrinter(debugView);
    Assert.assertEquals(debugView, realGame.getConsolePrinter());
  }

  @Test
  public void randomPlaceOneShip() {
    realGame.randomPlaceOneShip(new BattleShip(), realGame.getMapController().getUserFleetMap());
    realGame.getConsolePrinter().toConsole(realGame.getMapController().getUserFleetMap());
  }

  @Test
  public void userPlaceOneShip() throws UnsupportedEncodingException {
    String userInput2 = "A 7";
    InputStream mockInputStream2 = new ByteArrayInputStream(userInput2.getBytes("UTF-8"));
    String userInput3 = "H";
    InputStream mockInputStream3 = new ByteArrayInputStream(userInput3.getBytes("UTF-8"));
    realGame.userPlaceOneShip(new BattleShip(), realGame.getMapController().getUserFleetMap(),mockInputStream2,mockInputStream3);
    realGame.getConsolePrinter().toConsole(realGame.getMapController().getUserFleetMap());
  }

  @Test
  public void randomPlacement() {
    realGame.randomPlacement(realGame.getMapController().getUserFleetMap(),
        realGame.getShipController().getUserShips());
    realGame.getConsolePrinter().toConsole(realGame.getMapController().getUserFleetMap());
   // debugGame.randomPlacement(debugGame.getMapController().getUserFleetMap());
    //debugGame.getConsolePrinter().toConsole(debugGame.getMapController().getUserFleetMap());
  }

//  @Test
//  public void userPlacement() {
//    realGame.userPlacement(realGame.getMapController().getUserFleetMap());
//    realGame.getConsolePrinter().toConsole(realGame.getMapController().getUserFleetMap());
//  }

  @Test
  public void placeShipsOnUserFleetMap() throws UnsupportedEncodingException {
    String userInput1 = "R";
    InputStream mockInputStream1 = new ByteArrayInputStream(userInput1.getBytes("UTF-8"));
    String userInput2 = "A 7";
    InputStream mockInputStream2 = new ByteArrayInputStream(userInput2.getBytes("UTF-8"));
    String userInput3 = "H";
    InputStream mockInputStream3 = new ByteArrayInputStream(userInput3.getBytes("UTF-8"));
    realGame.placeShipsOnUserFleetMap(mockInputStream1,mockInputStream2,mockInputStream3);
    realGame.getConsolePrinter().toConsole(realGame.getMapController().getUserFleetMap());
    String userInput4 = "R";
    InputStream mockInputStream4 = new ByteArrayInputStream(userInput4.getBytes("UTF-8"));
    String userInput5 = "B 7";
    InputStream mockInputStream5 = new ByteArrayInputStream(userInput5.getBytes("UTF-8"));
    String userInput6 = "V";
    InputStream mockInputStream6 = new ByteArrayInputStream(userInput6.getBytes("UTF-8"));
    debugGame.placeShipsOnUserFleetMap(mockInputStream4,mockInputStream5,mockInputStream6);
    debugGame.getConsolePrinter().toConsole(debugGame.getMapController().getUserFleetMap());

  }

  @Test
  public void placeShipsOnComputerFleetMap() {
    debugGame.placeShipsOnComputerFleetMap();
    debugGame.getConsolePrinter().toConsole(debugGame.getMapController().getComputerFleetMap());
    realGame.placeShipsOnComputerFleetMap();
    realGame.getConsolePrinter().toConsole(realGame.getMapController().getComputerFleetMap());
  }


//  @Test
//  public void setUpGame() {
//    //there's no way to test set up game
//    //please test through main function.
//  }

  @Test
  public void equals() {
    Assert.assertTrue(this.realGame.equals(sameRefRealGame));
    Assert.assertTrue(this.realGame.equals(sameStateRealGame));
    Assert.assertTrue(this.sameStateRealGame.equals(realGame));
    Assert.assertEquals(this.realGame.equals(sameStateRealGame)&&sameStateRealGame.equals(yetAnotherGame),
        yetAnotherGame.equals(realGame));
    Assert.assertFalse(this.realGame.equals(diffRealGame));
    Assert.assertFalse(this.realGame.equals(nullRealGame));
    Assert.assertFalse(this.realGame.equals(debugGame));
  }

  @Test
  public void testHashCode() {
    Assert.assertTrue(this.realGame.hashCode() == sameRefRealGame.hashCode());
    Assert.assertTrue(this.realGame.hashCode() == sameStateRealGame.hashCode());
  }


  @Test
  public void chooseGameMode() throws UnsupportedEncodingException {
    String userInput = "D";
    InputStream mockInputStream = new ByteArrayInputStream(userInput.getBytes("UTF-8"));
    //String userInput2 = "1\n" + "2\n" + "3\n" + "4\n";
    String userInput1 = "1\n";
    String userInput2 = "2\n";
    String userInput3 = "3\n";
    String userInput4 = "4";
    InputStream mockInputStream1 = new ByteArrayInputStream(userInput1.getBytes("UTF-8"));
    InputStream mockInputStream2 = new ByteArrayInputStream(userInput2.getBytes("UTF-8"));
    InputStream mockInputStream3 = new ByteArrayInputStream(userInput3.getBytes("UTF-8"));
    InputStream mockInputStream4 = new ByteArrayInputStream(userInput4.getBytes("UTF-8"));
    InputStream mockInputStreamAll1 =
        new SequenceInputStream(
            new SequenceInputStream(
                new SequenceInputStream(mockInputStream1, mockInputStream2), mockInputStream3), mockInputStream4);
    String userInput5 = "1\n";
    String userInput6 = "2\n";
    String userInput7 = "3\n";
    String userInput8 = "4";
    InputStream mockInputStream5 = new ByteArrayInputStream(userInput5.getBytes("UTF-8"));
    InputStream mockInputStream6 = new ByteArrayInputStream(userInput6.getBytes("UTF-8"));
    InputStream mockInputStream7 = new ByteArrayInputStream(userInput7.getBytes("UTF-8"));
    InputStream mockInputStream8 = new ByteArrayInputStream(userInput8.getBytes("UTF-8"));
    InputStream mockInputStreamAll2 =
        new SequenceInputStream(
            new SequenceInputStream(
                new SequenceInputStream(mockInputStream5, mockInputStream6), mockInputStream7), mockInputStream8);
    Assert.assertTrue(realGame.chooseGameMode(mockInputStream, mockInputStreamAll1).equals(new DebugMode(mockInputStreamAll2)));

    String userInput9 = "g";
    InputStream mockInputStream9 = new ByteArrayInputStream(userInput9.getBytes("UTF-8"));
    Assert.assertTrue(realGame.chooseGameMode(mockInputStream9, mockInputStreamAll1).equals(new GameMode()));


  }


//  @Test
//  public void playGame() {
//    //there is no way to test playGame
//    // please test through main function
//  }

  @Test
  public void endGame() {
    debugGame.endGame(GameResult.USER_WIN);
    debugGame.endGame(GameResult.COMPUTER_WIN);
    realGame.endGame(GameResult.COMPUTER_WIN);
    realGame.endGame(GameResult.USER_WIN);

  }

  @Test
  public void checkIsGameOver() {
    this.realGame.setShipController(new ShipController(true));
    Assert.assertTrue(this.realGame.checkIsGameOver());
    this.debugGame.setShipController(new ShipController(false));
    Assert.assertTrue(this.realGame.checkIsGameOver());

  }

//  @Test
//  public void userAttack() {
//
//  }
//
//  @Test
//  public void computerAttack() {
//
//  }

  @Test
  public void oneRoundOfAttack() {
    System.out.println("Before one round, computer fleet map is: ");
    gameView.toConsole(computerFleetMap);
    System.out.println("Before one round, user battle map is: ");
    gameView.toConsole(userBattleMap);

    System.out.println("Posn: " + p1 + computerFleetMap.getCell(p1).getIsHit());
    System.out.println("Posn: " + p2 + computerFleetMap.getCell(p2).getIsHit());
    System.out.println("Posn: " + p3 + computerFleetMap.getCell(p3).getIsHit());


    realGame.oneRoundOfAttack(IStrategy.createRandomStrategy(), computerFleetMap, userBattleMap);
    System.out.println("after one round, computer fleet map is: ");
    gameView.toConsole(computerFleetMap);
    System.out.println("after one round, user battle map is: ");
    gameView.toConsole(userBattleMap);
  }

  @Test
  public void updateFleetMapAfterAttack() {

    System.out.println("computer fleet map before attack :");
    gameView.toConsole(computerFleetMap);
    realGame.getMapController().updateBattleMapAfterAttack(p3, new Sunk(), computerFleetMap);
    System.out.println("computer fleet map after  attack :");
    gameView.toConsole(computerFleetMap);

    Assert.assertEquals(true, computerFleetMap.getCell(p1).getIsSunk());
    Assert.assertEquals(true, computerFleetMap.getCell(p2).getIsSunk());
    Assert.assertEquals(false, computerFleetMap.getCell(p4).getIsSunk());
  }

  @Test
  public void updateBattleMapAfterAttack() {
    realGame.getMapController().updateBattleMapAfterAttack(p3, new Sunk(), userBattleMap);
    Assert.assertEquals(true, userBattleMap.getCell(p1).getIsSunk());
    Assert.assertEquals(true, userBattleMap.getCell(p2).getIsSunk());
    Assert.assertEquals(false, userBattleMap.getCell(p4).getIsSunk());
  }
}