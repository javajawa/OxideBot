package oxidebot.handlers;

import oxidebot.RequestBot;

/**
 *
 * @author Benedict
 */
public abstract class RequestBotMessageHandler {
  /**
   *
   * @param message 
   * @param sender
   * @param bot 
   * @return Pair containing pre-emption flag, and a reply message
   * Pre-emption flag: If this function interprets the message, and
   * handles it in such a way that it should not be processed by other handles,
   * this should be raised to true. Otherwise, it should be false. If this
   * handle does not
   */
  public boolean processMessage(String message, String sender, RequestBot bot)
  {
    return false;
  }
}
