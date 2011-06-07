package oxidebot;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Benedict
 */
public class RequestBotTest {

  public RequestBotTest() {
  }

  @BeforeClass
  public static void setUpClass() throws Exception
  {
  }

  @AfterClass
  public static void tearDownClass() throws Exception
  {
  }

  @Test
  public void testParser()
  {
    RequestBot bot = new RequestBot();
/*
    String res = bot.msgTest("javajawa", null, null, "Hello");
    assertNull(res);

    res = bot.msgTest("javajawa", null, null, "requests:add Coldplay");
    assertEquals("Coldplay added (id:1)", res);

    res = bot.msgTest("javajawa", null, null, "requests:add Coldplay");
    assertEquals("Request Failed: You have already requested this", res);

    res = bot.msgTest("eliza", null, null, "requests:add coldplay");
    assertEquals("Coldplay up-voted", res);

    res = bot.msgTest("eliza", null, null, "requests:add Test 2");
    assertEquals("Test 2 added (id:2)", res);

    res = bot.msgTest("eliza", null, null, "requests:up 3");
    assertEquals("No request found with id 3", res);
    
    res = bot.msgTest("javajawa", null, null, "requests:up 2");
    assertEquals("Test 2 up-voted", res);

    res = bot.msgTest("eliza", null, null, "requests:up 1");
    assertEquals("Request Failed: You have already requested this", res);

    res = bot.msgTest("person 3", null, null, "requests:up 2");

    res = bot.msgTest("eliza", null, null, "requests:list");
    */
  }

}