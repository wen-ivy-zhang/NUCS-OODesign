package edu.neu.ccs.cs5004.assignment9.emailautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TemplateFileParserTest {

  private TemplateFileParser fileParser;

  @Before
  public void setUp() throws Exception {
    fileParser = new TemplateFileParser();
  }

  @Test
  public void getStringFromFile() {
    String inputFile = "template_test.txt";
    String expectedContent = "test template file.";
    Assert.assertEquals(expectedContent, TemplateFileParser.getStringFromFile(inputFile));
  }

  @Test(expected = InvalidArgumentException.class)
  public void getStringFromFile1() {
    TemplateFileParser.getStringFromFile("abc.txt");
  }
}