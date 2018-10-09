package edu.neu.ccs.cs5004.assignment9.emailautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class OptionsDataTest {
  OptionsData optionsData1;
  OptionsData optionsData2;
  OptionsData sameRefOptionsData;
  OptionsData sameStateOptionsData;
  OptionsData yetAnotherOptionsData;
  Integer diffOptionsData;
  OptionsData nullOptionsData;

  @Before
  public void setUp() throws Exception {
    optionsData1 = new OptionsData("email", false);
    optionsData2 = new OptionsData("email-template",true);
    sameRefOptionsData = optionsData1;
    sameStateOptionsData = new OptionsData("email",false);
    yetAnotherOptionsData = new OptionsData("email", false);
    diffOptionsData = 10;
    nullOptionsData = null;
  }

  @Test
  public void getValues() {
    Assert.assertTrue(optionsData1.getValues().isEmpty());
    Assert.assertTrue(optionsData2.getValues().isEmpty());

  }

  @Test
  public void getHasValue() {
    Assert.assertTrue(!optionsData1.getHasValue());
    Assert.assertTrue(optionsData2.getHasValue());
  }

  @Test
  public void getCount() {
    Assert.assertEquals(optionsData1.getCount(),0);
    optionsData2.increaseCount();
    Assert.assertEquals(optionsData2.getCount(), 1);
  }

  @Test
  public void increaseCount() {
    optionsData2.increaseCount();
    Assert.assertEquals(optionsData2.getCount(), 1);
  }

  @Test
  public void getPattern() {
    String pattern = Options.PREFIX + OptionParcer.EMAIL;
    Assert.assertEquals(optionsData1.getPattern().toString(),pattern);
  }

  @Test
  public void addValue() {
    optionsData1.addValue("hello");
    Assert.assertEquals(optionsData1,sameRefOptionsData);
    optionsData2.addValue("hello");
    Assert.assertTrue(optionsData2.getHasValue());
    Assert.assertEquals(optionsData2.getValues().get(0),"hello");

  }

  @Test
  public void equals() {
    Assert.assertTrue(optionsData1.equals(sameRefOptionsData));
    Assert.assertEquals(optionsData1.equals(sameStateOptionsData)
        &&sameStateOptionsData.equals(yetAnotherOptionsData),yetAnotherOptionsData.equals(optionsData1));
    Assert.assertFalse(optionsData1.equals(diffOptionsData));
    Assert.assertFalse(optionsData1.equals(nullOptionsData));
    Assert.assertFalse(optionsData1.equals(optionsData2));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(optionsData1.equals(sameRefOptionsData),
        optionsData1.hashCode()==sameRefOptionsData.hashCode());
    Assert.assertEquals(optionsData1.equals(sameStateOptionsData),
        optionsData1.hashCode()==sameStateOptionsData.hashCode());
  }


  @Test
  public void testToString() {
    Assert.assertEquals(optionsData1.toString(),"OptionsData{key='email', values=[], hasValue=false, pattern=--email, count=0}");
  }
}