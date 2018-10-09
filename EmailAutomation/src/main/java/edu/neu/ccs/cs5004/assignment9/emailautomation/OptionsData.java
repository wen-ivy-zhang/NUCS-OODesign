package edu.neu.ccs.cs5004.assignment9.emailautomation;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;


/**
 * This class holds all the data for an option. This includes the prefix, the key, the separator
 * (for value options), the multiplicity, and all the other settings describing the option.
 */
public class OptionsData {

  private String key;
  private List<String> values;
  private Boolean hasValue;
  private Pattern pattern;
  private int count;


  /**
   * To create an instance of an optionsData
   *
   * @param key      a string represents the key of the options data
   * @param hasValue a boolean represents whether the option data includes value or not.
   */
  public OptionsData(String key, Boolean hasValue) {
    this.key = key;
    this.hasValue = hasValue;
    this.count = 0;
    this.values = new ArrayList<>();
    this.pattern = Pattern.compile(Options.PREFIX + key);
  }


  /**
   * Getter for the property pattern.
   *
   * @return the pattern of this options data.
   */
  Pattern getPattern() {
    return this.pattern;
  }


  /**
   * Getter for the property values.
   *
   * @return a list of values of the option data.
   */
  List<String> getValues() {
    return this.values;
  }

  /**
   * To add a value to the options data.
   *
   * @param value the value to be added to the options data.
   */
  void addValue(String value) {
    if (this.hasValue) {
      this.values.add(value);
    }
  }


  /**
   * Getter for the property has value.
   *
   * @return #true if the options data has value, #false otherwise.
   */
  Boolean getHasValue() {
    return hasValue;
  }

  /**
   * Getter for the property count.
   *
   * @return the number of presents of this options data.
   */
  int getCount() {
    return count;
  }

  /**
   * To increase the number of counts.
   */
  void increaseCount() {
    this.count = this.count + 1;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    OptionsData that = (OptionsData) obj;
    return getCount() == that.getCount() && Objects.equals(key, that.key)
        && Objects.equals(getValues(), that.getValues())
        && Objects.equals(getHasValue(), that.getHasValue())
        && Objects.equals(getPattern().toString(), that.getPattern().toString());
  }


  @Override
  public int hashCode() {

    return Objects.hash(key, getValues(), getHasValue(), getCount());
  }

  @Override
  public String toString() {
    return "OptionsData{" + "key='" + key + '\'' + ", values=" + values + ", hasValue="
        + hasValue + ", pattern=" + pattern + ", count=" + count + '}';
  }
}
