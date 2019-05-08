package Game;

import java.util.List;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
public class Game extends ListenerAdapter{
    private int index;
    private MessageChannel channel;
    private boolean state;
    private String messageID;

    public Game() {
        this.index = 0;
        state = false;
    }

    public void startGame(MessageChannel channel, int index) {
        this.index = index;
        state = true;
        this.channel=channel;
    }

    public void endGame() {
        state = false;
    }
    
    public void onGuildMessageDelete(GuildMessageDeleteEvent e){
        MessageHistory history = MessageHistory.getHistoryAfter(channel, e.getMessageId()).limit(5).complete();
        List<Message> msgHistory = history.getRetrievedHistory();
        if(e.getChannel().equals(channel)&&getState()&&msgHistory.isEmpty()){
            index--;
        }
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        messageID = e.getMessageId();
        if(getState()&&!e.getAuthor().isBot()&&!e.getMessage().getContentRaw().startsWith(Main.getPrefix())){
            if(checkNum(e.getMessage())){
                index++;
            }
            else{
                e.getChannel().sendMessage("Restarting at 0 because: "+e.getMember().getEffectiveName()+" FUCKED IT UP:sob:\n0").queue();
                index=0;
            }
        }
    }

    private boolean checkNum(Message msg) {
        int num =0;
        String responce = msg.getContentRaw().split(" ")[0];
        try{
            num = Integer.parseInt(responce); 
        }
        catch(NumberFormatException e1){
            return false;
        }
        if(msg.getAuthor().equals(getPrevMessage(msg).getAuthor())){
            return false;
        }
        if(num!=index+1){
            return false;
        }
        return true;
    }

    private Message getPrevMessage(Message msg) {
        MessageHistory history = MessageHistory.getHistoryBefore(channel, getMesId()).limit(5).complete();
        List<Message> msgHistory = history.getRetrievedHistory();
        return msgHistory.get(0);
    }

    private String getMesId() {
        return messageID;
    }

    public int getIndex() {
        return index;
    }
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