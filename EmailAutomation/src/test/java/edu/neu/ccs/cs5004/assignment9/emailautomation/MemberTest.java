package edu.neu.ccs.cs5004.assignment9.emailautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MemberTest {

  private Member member;
  private Member sameRefMember;
  private Member sameStateMember;
  private Member diffMember;
  private Member nullMember;
  private Map<String, String> memberInfo;
  private String headers[];
  private String values1[];
  private String value2[];


  @Before
  public void setUp() throws Exception {
    headers = new String[4];
    headers[0] = "last name";
    headers[1] = "first name";
    headers[2] = "year";
    headers[3] = "type";

    values1 = new String[4];
    values1[0] = "a";
    values1[1] = "b, c";
    values1[2] = "2018";
    values1[3] = "d";

    value2 = new String[4];
    value2[0] = "e";
    value2[1] = "f, g";
    value2[2] = "2000";
    value2[3] = "h";

    member = new Member(headers, values1);
    sameRefMember = member;
    sameStateMember = new Member(headers, values1);
    diffMember = new Member(headers, value2);
    nullMember = null;

    memberInfo = new HashMap<>();
    memberInfo.put("last name", "a");
    memberInfo.put("first name", "b, c");
    memberInfo.put("year", "2018");
    memberInfo.put("type", "d");
  }

  @Test
  public void getMemberInfo() {
    Assert.assertEquals(memberInfo, member.getMemberInfo());
  }

  @Test
  public void equals() {
    Member yetAnotherMember = new Member(headers, values1);
    Assert.assertEquals(member, sameRefMember);
    Assert.assertEquals(member, sameStateMember);
    Assert.assertEquals(member.equals(sameStateMember)
        && sameStateMember.equals(yetAnotherMember), yetAnotherMember.equals(member));
    Assert.assertFalse(member.equals(diffMember));
    Assert.assertFalse(member.equals(nullMember));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(member.equals(sameRefMember),
        member.hashCode()== sameRefMember.hashCode());
    Assert.assertEquals(member.equals(sameStateMember),
        member.hashCode()== sameStateMember.hashCode());
    Assert.assertEquals(member.equals(diffMember),
        member.hashCode()== diffMember.hashCode());
  }

  @Test
  public void testToString() {
    String tempRes = "Member{"
        + "memberInfo=" + member.getMemberInfo()
        + '}';
    Assert.assertEquals(tempRes, member.toString());
  }
}