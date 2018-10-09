package edu.neu.ccs.cs5004.assignment9.emailautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MessageGeneratorTest {
  private MessageGenerator messageGenerator;
  private MessageGenerator sameRefMessageGenerator;
  private MessageGenerator sameStateMessageGenerator;
  private String headers[];
  private String values[];
  private Member member;
  private TheaterMembers members;

  @Before
  public void setUp() throws Exception {
    messageGenerator = new MessageGenerator();
    sameRefMessageGenerator = messageGenerator;
    sameStateMessageGenerator = new MessageGenerator();

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
  public void generateMessages() {
    String templateFile = "template_test.txt";
    messageGenerator.generateMessages(members, templateFile, "test", new Letter());
  }

  @Test
  public void replaceWithMemberInfo() {

    String template = "Dear [[first name]] [[last name]], you are type [[type]] in year [[year]]";
    String expectMessage = "Dear b, c a, you are type d in year 2018";
    Assert.assertEquals(expectMessage, messageGenerator.replaceWithMemberInfo(member, template));
  }

  @Test
  public void equals() {
    MessageGenerator nullMessageGenerator =  null;
    MessageGenerator yetAnotherMessageGenerator = new MessageGenerator();

    Assert.assertEquals(messageGenerator, sameRefMessageGenerator);
    Assert.assertEquals(messageGenerator, sameStateMessageGenerator);
    Assert.assertEquals(messageGenerator.equals(sameStateMessageGenerator)
        && sameStateMessageGenerator.equals(yetAnotherMessageGenerator),
        yetAnotherMessageGenerator.equals(messageGenerator));
    Assert.assertFalse(messageGenerator.equals(new String("a")));
    Assert.assertFalse(messageGenerator.equals(nullMessageGenerator));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(messageGenerator.equals(sameRefMessageGenerator),
        messageGenerator.hashCode()== sameRefMessageGenerator.hashCode());
    Assert.assertEquals(messageGenerator.equals(sameStateMessageGenerator),
        messageGenerator.hashCode()== sameStateMessageGenerator.hashCode());
    Assert.assertEquals(messageGenerator.equals(new String("a")),
        messageGenerator.hashCode()== new String("a").hashCode());
  }
}