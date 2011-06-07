package oxidebot.handlers;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oxidebot.RequestBot;
import oxidebot.Request;

/**
 *
 * @author Benedict
 */
public class RemoveRequestHandler extends RequestBotMessageHandler {
protected final Matcher matcher = Pattern.compile
    (
      "del (.+?)",
      Pattern.CASE_INSENSITIVE |
      Pattern.MULTILINE |
      Pattern.UNICODE_CASE
    ).matcher("");

  public RemoveRequestHandler()
  {
  }

  @Override
  public boolean processMessage(String message, String sender, RequestBot bot)
  {
    matcher.reset(message);
    if (matcher.matches())
    {
      String request = matcher.group(1);
      List<Request> requestList = bot.getRequestList();

      for (Request r : requestList) {
        if (r.getRequest().equalsIgnoreCase(request)) {
          requestList.remove(r);
          bot.sendMessages(sender, request + " removed.");
        }
      }
    }

    return super.processMessage(message, sender, bot);
  }

}
