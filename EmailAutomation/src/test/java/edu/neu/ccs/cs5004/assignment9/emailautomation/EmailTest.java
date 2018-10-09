package edu.neu.ccs.cs5004.assignment9.emailautomation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
  private Email email;

  @Before
  public void setUp() throws Exception {
    email = new Email();
  }

  @Test
  public void fileNameFactory() {
    Assert.assertEquals("_email.txt", email.fileNameFactory());
  }
}