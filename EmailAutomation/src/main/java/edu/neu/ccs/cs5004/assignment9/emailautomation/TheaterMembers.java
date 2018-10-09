package edu.neu.ccs.cs5004.assignment9.emailautomation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the list of members of the theater company.
 */
public class TheaterMembers implements ITheaterMembers {

  private List<Member> memberList;

  /**
   * Create the list of members according to the given member information file.
   *
   * @param inputFile represents the given member information file.
   */
  TheaterMembers(String inputFile) {
    this.memberList = new ArrayList<>();
    CsvFileParser parser = new CsvFileParser();
    String[] keys = parser.getHeaders(inputFile);
    List<String[]> values = parser.getValues(inputFile);
    for (String[] memberInfo : values) {
      memberList.add(new Member(keys, memberInfo));
    }
  }

  /**
   * Getter for property member list.
   *
   * @return value for property member list.
   */
  public List<Member> getMemberList() {
    return memberList;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    TheaterMembers members = (TheaterMembers) obj;
    return Objects.equals(getMemberList(), members.getMemberList());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getMemberList());
  }

  @Override
  public String toString() {
    return "TheaterMembers{"
        + "memberList=" + memberList
        + '}';
  }
}
