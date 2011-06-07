package oxidebot;

import java.io.IOException;
import org.jibble.pircbot.IrcException;
import oxidebot.handlers.OpAuthHandler;
import oxidebot.handlers.QuitMessageHandler;
import oxidebot.handlers.HelpHandler;
import oxidebot.handlers.RemoveRequestHandler;
import oxidebot.handlers.RequestHandler;
import oxidebot.handlers.RequestListHandler;

/**
 *
 * @author Benedict
 */
public class Main
{

  /**
   * @param args the command line arguments
   * @throws IOException
   * @throws IrcException
   * @throws ClassNotFoundException 
   */
  public static void main(String[] args) throws IOException, IrcException, ClassNotFoundException
  { 
    RequestBot bot = new RequestBot("ElizaBot");

    bot.addHandler(new OpAuthHandler("secret"));
    bot.addHandler(new HelpHandler());
    bot.addHandler(new RequestListHandler());
    bot.addHandler(new RequestHandler());

    bot.addOpHandler(new QuitMessageHandler());
    bot.addOpHandler(new RemoveRequestHandler());

    bot.connect("irc.ox.ac.uk", 6667);
    bot.joinChannel("#oxide");
  }

   Main()
  {
  }

}
