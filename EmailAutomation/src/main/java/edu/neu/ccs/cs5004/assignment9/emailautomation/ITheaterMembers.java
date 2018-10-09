package edu.neu.ccs.cs5004.assignment9.emailautomation;

import java.util.List;

/**
 * Represents the list of members of the theater company.
 */
public interface ITheaterMembers {

  /**
   * Create the theater member list according to the given file.
   *
   * @param memberInfoFile represents the input file containing member info.
   * @return the theater members.
   */
  static ITheaterMembers createTheaterMembers(String memberInfoFile) {
    return new TheaterMembers(memberInfoFile);
  }

  /**
   * Get the member list of the theater company.
   *
   * @return the member list.
   */
  List<Member> getMemberList();
}
