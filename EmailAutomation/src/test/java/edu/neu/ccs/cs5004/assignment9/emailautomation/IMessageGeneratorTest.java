package edu.neu.ccs.cs5004.assignment9.emailautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;




public class IMessageGeneratorTest {
  private IMessageGenerator messageGenerator;
  private String headers[];
  private String values[];
  private Member member;
  private TheaterMembers members;

  @Before
  public void setUp() throws Exception {
    messageGenerator = IMessageGenerator.createMessageGenerator();

    headers = new String[4];
    headers[0] = "last name";
    headers[1] = "first name";
    headers[2] = "year";
    headers[3] = "type";

    values = new String[4];
    values[0] = "a";
    values[1] = "b, c";
    values[2] = "2018";
    values[3] = "d";

    member = new Member(headers, values);
    members = new TheaterMembers("csv_parser_test.csv");
  }


  @Test
  public void createMessageGenerator() {
    Assert.assertEquals(new MessageGenerator(), messageGenerator);
  }


  @Test
  public void generateMessages() {
    String templateFile = "template_test.txt";
    messageGenerator.generateMessages(members, templateFile, "test", new Letter());
  }
}