package edu.neu.ccs.cs5004.assignment9.emailautomation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a parser for CSV file.
 */
public class CsvFileParser {

  /**
   * Get the header in the CSV file as a string array.
   * @param inputFile represents the given CSV file.
   * @return the header.
   */
  public String[] getHeaders(String inputFile) {
    try (BufferedReader inputReader = new BufferedReader(
        new InputStreamReader(
            new FileInputStream(inputFile), "UTF-8"))) {
      return parseLine(inputReader.readLine());
    } catch (IOException ioe) {
      throw new InvalidArgumentException("Couldn't open given csv file." + ioe.getMessage());
    }
  }

  /**
   * Get the values in the CSV file as a list of string array.
   * @param inputFile represents the given CSV file.
   * @return the values.
   */
  public List<String[]> getValues(String inputFile) {
    List<String[]> values = new ArrayList<>();
    try (BufferedReader inputReader = new BufferedReader(
        new InputStreamReader(
            new FileInputStream(inputFile), "UTF-8"))) {
      String line;
      inputReader.readLine();  // skip header.
      while ((line = inputReader.readLine()) != null) {
        values.add(parseLine(line));
      }
      return values;
    } catch (IOException ioe) {
      throw new InvalidArgumentException("Couldn't open given csv file." + ioe.getMessage());
    }
  }

  /**
   * Parse a line where most column information is enclosed in double quotes and seperated by comas.
   *
   * @param line represents a line from a CSV file.
   * @return a string array containing the information from the given line.
   */
  private static String[] parseLine(String line) {
    line = line.replaceAll("^\"|\"$", "");
    return line.split("\"\\s*,\\s*\"|\"\\s*,|,\\s*\"");

  }
}
