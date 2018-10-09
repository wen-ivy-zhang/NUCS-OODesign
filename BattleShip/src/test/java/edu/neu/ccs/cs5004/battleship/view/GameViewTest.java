package edu.neu.ccs.cs5004.battleship.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.InvalidCallException;
import edu.neu.ccs.cs5004.battleship.model.Map;

public class GameViewTest {
  private GameView gameView;
  private GameView sameRefGameView;
  private GameView sameStateGameView;
  private GameView yetAnotherGameView;
  private ConsolePrinter diffGameView;
  private GameView nullGameView;
  private IMap userFleetMap;
  private IMap computerFleetMap;
  private IMap userBattleMap;
  private IMap computerBattleMap;


  @Before
  public void setUp() throws Exception {
    gameView = new GameView();
    sameRefGameView = gameView;
    sameStateGameView = new GameView();
    yetAnotherGameView = new GameView();
    diffGameView = new DebugView();
    nullGameView = null;
    userFleetMap = new Map();
    computerFleetMap = new Map();
    userBattleMap = new Map();
    computerBattleMap = new Map();
  }

  @Test (expected = InvalidCallException.class)
  public void getUserInputNumOfBattleShips() throws UnsupportedEncodingException {
    String userInput = "x";
    InputStream mockUserInput = new ByteArrayInputStream(userInput.getBytes("UTF-8"));
    gameView.getUserInputNumOfBattleShips(mockUserInput);

  }

  @Test (expected = InvalidCallException.class)
  public void getUserInputNumOfCruisers() throws UnsupportedEncodingException {
    String userInput = "1";
    InputStream mockUserInput = new ByteArrayInputStream(userInput.getBytes("UTF-8"));
    gameView.getUserInputNumOfCruisers(mockUserInput);
  }

  @Test(expected = InvalidCallException.class)
  public void getUserInputNumOfSubmarine() throws UnsupportedEncodingException {
    String userInput = "2";
    InputStream mockUserInput = new ByteArrayInputStream(userInput.getBytes("UTF-8"));
    gameView.getUserInputNumOfSubmarine(mockUserInput);
  }

  @Test(expected = InvalidCallException.class)
  public void getUserInputNumOfDestroyer() throws UnsupportedEncodingException {
    String userInput = "3";
    InputStream mockUserInput = new ByteArrayInputStream(userInput.getBytes("UTF-8"));
    gameView.getUserInputNumOfDestroyer(mockUserInput);
  }

  @Test
  public void update() {
    gameView.update(userFleetMap, computerFleetMap, userBattleMap,
        computerBattleMap);

  }

  @Test
  public void equals() {
    Assert.assertTrue(gameView.equals(sameRefGameView));
    Assert.assertTrue(gameView.equals(sameStateGameView));
    Assert.assertTrue(sameStateGameView.equals(gameView));
    Assert.assertEquals(gameView.equals(sameStateGameView)&&sameStateGameView.equals(yetAnotherGameView),
        yetAnotherGameView.equals(gameView));
    Assert.assertFalse(gameView.equals(diffGameView));
    Assert.assertFalse(gameView.equals(nullGameView));
  }

  @Test
  public void testHashCode() {
    Assert.assertTrue(gameView.hashCode() == sameStateGameView.hashCode());
    Assert.assertTrue(gameView.hashCode() == sameRefGameView.hashCode());

  }

  @Test
  public void testToString() {
    Assert.assertEquals(gameView.toString(), "GameView{} ConsolePrinter{view=null}");
  }
}