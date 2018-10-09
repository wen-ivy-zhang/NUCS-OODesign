package edu.neu.ccs.cs5004.battleship.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;

import edu.neu.ccs.cs5004.battleship.model.IMap;
import edu.neu.ccs.cs5004.battleship.model.Map;

public class DebugViewTest {
  private DebugView debugView;
  private DebugView sameRefDebugView;
  private DebugView sameStateDebugView;
  private DebugView yetAnotherDebugView;
  private ConsolePrinter diffDebugView;
  private DebugView nullDebugView;
  private IMap userFleetMap;
  private IMap computerFleetMap;
  private IMap userBattleMap;
  private IMap computerBattleMap;


  @Before
  public void setUp() throws Exception {
    debugView = new DebugView();
    sameRefDebugView = debugView;
    sameStateDebugView = new DebugView();
    yetAnotherDebugView = new DebugView();
    diffDebugView = new GameView();
    nullDebugView = null;
    userFleetMap = new Map();
    computerFleetMap = new Map();
    userBattleMap = new Map();
    computerBattleMap = new Map();
  }


  @Test
  public void getUserInputNumOfBattleShips() throws UnsupportedEncodingException {
    String sampleUserInput = "1";
    InputStream mockInputStream = new ByteArrayInputStream(sampleUserInput.getBytes("UTF-8"));
    Assert.assertEquals(1,debugView.getUserInputNumOfBattleShips(mockInputStream));
  }

  @Test
  public void getUserInputNumOfBattleShips1() throws UnsupportedEncodingException {
    String sampleUserInput1 = "10\n";
    String sampleUserInput2 = "1";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    InputStream mockInputStream2 = new ByteArrayInputStream(sampleUserInput2.getBytes("UTF-8"));
    InputStream mockInputStreamAll =
                new SequenceInputStream(mockInputStream1, mockInputStream2);
    Assert.assertEquals(1,debugView.getUserInputNumOfBattleShips(mockInputStreamAll));
  }

  @Test
  public void getUserInputNumOfBattleShips2() throws UnsupportedEncodingException {
    String sampleUserInput1 = "\n";
    String sampleUserInput2 = "1";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    InputStream mockInputStream2 = new ByteArrayInputStream(sampleUserInput2.getBytes("UTF-8"));
    InputStream mockInputStreamAll =
        new SequenceInputStream(mockInputStream1, mockInputStream2);
    Assert.assertEquals(1,debugView.getUserInputNumOfBattleShips(mockInputStreamAll));
  }

  @Test
  public void getUserInputNumOfBattleShips3() throws UnsupportedEncodingException {
    String sampleUserInput1 = "c\n";
    String sampleUserInput2 = "1";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    InputStream mockInputStream2 = new ByteArrayInputStream(sampleUserInput2.getBytes("UTF-8"));
    InputStream mockInputStreamAll =
        new SequenceInputStream(mockInputStream1, mockInputStream2);
    Assert.assertEquals(1,debugView.getUserInputNumOfBattleShips(mockInputStreamAll));
  }

  @Test
  public void getUserInputNumOfCruisers1() throws UnsupportedEncodingException {
    String sampleUserInput1 = "10\n";
    String sampleUserInput2 = "1";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    InputStream mockInputStream2 = new ByteArrayInputStream(sampleUserInput2.getBytes("UTF-8"));
    InputStream mockInputStreamAll =
        new SequenceInputStream(mockInputStream1, mockInputStream2);
    Assert.assertEquals(1,debugView.getUserInputNumOfCruisers(mockInputStreamAll));
  }

  @Test
  public void getUserInputNumOfCruisers2() throws UnsupportedEncodingException {
    String sampleUserInput1 = "b\n";
    String sampleUserInput2 = "0";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    InputStream mockInputStream2 = new ByteArrayInputStream(sampleUserInput2.getBytes("UTF-8"));
    InputStream mockInputStreamAll =
        new SequenceInputStream(mockInputStream1, mockInputStream2);
    Assert.assertEquals(0,debugView.getUserInputNumOfCruisers(mockInputStreamAll));
  }

  @Test
  public void getUserInputNumOfCruisers3() throws UnsupportedEncodingException {
    String sampleUserInput1 = "\n";
    String sampleUserInput2 = "1";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    InputStream mockInputStream2 = new ByteArrayInputStream(sampleUserInput2.getBytes("UTF-8"));
    InputStream mockInputStreamAll =
        new SequenceInputStream(mockInputStream1, mockInputStream2);
    Assert.assertEquals(1,debugView.getUserInputNumOfCruisers(mockInputStreamAll));
  }

  @Test
  public void getUserInputNumOfCruisers() throws UnsupportedEncodingException {
    String sampleUserInput = "2";
    InputStream mockInputStream = new ByteArrayInputStream(sampleUserInput.getBytes("UTF-8"));
    Assert.assertEquals(2,debugView.getUserInputNumOfCruisers(mockInputStream));
    String sampleUserInput1 = "0";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    Assert.assertEquals(0,debugView.getUserInputNumOfCruisers(mockInputStream1));
  }

