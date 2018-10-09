package edu.neu.ccs.cs5004.assignment9.emailautomation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class AbstractMessageTypeTest {
  private AbstractMessageType messageType;

  @Before
  public void setUp() throws Exception {
    messageType = new Email();
  }

  @Test
  public void writeFiles() {
    List<String> messages = new ArrayList<>();
    messages.add("test message one");
    messages.add("test message two");
    messageType.writeFiles(messages, "test_messages");
  }
}