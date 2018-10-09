package edu.neu.ccs.cs5004.assignment9.emailautomation;

/**
 * This class is to parce the input arguments.
 */
public class OptionParcer {
  static final Integer INDEX = 0;
  static final String EMAIL = "email";
  static final String LETTER = "letter";
  static final String EMAIL_TEMPLATE = "email-template";
  static final String LETTER_TEMPLATE = "letter-template";
  static final String OUTPUT_DIR = "output-dir";
  static final String INPUT = "csv-file";
  static final Boolean NO_VALUE = false;
  static final Boolean HAS_VALUE = true;
  static final String EMAIL_SET = "email-set";
  static final String LETTER_SET = "letter-set";
  static final String MESSAGE_1 = "Usage:";
  static final String MESSAGE_2 = "      --email:          only generate email messages";
  static final String MESSAGE_3 = "      --email-template <file>   "
      + "accepts a filename that holds the email template.";
  static final String MESSAGE_4 = "        Required if --email is used";
  static final String MESSAGE_5 = "      --letter          only generate letters";
  static final String MESSAGE_6 = "      --letter-template <file>   "
      + "accepts a filename that holds the email template.";
  static final String MESSAGE_7 = "        Required if --letter is used";
  static final String MESSAGE_8 = "      --output-dir <path>  "
      + " accepts the name of a folder, all output is placed in this folder";
  static final String MESSAGE_9 = "      --csv-file <path> "
      + "accepts the name of the csv file to process";
  static final String MESSAGE_10 = "Examples:";
  static final String MESSAGE_11 = "     --email --email-template email-template.txt "
      + "--output-dir emails --csv-file customer.csv";
  static final String MESSAGE_12 = "     --letter --letter-template letter-template.txt"
      + " --output-dir letters --csv-file customer.csv";


  /**
   * This function is to parse the input arguments, update the options map.
   * and return a string "email-set" or "template-set".
   *
   * @param args input arguments.
   * @return a string represents the parse result.
   */
  public OptionsSet parseOption(String[] args) {
    if (args.length == 0) {
      System.out.println("Error: no input found, please check the Usage.");
      printInfo();
      return null;
    }
    Options opt = new Options(args);
    opt.addSet(EMAIL_SET).addOption(EMAIL, NO_VALUE)
        .addOption(EMAIL_TEMPLATE, HAS_VALUE)
        .addOption(OUTPUT_DIR, HAS_VALUE)
        .addOption(INPUT, HAS_VALUE);

    opt.addSet(LETTER_SET).addOption(LETTER, NO_VALUE)
        .addOption(LETTER_TEMPLATE, HAS_VALUE)
        .addOption(OUTPUT_DIR, HAS_VALUE)
        .addOption(INPUT, HAS_VALUE);

    if (opt.check(EMAIL_SET)) {
      return opt.getSet(EMAIL_SET);
    } else if (opt.check(LETTER_SET)) {
      return opt.getSet(LETTER_SET);
    } else {
      // System.out.println(opt.getErrorMessage());
      StringBuffer emailMessage = opt.getSet(EMAIL_SET).getErrorMessage();
      StringBuffer letterMessage = opt.getSet(LETTER_SET).getErrorMessage();
      if (emailMessage.toString().length() != 0) {
        System.out.println(emailMessage);
        printInfo();
        return null;
      }
      if (letterMessage.toString().length() != 0) {
        System.out.println(letterMessage);
        printInfo();
        return null;
      }


      System.out.println("Error: No --email flag or --letter flag found. Please check the Usage.");
      printInfo();

      return null;
    }
  }


  /**
   * To printout the Usage information for the user.
   */
  public static void printInfo() {
    System.out.println("\n");
    System.out.println(MESSAGE_1);
    System.out.println("\n");
    System.out.println(MESSAGE_2);
    System.out.println(MESSAGE_3);
    System.out.println(MESSAGE_4);
    System.out.println("\n");
    System.out.println(MESSAGE_5);
    System.out.println(MESSAGE_6);
    System.out.println(MESSAGE_7);
    System.out.println("\n");
    System.out.println(MESSAGE_8);
    System.out.println("\n");
    System.out.println(MESSAGE_9);
    System.out.println("\n");
    System.out.println(MESSAGE_10);
    System.out.println("\n");
    System.out.println(MESSAGE_11);
    System.out.println(MESSAGE_12);

  }


}
