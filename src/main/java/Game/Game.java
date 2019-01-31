package Game;


import java.util.List;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Game extends ListenerAdapter  {
	private int i;
	private int channel;
	public Game(int j,int c) {
		i = j+1;
		channel = c;
	}
	public void onGuildMessageReceived(GuildMessageReceivedEvent e){
		MessageHistory history = MessageHistory.getHistoryBefore(e.getChannel(), e.getMessageId()).limit(10).complete(); 
        if(!e.getMember().getUser().isBot()&&e.getChannel().getPositionRaw()==channel){
        	String[] args = e.getMessage().getContentRaw().split(" ");
        	int num = Integer.parseInt(args[0]);
        	List<Message> name = history.getRetrievedHistory();
        	if(num!=i||!Character.isDigit(args[0].charAt(0))||name.get(0).getMember().getEffectiveName().equalsIgnoreCase(e.getMember().getEffectiveName())) {
        		e.getChannel().sendMessage("Restart with c%start (whereToStart) because: "+e.getMember().getEffectiveName()+" FUCKED IT UP:sob:").queue();
        		synchronized(this) {
        			this.notifyAll();
                  }
        	}
        	else if(args[0].equalsIgnoreCase("%start")) {
        		e.getChannel().sendMessage("Cant start another game when there is a game going on");
        	}
        	else {
        		i++;
        	}
        }
    }
}
