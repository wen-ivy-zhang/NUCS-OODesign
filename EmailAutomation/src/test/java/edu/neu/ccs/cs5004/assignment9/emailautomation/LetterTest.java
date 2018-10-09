package edu.neu.ccs.cs5004.assignment9.emailautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LetterTest {

  private Letter letter;

  @Before
  public void setUp() throws Exception {
    letter = new Letter();
  }

  @Test
  public void fileNameFactory() {
    Assert.assertEquals("_letter.txt", letter.fileNameFactory());
  }
}