package oxidebot.handlers;

import java.util.Collections;
import oxidebot.RequestBot;
import oxidebot.RequestComparator;
import oxidebot.Request;

/**
 *
 * @author Benedict
 */
public class RequestListHandler extends RequestBotMessageHandler {

  protected static final RequestComparator listSorter = new RequestComparator();

  public RequestListHandler()
  {
  }

  @Override
  public boolean processMessage(String message, String sender, RequestBot bot)
  {
    if (message.equalsIgnoreCase("list")) {
      Collections.sort(bot.getRequestList(), listSorter);
      bot.sendMessage(sender, "-- Request List --");
      
      for (Request request : bot.getRequestList())
      {
        bot.sendMessage(sender, request.toString());
      }
    }

    return super.processMessage(message, sender, bot);
  }

}
