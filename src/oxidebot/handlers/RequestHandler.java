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
public class RequestHandler extends RequestBotMessageHandler {
  protected final Matcher matcher = Pattern.compile
    (
      "add (.+?)",
      Pattern.CASE_INSENSITIVE |
      Pattern.MULTILINE |
      Pattern.UNICODE_CASE
    ).matcher("");

  public RequestHandler()
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
          if (!r.requestedBy(sender)) {
            bot.sendMessages(sender, "Request Failed: You have already requested this");
          } else {
            bot.sendMessages(sender, r.getRequest() + " up-voted");
          }
        }
      }

      Integer id = bot.getNextId();
      requestList.add(new Request(request, id, sender));
      bot.sendMessages(sender, request + " added (id:" + id + ")");
      bot.sendNotices(request + "added to request list.");
    }

    return super.processMessage(message, sender, bot);
  }

    
}
