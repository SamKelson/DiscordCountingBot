package Game;


import java.util.List;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public final class Game extends ListenerAdapter    {
	private int i;
	private int channel;
	public Game(int j,int c) {
		i = j+1;
		channel = c;
	}
	public void onGuildMessageReceived(GuildMessageReceivedEvent e){
		int num = 0;
		MessageHistory history = MessageHistory.getHistoryBefore(e.getChannel(), e.getMessageId()).limit(10).complete(); 
        if((!e.getMember().getUser().isBot())&&e.getChannel().getPositionRaw()==channel&&!e.getMessage().getContentRaw().equalsIgnoreCase("c%stop")){
        	String[] args = e.getMessage().getContentRaw().split(" ");
        	try {
        		num = Integer.parseInt(args[0]);
        		List<Message> name = history.getRetrievedHistory();
            	if((num!=i||!Character.isDigit(args[0].charAt(0))||name.get(0).getMember().getEffectiveName().equalsIgnoreCase(e.getMember().getEffectiveName()))) {
            		e.getChannel().sendMessage("Restarting at 0 because: "+e.getMember().getEffectiveName()+" FUCKED IT UP:sob:\n0").queue();
            		i= 1;
            	}
            	else if(args[0].equalsIgnoreCase("%start")) {
            		e.getChannel().sendMessage("Cant start another game when there is a game going on");
            	}
            	else {
            		i++;
            	}
        	}
        	catch(NumberFormatException e1){
        		e.getChannel().sendMessage("Restarting at 0 because: "+e.getMember().getEffectiveName()+" FUCKED IT UP:sob:\n0").queue();
        		i = 1;
        	}
        	
        }
    }

}
