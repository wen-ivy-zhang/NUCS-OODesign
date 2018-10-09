package edu.neu.ccs.cs5004.assignment9.emailautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TheaterMembersTest {

  private TheaterMembers members;
  private TheaterMembers sameRefMembers;
  private TheaterMembers sameStateMembers;
  private TheaterMembers diffMembers;
  private TheaterMembers nullMembers;
  private List<Member> memberList;

  @Before
  public void setUp() throws Exception {
    members = new TheaterMembers("csv_parser_test.csv");
    sameRefMembers = members;
    sameStateMembers = new TheaterMembers("csv_parser_test.csv");
    diffMembers = new TheaterMembers("csv_parser_test_2.csv");
    nullMembers = null;

    String headers[] = new String[4];
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

    memberList = new ArrayList<>();
    Member member1 = new Member(headers, value1);
    Member member2 = new Member(headers, value2);
    memberList.add(member1);
    memberList.add(member2);

  }

  @Test
  public void getMemberList() {
    for (int i = 0; i < memberList.size(); i++) {
      Assert.assertEquals(memberList.get(i), members.getMemberList().get(i));
    }
  }

  @Test
  public void equals() {
    TheaterMembers yetAnotherMembers = new TheaterMembers("csv_parser_test_2.csv");
    Assert.assertEquals(members, sameRefMembers);
    Assert.assertEquals(members, sameStateMembers);
    Assert.assertEquals(members.equals(sameStateMembers)
        && sameStateMembers.equals(yetAnotherMembers), yetAnotherMembers.equals(members));
    Assert.assertFalse(members.equals(diffMembers));
    Assert.assertFalse(members.equals(nullMembers));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(members.equals(sameRefMembers),
        members.hashCode()== sameRefMembers.hashCode());
    Assert.assertEquals(members.equals(sameStateMembers),
        members.hashCode()== sameStateMembers.hashCode());
    Assert.assertEquals(members.equals(diffMembers),
        members.hashCode()== diffMembers.hashCode());
  }

  @Test
  public void testToString() {
    String tempRes = "TheaterMembers{" +
        "memberList=" + members.getMemberList() +
        '}';

    Assert.assertEquals(tempRes, members.toString());
  }
}