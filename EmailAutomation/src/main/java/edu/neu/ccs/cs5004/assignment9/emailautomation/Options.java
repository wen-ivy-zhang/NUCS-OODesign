package edu.neu.ccs.cs5004.assignment9.emailautomation;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * To represent options of input arguments.
 */
public class Options {

  static final String PREFIX = "--";
  static final Integer INDEX = 0;
  static final Integer HASH_DEFAULT = 31;
  private Map<String, OptionsSet> optionsSetMap;
  private String[] arguments;


  /**
   * To create an instance of options.
   *
   * @param args an array of string representing input arguments.
   */
  public Options(String[] args) {

    this.optionsSetMap = new HashMap<>();
    this.arguments = new String[args.length];
    System.arraycopy(args, 0, arguments, 0, args.length);
  }



  /**
   * To add a set of option data to the map of option sets.
   *
   * @param key the name of the option data set to be added.
   * @return the option data set to be added to the map.
   *         since latter we need to add options data to the options set
   */
  OptionsSet addSet(String key) {
    OptionsSet optSet = new OptionsSet();
    this.optionsSetMap.put(key, optSet);
    return optSet;
  }

  /**
   * To get the value of the option set map.
   *
   * @param key a string representing the key of the option set
   * @return an option set which is the value of the given key.
   */
  OptionsSet getSet(String key) {
    return this.optionsSetMap.get(key);
  }

  /**
   * To check whether the input arguments can meet the requirements of  a valid given options set.
   * for example: To check whether input arguments can provide enough valid information to
   * form a valid email set.
   *
   * @param optionSetName (key) the name of the options set.
   * @return #true if the arguments meet the requirements of  given set of option data
   *         #false otherwise.
   */
  Boolean check(String optionSetName) {
    Map<String, OptionsData> optionMap = this.optionsSetMap.get(optionSetName).getOptionMap();
    updateOptionMap(optionMap);
    return validateMap(optionSetName, optionMap);
  }


  /**
   * To update the optionMap based on input arguments.
   * for example: add values to certain flag, and add counts if the flag presents in arguments.
   *
   * @param optionMap the original option map
   */
  void updateOptionMap(Map<String, OptionsData> optionMap) {
    int index = INDEX;

    while (index < arguments.length) {
      String key = arguments[index];
      // check if the element in input arguments exists in the specific optionSet.
      for (OptionsData optionsData : optionMap.values()) {
        Matcher regexMatcher = optionsData.getPattern().matcher(key);
        if (key.length() == optionsData.getPattern().toString().length() && regexMatcher.find()) {
          if (optionsData.getHasValue()) {
            // If this optionData has value, then the next argument should be the value we need
            if (index + 1 == arguments.length) {
              //this.errorMessage.append(NO_VALUE);
              // The last argument, then no value after it, should return false
              break;
            } else {
              String next = arguments[index + 1];
              if (next.startsWith(PREFIX)) {
                // next argument start with prefix, then it should be a key, not a value
                //this.errorMessage.append(NO_VALUE);
                break;
              } else {
                optionsData.increaseCount();
                optionsData.addValue(next);
                index++;
              }
            }
          } else {
            optionsData.increaseCount();
          }
        }
      }

      index++;
    }

  }


  /**
   * To check if the updated option map is valid or not.
   *
   * @param optionSetName the key of the option set map
   * @param optionMap     the updated options data which is also the value of the option set map
   * @return #true if the updated options map is valid, #false otherwise.
   */
  private Boolean validateMap(String optionSetName, Map<String, OptionsData> optionMap) {
    StringBuffer errorMessage = this.optionsSetMap.get(optionSetName).getErrorMessage();

    if (!validateOutputDir(errorMessage, optionMap)) {
      return false;
    }
    if (!validateInputFile(errorMessage, optionMap)) {
      return false;
    }
    if (optionSetName.equals(OptionParcer.EMAIL_SET)) {
      return validateEmailAndEmailTemplate(errorMessage, optionMap);
    }
    if (optionSetName.equals(OptionParcer.LETTER_SET)) {

      return validateLetterAndLetterTemplate(errorMessage, optionMap);
    }

    return false;
  }


  /**
   * To check it the updated option map meets all requirements for --email and --email-template.
   * if not, generate corresponding error messages.
   *
   * @param errorMessage a string buffer to store the error message in given options set.
   * @param optionMap    the updated optionMap to be checked.
   * @return #true if the updated option map meets all requirements
   *         for --email and --email-template flag.
   *         #false otherwise.
   */
  private Boolean validateEmailAndEmailTemplate(StringBuffer errorMessage,
                                                Map<String, OptionsData> optionMap) {

    OptionsData emailTemplate = optionMap.get(OptionParcer.EMAIL_TEMPLATE);
    if (optionMap.get(OptionParcer.EMAIL).getCount() == 0) {
      return false;
    } else if (optionMap.get(OptionParcer.EMAIL).getCount() > 0) {
      if (emailTemplate.getCount() == 0) {
        errorMessage.append("Error: --email flag provided but no --email-template was given.");
        return false;
      }
      if (!validateTxt(errorMessage, emailTemplate.getValues().get(0))) {
        errorMessage.append("Error: not valid .txt file.");
        return false;
      }
      return true;

    }
    return false;
  }

