package Game;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;

import Commands.Info;
import Commands.Rules;
import Commands.Start;
import Commands.Stop;
import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Main extends ListenerAdapter {
    public static void main(String args[]) throws Exception{
    	JDA jda = new JDABuilder(AccountType.BOT).setToken("NTQxMDkyODE2Njk3Mjk0ODQ4.XNCjLQ.lmqU8QE2xNtsp68Z9XHm7PZ8ZW4").buildBlocking();
        
        EventWaiter waiter = new EventWaiter();

        Game game = new Game();

        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setOwnerId("538906627886153770");
        builder.setPrefix(getPrefix());
        builder.setHelpWord("help");
        Start s = new Start(game);
        builder.addCommand(s);
        builder.addCommand(new Rules());
        builder.addCommand(new Info());
        Stop stop = new Stop();
        builder.addCommand(stop);
        
        CommandClient client = builder.build();
        
        jda.addEventListener(client); 
        
    }
	public static String getPrefix() {
		return "z%";
    }
}
