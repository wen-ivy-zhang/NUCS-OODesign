package edu.neu.ccs.cs5004.battleship.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PositionTest {
  private Position posn;
  private Position sameRefPosn;
  private Position sameStatePosn;
  private Position diffRowPosn;
  private Position diffColumnPosn;

  @Before
  public void setUp() throws Exception {
    posn = new Position("A 1");
    sameRefPosn = posn;
    sameStatePosn = new Position("A 1");
    diffRowPosn = new Position("A 2");
    diffColumnPosn = new Position("B 1");
  }

  @Test (expected = InvalidArgumentException.class)
  public void testConstructor1() {
    Position invalidPosn2 = new Position("1");
  }

  @Test (expected = InvalidArgumentException.class)
  public void testConstructor2() {
    Position invalidPosn1 = new Position("A 1 1");
  }

  @Test (expected = InvalidArgumentException.class)
  public void testConstructor3() {
    Position invalidPosn3 = new Position("AB 1");
  }

  @Test (expected = InvalidArgumentException.class)
  public void testConstructor4() {
    Position invalidPosn4 = new Position("K 1");
  }

  @Test (expected = InvalidArgumentException.class)
  public void testConstructor5() {
    Position invalidPosn5 = new Position("A C");
  }

  @Test (expected = InvalidArgumentException.class)
  public void testConstructor6() {
    Position invalidPosn6 = new Position("A 12");
  }

  @Test
  public void getRow() {
    Assert.assertTrue(posn.getRow() == 1);
  }

  @Test
  public void getColumn() {
    Assert.assertTrue(posn.getColumn() == 'A');
  }

  @Test
  public void getRowIndex() {
    Assert.assertTrue(posn.getRowIndex() == 0);
  }

  @Test
  public void getColumnIndex() {
    Assert.assertTrue(posn.getColumnIndex() == 0);
  }

  @Test
  public void equals() {
    Position yetAnotherPosn = new Position("A 1");
    Position nullPosn= null;

    // reflexivity
    Assert.assertTrue(posn.equals(posn));
    // trivial condition both reference same object
    Assert.assertTrue(posn.equals(sameRefPosn));
    // symmetry
    Assert.assertEquals(posn.equals(sameStatePosn),
        sameStatePosn.equals(posn));
    // transitivity
    Assert.assertEquals(posn.equals(sameStatePosn)
            && sameStatePosn.equals(yetAnotherPosn),
        yetAnotherPosn.equals(posn));
    // objects have different state
    Assert.assertFalse(posn.equals(diffRowPosn));
    Assert.assertFalse(posn.equals(diffColumnPosn));
    // cruiser is not null
    Assert.assertFalse(posn.equals(nullPosn));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(posn.equals(sameRefPosn),
        posn.hashCode() == sameRefPosn.hashCode());
    Assert.assertEquals(posn.equals(sameStatePosn),
        posn.hashCode() == sameStatePosn.hashCode());
    Assert.assertEquals(posn.equals(diffColumnPosn),
        posn.hashCode() == diffColumnPosn.hashCode());
  }

  @Test
  public void testToString() {
    String tempRes = "Position{"
        + "row=" + posn.getRow()
        + ", column=" + posn.getColumn()
        + '}';
    Assert.assertEquals(tempRes, posn.toString());
  }
}