package oxidebot.handlers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oxidebot.RequestBot;

/**
 *
 * @author Benedict
 */
public class OpAuthHandler extends RequestBotMessageHandler {
  private final Matcher matcher =
    Pattern.compile(
      "^opin (.+)$",
      Pattern.CASE_INSENSITIVE |
      Pattern.MULTILINE |
      Pattern.UNICODE_CASE
    ).matcher("");

  private final String password;

  public OpAuthHandler(String password)
  {
    this.password = password;
  }

  @Override
  public boolean processMessage(String message, String sender, RequestBot bot)
  {
    matcher.reset(message);
    if (matcher.matches()) {
      if (password.equals(matcher.group(1))) {
        if (bot.isOp(sender)) {
          bot.sendMessages(sender, "You are already logged in as an op.");
        } else {
          bot.addOp(sender);
          bot.sendMessages(sender, "You are now logged in as a operator");
        }
        return true;
      } else {
        bot.sendMessages(sender, "Invalid Password.");
        return true;
      }
    }

    return super.processMessage(message, sender, bot);
  }
  

}
