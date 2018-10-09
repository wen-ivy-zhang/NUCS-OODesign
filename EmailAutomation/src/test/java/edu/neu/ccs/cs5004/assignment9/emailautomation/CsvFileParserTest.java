package edu.neu.ccs.cs5004.assignment9.emailautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CsvFileParserTest {
  private CsvFileParser csvParser;
  private String headers[];
  private List<String[]> values;
  private String inputFile;

  @Before
  public void setUp() throws Exception {
    inputFile = "csv_parser_test.csv";

    csvParser = new CsvFileParser();

    headers = new String[4];
    headers[0] = "last name";
    headers[1] = "first name";
    headers[2] = "year";
    headers[3] = "type";

    String value1[] = new String[4];
    value1[0] = "a";
    value1[1] = "b, c";
    value1[2] = "2018";
    value1[3] = "d";

    String value2[] = new String[4];
    value2[0] = "e";
    value2[1] = "f, g";
    value2[2] = "2000";
    value2[3] = "h";

    values = new ArrayList<>();
    values.add(value1);
    values.add(value2);

  }

  @Test
  public void getHeaders() {
    for (int i = 0; i < csvParser.getHeaders(inputFile).length; i++) {
      Assert.assertEquals(headers[i], csvParser.getHeaders(inputFile)[i]);
    }
  }

  @Test(expected = InvalidArgumentException.class)
  public void getHeaders1() {
    csvParser.getHeaders("Non_exist.csv");
  }

  @Test
  public void getValues() {
    for (int i = 0; i < values.size(); i++) {
      for (int j = 0; j < 4; j++) {
        Assert.assertEquals(values.get(i)[j], csvParser.getValues(inputFile).get(i)[j]);
      }
    }
  }

  @Test(expected = InvalidArgumentException.class)
  public void getValues1() {
    csvParser.getValues("Non_exist.csv");
  }

  @Test(expected = InvalidArgumentException.class)
  public void getValues2() {
    File file = new File("a_directory.csv");
    file.mkdir();
    csvParser.getValues("file");
  }

}