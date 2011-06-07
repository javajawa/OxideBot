package oxidebot.handlers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oxidebot.RequestBot;

/**
 *
 * @author Benedict
 */
public final class HelpHandler extends RequestBotMessageHandler {

  private final Matcher matcher = Pattern.compile
    (
      "^h.lp$",
      Pattern.CASE_INSENSITIVE |
      Pattern.MULTILINE |
      Pattern.UNICODE_CASE
    ).matcher("");

  public HelpHandler()
  {
    // Nothing to see here. Move along, citizen!
  }

  @Override
  public boolean processMessage(String message, java.lang.String sender, RequestBot bot)
  {
    matcher.reset(message);

    if (matcher.matches()){
      bot.sendMessages(
        sender,
        bot.getName() + " - Request Bot\n"
        + "Commands may be sent to the bot, or in the channel prefixed with '" + bot.getNick() + ":' \n"
        + "add <name> - Vote for <name>\n"
        + "list - List the current request list\n"
        + "help - Dispaly this help\n"
        + "opin <password> - Log in as a bot manager\n"
        + "e.g. " + bot.getNick() + ": add Coldplay"
      );
    }

    return super.processMessage(message, null, bot);
  }

}
