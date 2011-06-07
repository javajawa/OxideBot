package oxidebot;

import oxidebot.handlers.RequestBotMessageHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.jibble.pircbot.Colors;
import org.jibble.pircbot.PircBot;

/**
 *
 * @author Benedict
 */
public class RequestBot extends PircBot
{

  protected static RequestComparator listSorter = new RequestComparator();

  protected List<Request> requestList;
  protected List<RequestBotMessageHandler> handlers;
  protected List<RequestBotMessageHandler> opHandlers;
  protected Set<String> ops;
  protected int lastId;

  public RequestBot()
  {
    super();

    this.setName("ElizaBot");
    requestList = new ArrayList<Request>(20);
    
    handlers = new LinkedList<RequestBotMessageHandler>();
    opHandlers = new LinkedList<RequestBotMessageHandler>();
    ops = new HashSet<String>();

    lastId = 1;
    this.setMessageDelay(50);
  }

  public boolean isOp(String sender) {
    return ops.contains(sender);
  }

  protected boolean messageToUs(String message) {
    return message.startsWith(this.getNick() + ':');
  }

  public void sendMessages(String sender, String message) {
    if (message != null) {
      String[] reps = message.split("[\\r\\n]+");
      for (String line : reps)
      {
        this.sendMessage(sender, line);
      }
    }
  }

  public void sendNotices(String message) {
    if (message != null) {
      String[] reps = message.split("[\\r\\n]+");
      for (String line : reps)
      {
        for (String target : this.getChannels()) {
          this.sendMessage(target, line);
        }
      }
    }
  }

  @Override protected void onMessage(String channel, String sender, String login, String hostname, String message)
  {
    String clearText = Colors.removeFormattingAndColors(message);
    if (messageToUs(clearText)) {
      clearText = clearText.substring(this.getNick().length() + 2);
      this.processMessage(clearText, sender);
      if (isOp(sender)) this.processOpMessage(clearText, sender);
    }
    super.onMessage(channel, sender, login, hostname, message);
  }

  @Override
  protected void onPrivateMessage(String sender, String login, String hostname, String message)
  {
    String clearText = Colors.removeFormattingAndColors(message);
    this.processMessage(clearText,sender);
    if (isOp(sender)) this.processOpMessage(clearText, sender);
    super.onPrivateMessage(sender, login, hostname, message);
  }

  @Override
  protected void onQuit(String nick, String login, String hostname, String reason)
  {
    if (ops.contains(nick)) ops.remove(nick);
    super.onQuit(nick, login, hostname, reason);
  }

  protected void processMessage(String message, String sender) {
    for (RequestBotMessageHandler handler : handlers)
    {
      if (handler.processMessage(message, sender, this)) break;
    }
  }

  protected void processOpMessage(String message, String sender) {
    for (RequestBotMessageHandler handler : opHandlers)
    {
      if (handler.processMessage(message, sender, this)) break;
    }
  }

  public void addOp(String nick) {
    this.ops.add(nick);
  }

  public void addHandler(RequestBotMessageHandler newHandler) {
    this.handlers.add(newHandler);
  }

  public void addOpHandler(RequestBotMessageHandler newHandler) {
    this.opHandlers.add(newHandler);
  }

  @SuppressWarnings("ReturnOfCollectionOrArrayField")
  public List<Request> getRequestList() {
    return this.requestList;
  }

  @SuppressWarnings("ValueOfIncrementOrDecrementUsed")
  public int getNextId() {
    return this.lastId ++;
  }
}