  /**
   * To check if the updated optionMap meets all requirements for --letter and --letter-template.
   * if not, generate corresponding error message.
   *
   * @param errorMessage a string buffer to store the error message in given options set.
   * @param optionMap    the updated optionMap to be checked.
   * @return #true if the updated option map meets all requirements
   *         for --letter and --letter-template flag.
   *         #false otherwise.
   */
  private Boolean validateLetterAndLetterTemplate(StringBuffer errorMessage,
                                                  Map<String, OptionsData> optionMap) {

    OptionsData letterTemplate = optionMap.get(OptionParcer.LETTER_TEMPLATE);
    if (optionMap.get(OptionParcer.LETTER).getCount() == 0) {
      return false;
    } else if (optionMap.get(OptionParcer.LETTER).getCount() > 0) {
      if (letterTemplate.getCount() == 0) {
        errorMessage.append("Error: --letter flag provided, but no --letter-template was given.");
        return false;
      }
      if (!validateTxt(errorMessage, letterTemplate.getValues().get(0))) {
        errorMessage.append("Error: not valid .txt file.");
        return false;
      }
      return true;

    }
    return false;

  }

  /**
   * To check if the updated optionMap meets all requirements for output directory.
   * if not, generate corresponding error message.
   *
   * @param errorMessage a string buffer to store the error message in given options set.
   * @param optionMap    the updated optionMap to be checked.
   * @return #true if the updated option map meets all requirements
   *         for output directory
   *         #false otherwise.
   */

  private Boolean validateOutputDir(StringBuffer errorMessage,
                                    Map<String, OptionsData> optionMap) {
    if (optionMap.get(OptionParcer.OUTPUT_DIR).getCount() == 0) {
      errorMessage.append("Error: No output directory flag or no output path defined. "
          + "Please check the Usage.");
      return false;
    }
    return true;
  }

  /**
   * To check if the updated optionMap meets all requirements for input files.
   * if not, generate corresponding error message.
   *
   * @param errorMessage a string buffer to store the error message in given options set.
   * @param optionMap    the updated optionMap to be checked.
   * @return #true if the updated option map meets all requirements
   *         for input map
   *         #false otherwise.
   */
  private Boolean validateInputFile(StringBuffer errorMessage,
                                    Map<String, OptionsData> optionMap) {
    if (optionMap.get(OptionParcer.INPUT).getCount() == 0) {
      errorMessage.append("Error: No input flag (--csv-file) found or no input information found."
          + "Please check the Usage.");
      return false;
    }
    if (!validateCsv(errorMessage,
        optionMap.get(OptionParcer.INPUT).getValues().get(0))) {
      errorMessage.append("Error: Not valid .csv file. Please check the Usage.");
      return false;
    }
    return true;
  }


  /**
   * To check if a string meets the pattern of ".csv".
   * if not, generate the corresponding error message.
   *
   * @param errorMessage a string buffer to store the error message in given options set.
   * @param output       a string represents the information to be checked.
   * @return #true if the string is a valid name for .csv file, #false otherwise.
   */
  private Boolean validateCsv(StringBuffer errorMessage,
                              String output) {
    String expect = ".*\\.csv$";
    if (!Pattern.matches(expect, output)) {
      errorMessage.append("Error: expect .csv file as input value, but not found."
          + " Please check the Usage.");
    }
    return Pattern.matches(expect, output);
  }

  /**
   * To check if a string meets the pattern of ".txt".
   * if not, generate the corresponding error message.
   *
   * @param errorMessage a string buffer to store the error message in given options set.
   * @param output       a string represents the information to be checked.
   * @return #true if the string is a valid name for .txt file, #false otherwise.
   */

  private Boolean validateTxt(StringBuffer errorMessage, String output) {
    String expect = ".*\\.txt$";
    if (!Pattern.matches(expect, output)) {
      errorMessage.append("Error: expect .txt file as input value, but not found."
          + " Please check the Usage.");
    }
    return Pattern.matches(expect, output);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Options options = (Options) obj;
    return Objects.equals(optionsSetMap, options.optionsSetMap)
        && Arrays.equals(arguments, options.arguments);
  }

  @Override
  public int hashCode() {

    int result = Objects.hash(optionsSetMap);
    result = HASH_DEFAULT * result + Arrays.hashCode(arguments);
    return result;
  }

  @Override
  public String toString() {
    return "Options{" + "optionsSetMap=" + optionsSetMap + ", arguments="
        + Arrays.toString(arguments) + '}';
  }

}
