package edu.neu.ccs.cs5004.assignment9.emailautomation;

/**
 * Represents email type.
 */
public class Email extends AbstractMessageType {

  /**
   * Create a postfix of file name according to the message type.
   *
   * @return "_email.txt" if email is chosen, or "_letter.txt" if letter is chosen.
   */
  @Override
  protected String fileNameFactory() {
    return "_email.txt";
  }
}
