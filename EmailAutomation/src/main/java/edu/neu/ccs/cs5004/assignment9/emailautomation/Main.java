package edu.neu.ccs.cs5004.assignment9.emailautomation;

public class Main {

  /**
   * Represents the main method of the application.
   *
   * @param args represent the command line arguments.
   */
  public static void main(String[] args) {
    Main app = new Main();
    OptionParcer parcer = new OptionParcer();
    OptionsSet parserResult = parcer.parseOption(args);
    app.run(parserResult);
  }


  /**
   * start running the application.
   *
   * @param parserResult an options set which is the result of the parse function.
   */

  public void run(OptionsSet parserResult) {

    String templateFile = null;
    IMessageType outputType = new Email();
    if (parserResult == null) {
      return;
    }
    if (parserResult.getOptionMap().containsKey(OptionParcer.EMAIL)) {
      templateFile = parserResult.getOptionMap().get(OptionParcer.EMAIL_TEMPLATE)
          .getValues().get(OptionParcer.INDEX);

    } else if (parserResult.getOptionMap().containsKey(OptionParcer.LETTER)) {
      templateFile = parserResult.getOptionMap().get(OptionParcer.LETTER_TEMPLATE)
          .getValues().get(OptionParcer.INDEX);
      outputType = new Letter();
    }
    String inputFile = parserResult.getOptionMap().get(OptionParcer.INPUT)
        .getValues().get(OptionParcer.INDEX);
    String outputDir = parserResult.getOptionMap().get(OptionParcer.OUTPUT_DIR)
        .getValues().get(OptionParcer.INDEX);


    ITheaterMembers members = ITheaterMembers.createTheaterMembers(inputFile);
    IMessageGenerator messageGenerator = IMessageGenerator.createMessageGenerator();

    messageGenerator.generateMessages(members, templateFile, outputDir, outputType);
  }
}
