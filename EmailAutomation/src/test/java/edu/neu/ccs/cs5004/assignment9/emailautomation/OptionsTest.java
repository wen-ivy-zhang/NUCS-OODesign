package edu.neu.ccs.cs5004.assignment9.emailautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OptionsTest {
  Options options1;
  Options options2;
  Options options3;
  Options options4;
  Options options5;
  Options options6;
  Options options7;
  Options options8;
  Options options9;
  Options options10;
  Options options11;
  Options options12;
  Options options13;
  Options options14;
  Options options15;

  Options sameRefOptions;
  Options sameStateOptions;
  Options yetAnotherOptions;
  Options diffOptions;
  Options nullOptions;

  @Before
  public void setUp() throws Exception {
    String[]args1= { "--email-template","emailtemplate.txt","--email","--output-dir","emails","--csv-file","theatercompanymemebers.csv"};
    options1 = new Options(args1);
    options1.addSet(OptionParcer.EMAIL_SET).addOption(OptionParcer.EMAIL,OptionParcer.NO_VALUE).
        addOption(OptionParcer.EMAIL_TEMPLATE,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);
    options1.addSet(OptionParcer.LETTER_SET).addOption(OptionParcer.LETTER,OptionParcer.NO_VALUE)
        .addOption(OptionParcer.LETTER_TEMPLATE,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);

    String[]args2 = {"--letter","--letter-template","lettertemplate.txt","--output-dir","letters","--csv-file","theatercompanymemebers.csv"};
    options2 = new Options(args1);
    sameRefOptions = options2;
    sameStateOptions = new Options(args1);
    yetAnotherOptions = new Options(args1);
    diffOptions = new Options(args2);
    nullOptions = null;


    options3 = new Options(args2);
    options3.addSet(OptionParcer.EMAIL_SET).addOption(OptionParcer.EMAIL,OptionParcer.NO_VALUE).
        addOption(OptionParcer.EMAIL_TEMPLATE,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);
    options3.addSet(OptionParcer.LETTER_SET).addOption(OptionParcer.LETTER,OptionParcer.NO_VALUE)
        .addOption(OptionParcer.LETTER_TEMPLATE,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);

    String[]args3 = {"--letter","--output-dir","letters","--csv-file","theater.csv"};
    options4 = new Options(args3);
    options4.addSet(OptionParcer.EMAIL_SET).addOption(OptionParcer.EMAIL,OptionParcer.NO_VALUE).
        addOption(OptionParcer.EMAIL_TEMPLATE,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);
    options4.addSet(OptionParcer.LETTER_SET).addOption(OptionParcer.LETTER,OptionParcer.NO_VALUE)
        .addOption(OptionParcer.LETTER_TEMPLATE,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);

    String[]args4 = {"--email","--output-dir","emails","--csv-file","theater.csv"};
    options5 = new Options(args4);
    options5.addSet(OptionParcer.EMAIL_SET).addOption(OptionParcer.EMAIL,OptionParcer.NO_VALUE).
        addOption(OptionParcer.EMAIL_TEMPLATE,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);
    options5.addSet(OptionParcer.LETTER_SET).addOption(OptionParcer.LETTER,OptionParcer.NO_VALUE)
        .addOption(OptionParcer.LETTER_TEMPLATE,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);

    String[]args5 = {"--email","--email-template","emailtempalte.txt","--csv-file","theater.csv"};
    options6 = new Options(args5);
    options6.addSet(OptionParcer.EMAIL_SET).addOption(OptionParcer.EMAIL,OptionParcer.NO_VALUE).
        addOption(OptionParcer.EMAIL_TEMPLATE,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);
    options6.addSet(OptionParcer.LETTER_SET).addOption(OptionParcer.LETTER,OptionParcer.NO_VALUE)
        .addOption(OptionParcer.LETTER_TEMPLATE,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);

    String[]args6 = {"--email","--email-template","emailtempalte.txt","--output-dir","--csv-file","theater.csv"};
    options7 = new Options(args6);
    options7.addSet(OptionParcer.EMAIL_SET).addOption(OptionParcer.EMAIL,OptionParcer.NO_VALUE).
        addOption(OptionParcer.EMAIL_TEMPLATE,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);
    options7.addSet(OptionParcer.LETTER_SET).addOption(OptionParcer.LETTER,OptionParcer.NO_VALUE)
        .addOption(OptionParcer.LETTER_TEMPLATE,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);

    String[]args7 = {"--email","--email-template","--output-dir","emails","--csv-file","theater.csv"};
    options8 = new Options(args7);
    options8.addSet(OptionParcer.EMAIL_SET).addOption(OptionParcer.EMAIL,OptionParcer.NO_VALUE).
        addOption(OptionParcer.EMAIL_TEMPLATE,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);
    options8.addSet(OptionParcer.LETTER_SET).addOption(OptionParcer.LETTER,OptionParcer.NO_VALUE)
        .addOption(OptionParcer.LETTER_TEMPLATE,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);

    String[]args8 = {"--email","--email-template","--output-dir","emails","theater.csv"};
    options9 = new Options(args8);
    options9.addSet(OptionParcer.EMAIL_SET).addOption(OptionParcer.EMAIL,OptionParcer.NO_VALUE).
        addOption(OptionParcer.EMAIL_TEMPLATE,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);
    options9.addSet(OptionParcer.LETTER_SET).addOption(OptionParcer.LETTER,OptionParcer.NO_VALUE)
        .addOption(OptionParcer.LETTER_TEMPLATE,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);

    String[]args9 = {"--email","--email-template","emailtemplate.txt","--output-dir","emails","--csv-file","theater.exe"};
    options10 = new Options(args9);
    options10.addSet(OptionParcer.EMAIL_SET).addOption(OptionParcer.EMAIL,OptionParcer.NO_VALUE).
        addOption(OptionParcer.EMAIL_TEMPLATE,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);
    options10.addSet(OptionParcer.LETTER_SET).addOption(OptionParcer.LETTER,OptionParcer.NO_VALUE)
        .addOption(OptionParcer.LETTER_TEMPLATE,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);

    String[]args10 = {"--email","--email-template","abc.ttt","--output-dir","emails","--csv-file","theater.csv"};

    options11 = new Options(args10);
//
    options11.addSet(OptionParcer.EMAIL_SET).addOption(OptionParcer.EMAIL,OptionParcer.NO_VALUE).
        addOption(OptionParcer.EMAIL_TEMPLATE,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);
    options11.addSet(OptionParcer.LETTER_SET).addOption(OptionParcer.LETTER,OptionParcer.NO_VALUE)
        .addOption(OptionParcer.LETTER_TEMPLATE,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);

    String[]args11 = {"--letter-template","lettertemplate.txt","--output-dir","letters","--csv-file","theatercompanymemebers.csv"};
    options12 = new Options(args11);
    options12.addSet(OptionParcer.EMAIL_SET).addOption(OptionParcer.EMAIL,OptionParcer.NO_VALUE).
        addOption(OptionParcer.EMAIL_TEMPLATE,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);
    options12.addSet(OptionParcer.LETTER_SET).addOption(OptionParcer.LETTER,OptionParcer.NO_VALUE)
        .addOption(OptionParcer.LETTER_TEMPLATE,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);

    String[]args12 = {"--letter","lettertemplate.txt","--output-dir","letters","--csv-file","theatercompanymemebers.csv"};
    options13 = new Options(args12);
    options13.addSet(OptionParcer.EMAIL_SET).addOption(OptionParcer.EMAIL,OptionParcer.NO_VALUE).
        addOption(OptionParcer.EMAIL_TEMPLATE,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);
    options13.addSet(OptionParcer.LETTER_SET).addOption(OptionParcer.LETTER,OptionParcer.NO_VALUE)
        .addOption(OptionParcer.LETTER_TEMPLATE,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);

    String[]args13 = {"--letter","--letter-template","lettertemplate.abc","--output-dir","letters","--csv-file","theatercompanymemebers.csv"};
    options14 = new Options(args13);
    options14.addSet(OptionParcer.EMAIL_SET).addOption(OptionParcer.EMAIL,OptionParcer.NO_VALUE).
        addOption(OptionParcer.EMAIL_TEMPLATE,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);
    options14.addSet(OptionParcer.LETTER_SET).addOption(OptionParcer.LETTER,OptionParcer.NO_VALUE)
        .addOption(OptionParcer.LETTER_TEMPLATE,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);

    String[]args14 = {"--email-template","emailtemplate.txt","--output-dir","emails","--csv-file","theatercompanymemebers.csv"};
    options15 = new Options(args13);
    options15.addSet(OptionParcer.EMAIL_SET).addOption(OptionParcer.EMAIL,OptionParcer.NO_VALUE).
        addOption(OptionParcer.EMAIL_TEMPLATE,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE).
        addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);
    options15.addSet(OptionParcer.LETTER_SET).addOption(OptionParcer.LETTER,OptionParcer.NO_VALUE)
        .addOption(OptionParcer.LETTER_TEMPLATE,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.OUTPUT_DIR,OptionParcer.HAS_VALUE)
        .addOption(OptionParcer.INPUT,OptionParcer.HAS_VALUE);


  }

  @Test
  public void testConstructor(){
    options11.updateOptionMap(options11.getSet(OptionParcer.EMAIL_SET).getOptionMap());
    System.out.println(options11.getSet(OptionParcer.EMAIL_SET).getOptionMap());

  }

  @Test
  public void testConstructor1(){
    String[] str = new String[0];
    Options options15 = new Options(str);
  }
  @Test
  public void addSet() {
    OptionsSet temp = new OptionsSet();
    Assert.assertEquals(options2.addSet(OptionParcer.EMAIL_SET),temp);
  }

  @Test
  public void getSet() {
    OptionsSet temp = new OptionsSet();
    Assert.assertEquals(options2.addSet(OptionParcer.EMAIL_SET),temp);
    options2.addSet(OptionParcer.EMAIL_SET);
    Assert.assertEquals(options2.getSet(OptionParcer.EMAIL_SET),temp);


  }

  @Test
  public void check() {
    Assert.assertTrue(options1.check(OptionParcer.EMAIL_SET));
    Assert.assertTrue(options3.check(OptionParcer.LETTER_SET));
    Assert.assertFalse(options4.check(OptionParcer.LETTER_SET));
    System.out.println("opt4"+options4.getSet(OptionParcer.LETTER_SET).getErrorMessage());
    Assert.assertFalse(options5.check(OptionParcer.EMAIL_SET));
    System.out.println("opt5"+options5.getSet(OptionParcer.EMAIL_SET).getErrorMessage());
    Assert.assertFalse(options6.check(OptionParcer.EMAIL_SET));
    System.out.println("opt6"+options6.getSet(OptionParcer.EMAIL_SET).getErrorMessage());
    Assert.assertFalse(options7.check(OptionParcer.EMAIL_SET));
    System.out.println("opt7"+options7.getSet(OptionParcer.EMAIL_SET).getErrorMessage());
    Assert.assertFalse(options8.check(OptionParcer.EMAIL_SET));
    System.out.println("opt8"+options8.getSet(OptionParcer.EMAIL_SET).getErrorMessage());
    Assert.assertFalse(options9.check(OptionParcer.EMAIL_SET));
    System.out.println("opt9:"+options9.getSet(OptionParcer.EMAIL_SET).getErrorMessage());
    Assert.assertFalse(options10.check(OptionParcer.EMAIL_SET));
    System.out.println("opt10:"+ options10.getSet(OptionParcer.EMAIL_SET).getErrorMessage());
    Assert.assertFalse(options11.check(OptionParcer.EMAIL_SET));
    System.out.println("opt11:"+options11.getSet(OptionParcer.EMAIL_SET).getErrorMessage());
    Assert.assertFalse(options12.check(OptionParcer.EMAIL_SET));
    System.out.println("opt12:"+ options12.getSet(OptionParcer.EMAIL_SET).getErrorMessage());
    Assert.assertFalse(options13.check(OptionParcer.LETTER_SET));
    System.out.println("opt13:"+ options13.getSet(OptionParcer.LETTER_SET).getErrorMessage());
    Assert.assertFalse(options14.check(OptionParcer.LETTER_SET));
    System.out.println("opt14:"+ options14.getSet(OptionParcer.LETTER_SET).getErrorMessage());
    Assert.assertFalse(options15.check(OptionParcer.LETTER_SET));
    System.out.println("opt14:"+ options15.getSet(OptionParcer.LETTER_SET).getErrorMessage());




  }



  @Test
  public void equals() {
    Assert.assertTrue(this.options2.equals(sameRefOptions));
    Assert.assertTrue(this.options2.equals(sameStateOptions));
    Assert.assertEquals(this.options2.equals(sameStateOptions)&&sameStateOptions.equals(yetAnotherOptions),yetAnotherOptions.equals(sameStateOptions));
    Assert.assertFalse(this.options1.equals(options2));
    Assert.assertFalse(this.options2.equals(diffOptions));
    Assert.assertFalse(this.options2.equals(nullOptions));
    Assert.assertFalse(this.options2.equals(new Integer(5)));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(this.options2.equals(sameRefOptions),this.options2.hashCode()==sameRefOptions.hashCode());
    Assert.assertEquals(this.options2.equals(sameStateOptions),this.options2.hashCode()==sameStateOptions.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals(this.options2.toString(),"Options{optionsSetMap={}, arguments=[--email-template, emailtemplate.txt, --email, --output-dir, emails, --csv-file, theatercompanymemebers.csv]}");
  }
}