  @Test
  public void getUserInputNumOfSubmarine1() throws UnsupportedEncodingException {
    String sampleUserInput1 = "10\n";
    String sampleUserInput2 = "1";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    InputStream mockInputStream2 = new ByteArrayInputStream(sampleUserInput2.getBytes("UTF-8"));
    InputStream mockInputStreamAll =
        new SequenceInputStream(mockInputStream1, mockInputStream2);
    Assert.assertEquals(1,debugView.getUserInputNumOfSubmarine(mockInputStreamAll));
  }

  @Test
  public void getUserInputNumOfSubmarine2() throws UnsupportedEncodingException {
    String sampleUserInput1 = "\n";
    String sampleUserInput2 = "1";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    InputStream mockInputStream2 = new ByteArrayInputStream(sampleUserInput2.getBytes("UTF-8"));
    InputStream mockInputStreamAll =
        new SequenceInputStream(mockInputStream1, mockInputStream2);
    Assert.assertEquals(1,debugView.getUserInputNumOfSubmarine(mockInputStreamAll));
  }

  @Test
  public void getUserInputNumOfSubmarine3() throws UnsupportedEncodingException {
    String sampleUserInput1 = "x\n";
    String sampleUserInput2 = "1";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    InputStream mockInputStream2 = new ByteArrayInputStream(sampleUserInput2.getBytes("UTF-8"));
    InputStream mockInputStreamAll =
        new SequenceInputStream(mockInputStream1, mockInputStream2);
    Assert.assertEquals(1,debugView.getUserInputNumOfSubmarine(mockInputStreamAll));
  }
  @Test
  public void getUserInputNumOfSubmarine() throws UnsupportedEncodingException {
    String sampleUserInput = "3";
    InputStream mockInputStream = new ByteArrayInputStream(sampleUserInput.getBytes("UTF-8"));
    Assert.assertEquals(3, debugView.getUserInputNumOfSubmarine(mockInputStream));
    String sampleUserInput1 = "1";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    Assert.assertEquals(1,debugView.getUserInputNumOfSubmarine(mockInputStream1));

  }

  @Test
  public void getUserInputNumOfDestroyer1() throws UnsupportedEncodingException {
    String sampleUserInput1 = "10\n";
    String sampleUserInput2 = "1";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    InputStream mockInputStream2 = new ByteArrayInputStream(sampleUserInput2.getBytes("UTF-8"));
    InputStream mockInputStreamAll =
        new SequenceInputStream(mockInputStream1, mockInputStream2);
    Assert.assertEquals(1,debugView.getUserInputNumOfDestroyer(mockInputStreamAll));
  }
  @Test
  public void getUserInputNumOfDestroyer2() throws UnsupportedEncodingException {
    String sampleUserInput1 = "\n";
    String sampleUserInput2 = "1";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    InputStream mockInputStream2 = new ByteArrayInputStream(sampleUserInput2.getBytes("UTF-8"));
    InputStream mockInputStreamAll =
        new SequenceInputStream(mockInputStream1, mockInputStream2);
    Assert.assertEquals(1,debugView.getUserInputNumOfDestroyer(mockInputStreamAll));
  }

  @Test
  public void getUserInputNumOfDestroyer3() throws UnsupportedEncodingException {
    String sampleUserInput1 = "B\n";
    String sampleUserInput2 = "1";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    InputStream mockInputStream2 = new ByteArrayInputStream(sampleUserInput2.getBytes("UTF-8"));
    InputStream mockInputStreamAll =
        new SequenceInputStream(mockInputStream1, mockInputStream2);
    Assert.assertEquals(1,debugView.getUserInputNumOfDestroyer(mockInputStreamAll));
  }

  @Test
  public void getUserInputNumOfDestroyer() throws UnsupportedEncodingException {
    String sampleUserInput = "4";
    InputStream mockInputStream = new ByteArrayInputStream(sampleUserInput.getBytes("UTF-8"));
    Assert.assertEquals(4,debugView.getUserInputNumOfDestroyer(mockInputStream));
    String sampleUserInput1 = "0";
    InputStream mockInputStream1 = new ByteArrayInputStream(sampleUserInput1.getBytes("UTF-8"));
    Assert.assertEquals(0,debugView.getUserInputNumOfDestroyer(mockInputStream1));
  }

  @Test
  public void update() {
    debugView.update(userFleetMap, computerFleetMap, userBattleMap,
        computerBattleMap);
  }


  @Test
  public void equals() {
    Assert.assertTrue(this.debugView.equals(sameRefDebugView));
    Assert.assertTrue(this.debugView.equals(sameStateDebugView));
    Assert.assertTrue(this.sameStateDebugView.equals(debugView));
    Assert.assertEquals(this.debugView.equals(sameStateDebugView)
        &&sameStateDebugView.equals(yetAnotherDebugView), yetAnotherDebugView.equals(debugView));
    Assert.assertFalse(this.debugView.equals(diffDebugView));
    Assert.assertFalse(this.debugView.equals(nullDebugView));
  }

  @Test
  public void testHashCode() {
    Assert.assertTrue(this.debugView.hashCode() == this.sameRefDebugView.hashCode());
    Assert.assertTrue(this.debugView.hashCode()== this.sameStateDebugView.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals(this.debugView.toString(), "DebugView{} ConsolePrinter{view=null}");
  }
}

