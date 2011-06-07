package oxidebot.handlers;

import oxidebot.RequestBot;

/**
 *
 * @author Benedict
 */
public class QuitMessageHandler extends RequestBotMessageHandler {

  @Override
  public boolean processMessage(String message, java.lang.String sender, RequestBot bot)
  {
    if (message.equalsIgnoreCase("quit")) {

      bot.quitServer("Fine! Be That Way!");
      bot.disconnect();
      bot.dispose();

      return true;
    }

    return super.processMessage(message, null, bot);
  }

}
