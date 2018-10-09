package edu.neu.ccs.cs5004.assignment9.emailautomation;

import java.util.List;

/**
 * Represents the type of message need to be generated.
 */
public interface IMessageType {

  /**
   * Write given messages to the given output directory.
   *
   * @param messages  represents the given messages.
   * @param outputDir represents the output directory.
   */
  void writeFiles(List<String> messages, String outputDir);
}
