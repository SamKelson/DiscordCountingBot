package Game;

import java.util.List;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.guild.GenericGuildMessageEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
//DONT USE A GAME LOPP JUST USE CONDITIONS AND CHANGE THE INDEX EACH TIME IT PASSES CORRECTLY
public class Game extends ListenerAdapter {
    private int index;
    private MessageChannel channel;
    private boolean state;

    public Game() {
        this.index = 0;
        state = false;
    }

    public void startGame(MessageChannel channel, int index) {
        this.index = index;
        state = true;
    }

    public void endGame() {
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        
    }

    private void checkMessage(Message msg) {
        // if(msg.getContentRaw().startsWith(Main.getPrefix())){return;}
    }

    private Message getPrevMessage(Message msg) {
        MessageHistory history = MessageHistory.getHistoryBefore(channel, ((GenericGuildMessageEvent) msg).getMessageId()).limit(5).complete();
        List<Message> msgHistory = history.getRetrievedHistory();
        return msgHistory.get(0);
    }

    public int getIndex(){return index;}
    public MessageChannel getChannel(){return channel;}
    public boolean getState(){return state;}
}

/*
public void onGuildMessageReceived(GuildMessageReceivedEvent e){
		int num = 0;
		MessageHistory history = MessageHistory.getHistoryBefore(e.getChannel(), e.getMessageId()).limit(10).complete(); 
        if((!e.getMessage().getContentRaw().equalsIgnoreCase("c%start"))&&(!e.getMember().getUser().isBot())&&e.getChannel().getPositionRaw()==channel&&!e.getMessage().getContentRaw().equalsIgnoreCase("c%stop")){
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
*/