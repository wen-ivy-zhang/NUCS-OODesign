package edu.neu.ccs.cs5004.assignment9.emailautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ITheaterMembersTest {

  private ITheaterMembers members;

  @Before
  public void setUp() throws Exception {
    members = ITheaterMembers.createTheaterMembers("csv_parser_test.csv");
  }

  @Test
  public void createTheaterMembers() {
    Assert.assertEquals(new TheaterMembers("csv_parser_test.csv"), members);
  }

  @Test
  public void getMemberList() {

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

    List<Member> memberList = new ArrayList<>();
    Member member1 = new Member(headers, value1);
    Member member2 = new Member(headers, value2);
    memberList.add(member1);
    memberList.add(member2);


    for (int i = 0; i < memberList.size(); i++) {
      Assert.assertEquals(memberList.get(i), members.getMemberList().get(i));
    }
  }
}