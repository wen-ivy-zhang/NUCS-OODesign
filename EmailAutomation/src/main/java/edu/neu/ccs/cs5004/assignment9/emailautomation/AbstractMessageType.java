package edu.neu.ccs.cs5004.assignment9.emailautomation;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Represents an abstract message type.
 */
public abstract class AbstractMessageType implements IMessageType {

  /**
   * Create a postfix of file name according to the message type.
   *
   * @return "_email.txt" if email is chosen, or "_letter.txt" if letter is chosen.
   */
  protected abstract String fileNameFactory();

  /**
   * Create a new directory according to the given output directory.
   * Create new file names based on message type and write given messages to these files.
   * eg: for email type, file name will be something like "1_email.txt".
   * for letter type, file name will be something like "1_letter.txt".
   *
   * @param messages  represent the given messages.
   * @param outputDir represents the given output directory.
   */
  @Override
  public void writeFiles(List<String> messages, String outputDir) {
    try {
      Files.createDirectories(Paths.get(outputDir));
      for (int i = 0; i < messages.size(); i++) {
        String outputFile = Paths.get(outputDir, (i + 1) + fileNameFactory()).toString();
        writeStringToFile(messages.get(i), outputFile);
      }
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }

  /**
   * Write the given content to the given file.
   *
   * @param content    represents the given content as a string.
   * @param outputFile represents the given output file name as a string.
   */
  private void writeStringToFile(String content, String outputFile) {
    try (BufferedWriter fileWriter = new BufferedWriter(
        new OutputStreamWriter(
            new FileOutputStream(outputFile), "UTF-8"))) {
      fileWriter.write(content);
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }

}
