package edu.neu.ccs.cs5004.assignment9.emailautomation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a theater member.
 */
public class Member {

  private Map<String, String> memberInfo;

  /**
   * Create a new member.
   *
   * @param keys   the headers in the member info file.
   * @param values member's information in the corresponding row in the member info file.
   */
  public Member(String[] keys, String[] values) {
    this.memberInfo = new HashMap<>();
    for (int i = 0; i < keys.length; i++) {
      memberInfo.put(keys[i], values[i]);
    }
  }

  /**
   * Getter for property member info.
   *
   * @return value for proerty member info.
   */
  public Map<String, String> getMemberInfo() {
    return memberInfo;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Member member = (Member) obj;
    return Objects.equals(getMemberInfo(), member.getMemberInfo());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getMemberInfo());
  }

  @Override
  public String toString() {
    return "Member{"
        + "memberInfo=" + memberInfo
        + '}';
  }
}
