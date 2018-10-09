package edu.neu.ccs.cs5004.assignment9.emailautomation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a message generator.
 */
public class MessageGenerator implements IMessageGenerator {


  /**
   * Generate messages for multiple members according to the given template and message type.
   *
   * @param members      represents the members need to generate messages for.
   * @param templateFile represents the template.
   * @param outputDir    represents the directory to store the output messages.
   * @param messageType  represents the type of message need to generate.
   */
  public void generateMessages(ITheaterMembers members,
                               String templateFile,
                               String outputDir,
                               IMessageType messageType) {

    List<String> messages = new ArrayList<>();
    String template = TemplateFileParser.getStringFromFile(templateFile);
    for (Member member : members.getMemberList()) {
      String content = replaceWithMemberInfo(member, template);
      messages.add(content);
    }
    messageType.writeFiles(messages, outputDir);
  }

  /**
   * Replace a template with given member's information.
   *
   * @param member   represents the given member.
   * @param template represents the given template.
   * @return the specific message generated for the member.
   */
  protected String replaceWithMemberInfo(Member member, String template) {

    Pattern pattern = Pattern.compile("\\[\\[(.*?)\\]\\]");
    Matcher matcher = pattern.matcher(template);
    StringBuilder stringBuilder = new StringBuilder();
    int index = 0;
    while (matcher.find()) {
      stringBuilder.append(template.substring(index, matcher.start()));
      stringBuilder.append(member.getMemberInfo().get(matcher.group(1)));
      index = matcher.end();
    }
    stringBuilder.append(template.substring(index, template.length()));
    return stringBuilder.toString();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return 13;
  }
}
