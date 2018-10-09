package edu.neu.ccs.cs5004.assignment9.emailautomation;

/**
 * Represents a message generator.
 */
public interface IMessageGenerator {


  /**
   * Create a new message generator.
   *
   * @return a new message generator.
   */
  static IMessageGenerator createMessageGenerator() {
    return new MessageGenerator();
  }

  /**
   * Generate messages for multiple members according to the given template and message type.
   *
   * @param members      represents the members need to generate messages for.
   * @param templateFile represents the template.
   * @param outputDir    represents the directory to store the output messages.
   * @param messageType  represents the type of message need to generate.
   */
  void generateMessages(ITheaterMembers members, String templateFile,
                        String outputDir, IMessageType messageType);

}
