package Game;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;

import Commands.Rules;
import Commands.Start;
import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Main extends ListenerAdapter {
    public static void main(String args[]) throws Exception{

    	JDA jda = new JDABuilder(AccountType.BOT).setToken("NTM4OTA2NjI3ODg2MTUzNzcw.DzJ5wA.CkohbwMUbESZa2yYfdqWsmr-yCQ").buildBlocking();
        
    	EventWaiter waiter = new EventWaiter();
    	
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setOwnerId("538906627886153770");
        builder.setPrefix("c%");
        builder.setHelpWord("help");
        Start s = new Start(waiter);
        builder.addCommand(s);
        builder.addCommand(new Rules());
        
        CommandClient client = builder.build();
        
        jda.addEventListener(client);
        jda.addEventListener(waiter);
        synchronized(waiter) {
            waiter.wait();
          }
        Game g = new Game(s.getArgs());
        jda.addEventListener(g); 
        synchronized(g) {
			g.wait();
			jda.shutdown();
			Main.main(args);
          }
    }
}