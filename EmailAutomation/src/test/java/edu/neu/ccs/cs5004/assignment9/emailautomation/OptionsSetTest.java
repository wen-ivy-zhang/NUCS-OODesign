package edu.neu.ccs.cs5004.assignment9.emailautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class OptionsSetTest {
    OptionsSet optionsSet1;
    OptionsSet optionsSet2;
    OptionsSet sameRefOptionsSet;
    OptionsSet sameStateOptionsSet;
    OptionsSet yetAnotherOptionsSet;
    Object diffOptionsSet;
    OptionsSet nullOptionsSet;

  @Before
  public void setUp() throws Exception {
    optionsSet1 = new OptionsSet();
    optionsSet2 = new OptionsSet();
    optionsSet2.addOption("email-template",true);
    sameRefOptionsSet = optionsSet1;
    sameStateOptionsSet = new OptionsSet();
    yetAnotherOptionsSet = new OptionsSet();
    diffOptionsSet =  new Integer(1);
    nullOptionsSet = null;
  }

  @Test
  public void getErrorMessage() {
    optionsSet1.getErrorMessage().append("ERROR: invalid input");
    Assert.assertEquals(this.optionsSet1.getErrorMessage().toString(),"ERROR: invalid input");
  }

  @Test
  public void getOptionMap() {
    optionsSet1.addOption("email",false);
    OptionsData optionsData1 = new OptionsData("email",false);
    Map<String,OptionsData> res = new HashMap<>();
    res.put("email",optionsData1);
    Assert.assertEquals(optionsSet1.getOptionMap(),res);


  }

  @Test
  public void addOption() {
    //optionsSet2.addOption("email-template",true);
    OptionsData optionsData2 = new OptionsData("email-template",true);
    Map<String,OptionsData> res = new HashMap<>();
    res.put("email-template",optionsData2);
    Assert.assertEquals(optionsSet2.getOptionMap(),res);

  }

  @Test
  public void equals() {
    Assert.assertTrue(this.optionsSet1.equals(sameRefOptionsSet));
    Assert.assertEquals(optionsSet1.getOptionMap(),sameStateOptionsSet.getOptionMap());
    Assert.assertTrue(optionsSet1.equals(sameStateOptionsSet));
    Assert.assertEquals(optionsSet1.equals(sameStateOptionsSet)&&sameStateOptionsSet.equals(yetAnotherOptionsSet),
        yetAnotherOptionsSet.equals(optionsSet1));
    Assert.assertFalse(optionsSet1.equals(optionsSet2));
    Assert.assertFalse(optionsSet1.equals(diffOptionsSet));
    Assert.assertFalse(optionsSet1.equals(nullOptionsSet));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(optionsSet1.equals(sameRefOptionsSet),optionsSet1.hashCode()==sameRefOptionsSet.hashCode());
    Assert.assertEquals(optionsSet1.equals(sameStateOptionsSet),optionsSet1.hashCode()==sameStateOptionsSet.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals(optionsSet1.toString(),"OptionsSet{optionMap={}, errorMessage=}");
  }
}