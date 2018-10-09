package edu.neu.ccs.cs5004.assignment9.emailautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OptionParcerTest {
OptionParcer optionParcer;
OptionsSet optionsSet1;
OptionsSet optionsSet2;


  @Before
  public void setUp() throws Exception {

    optionParcer = new OptionParcer();
    optionsSet1 = new OptionsSet();
    optionsSet1.addOption("email",false);
    optionsSet1.addOption("email-template",true);
    optionsSet1.addOption("output-dir",true);
    optionsSet1.addOption("csv-file",true);
    optionsSet1.getOptionMap().get("email-template").getValues().add("emailtemplate.txt");
    optionsSet1.getOptionMap().get("output-dir").getValues().add("emails");
    optionsSet1.getOptionMap().get("csv-file").getValues().add("theatercompanymembers.csv");
    optionsSet1.getOptionMap().get("email").increaseCount();
    //optionsSet1.getOptionMap().get("email").increaseCount();
    optionsSet1.getOptionMap().get("email-template").increaseCount();
    optionsSet1.getOptionMap().get("output-dir").increaseCount();
    optionsSet1.getOptionMap().get("csv-file").increaseCount();

    optionsSet2 = new OptionsSet();
    optionsSet2.addOption("letter",false);
    optionsSet2.addOption("letter-template",true);
    optionsSet2.addOption("output-dir",true);
    optionsSet2.addOption("csv-file",true);
    optionsSet2.getOptionMap().get("letter-template").getValues().add("lettertemplate.txt");
    optionsSet2.getOptionMap().get("output-dir").getValues().add("letters");
    optionsSet2.getOptionMap().get("csv-file").getValues().add("theatercompanymembers.csv");
    optionsSet2.getOptionMap().get("letter").increaseCount();
    //optionsSet2.getOptionMap().get("letter").increaseCount();
    optionsSet2.getOptionMap().get("letter-template").increaseCount();
    optionsSet2.getOptionMap().get("output-dir").increaseCount();
    optionsSet2.getOptionMap().get("csv-file").increaseCount();
  }

  @Test
  public void parceOption() {
    String[]args1= {"--email", "--email-template","emailtemplate.txt","--output-dir","emails","--csv-file","theatercompanymembers.csv"};

    Assert.assertEquals(optionParcer.parseOption(args1),optionsSet1);
    String[]args2 = {"--letter","--letter-template","lettertemplate.txt","--output-dir","letters","--csv-file","theatercompanymembers.csv"};
    Assert.assertEquals(optionParcer.parseOption(args2),optionsSet2);

    String[]args3= {"--email-template","emailtemplate.txt","--output-dir","emails","--csv-file","theatercompanymembers.csv"};
    optionParcer.parseOption(args3);
    String[]args4= {"--email", "emailtemplate.txt","--output-dir","emails","--csv-file","theatercompanymembers.csv"};
    optionParcer.parseOption(args4);
    String[]args5= {"--letter-template","lettertemplate.txt","--output-dir","letters","--csv-file","theatercompanymembers.csv"};
    optionParcer.parseOption(args5);
    String[]args6= {"letter","--letter-template","lettertemplate.txt","--csv-file","theatercompanymembers.csv"};
    optionParcer.parseOption(args6);




  }


  @Test
  public void printInfo() {
    optionParcer.printInfo();
  }
}