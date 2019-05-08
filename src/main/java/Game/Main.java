package Game;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import Commands.Info;
import Commands.Rules;
import Commands.Start;
import Commands.Stop;
import net.dv8tion.jda.core.*;
public class Main {
    public static void main(String args[]) throws Exception{
    	JDA jda = new JDABuilder(AccountType.BOT).setToken(args[0]).buildBlocking();

        Game game = new Game();

        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setOwnerId("538906627886153770");
        builder.setPrefix(getPrefix());
        builder.setHelpWord("help");
        Start s = new Start(game);
        builder.addCommand(s);
        builder.addCommand(new Rules());
        builder.addCommand(new Info());
        Stop stop = new Stop(game);
        builder.addCommand(stop);
        
        CommandClient client = builder.build();
        
        jda.addEventListener(client); 
        jda.addEventListener(game); 

        
    }
	public static String getPrefix() {
		return "c%";
    }
}
