package edu.neu.ccs.cs5004.assignment9.emailautomation;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Represents a parser for template file.
 */
public class TemplateFileParser {

  /**
   * Convert the content in the template file to a string.
   *
   * @param inputFile represents the template file.
   * @return the content as a string.
   */
  public static String getStringFromFile(String inputFile) {
    try {
      byte[] encoded = Files.readAllBytes(Paths.get(inputFile));
      return new String(encoded, "UTF-8");
    } catch (IOException ioe) {
      throw new InvalidArgumentException("Couldn't read the given input file " + inputFile);
    }
  }
}
