package edu.neu.ccs.cs5004.assignment9.emailautomation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a map of option data. key: key of the option data; value: the whole option data.
 */
public class OptionsSet {

  private Map<String, OptionsData> optionMap;
  private StringBuffer errorMessage;

  /**
   * To create an instance of an optionsSet.
   */
  public OptionsSet() {
    this.optionMap = new HashMap<>();
    this.errorMessage = new StringBuffer();
  }


  /**
   * Getter for the property error message.
   *
   * @return a string buffer represents the error message of this options set.
   */
  StringBuffer getErrorMessage() {
    return this.errorMessage;
  }

  /**
   * Getter for the property of the options map.
   *
   * @return a map represents a map of option data
   */

  Map<String, OptionsData> getOptionMap() {
    return optionMap;
  }


  /**
   * To add an option to the option set.
   *
   * @param optionKey the option key of the data to be added.
   * @param hasValue  #true if the data has value, #false otherwise
   * @return the option set with the new data added.
   */
  public OptionsSet addOption(String optionKey, Boolean hasValue) {
    OptionsData optData = new OptionsData(optionKey, hasValue);
    this.optionMap.put(optionKey, optData);
    return this;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    OptionsSet that = (OptionsSet) obj;
    return Objects.equals(getOptionMap(), that.getOptionMap())
        && Objects.equals(getErrorMessage().toString(), that.getErrorMessage().toString());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getOptionMap(), getErrorMessage().toString());
  }

  @Override
  public String toString() {
    return "OptionsSet{" + "optionMap=" + optionMap + ", errorMessage=" + errorMessage + '}';
  }

}

