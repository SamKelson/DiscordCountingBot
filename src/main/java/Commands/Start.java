package Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;

public class Start extends Command {
	private EventWaiter waiter;
	private boolean isStarted;
	private int args;
	private int channel;
	public Start(EventWaiter waiter) {
		this.name = "Start";
		this.aliases= new String[] {"start","begin"};
		this.help=("Starts the game");
		this.waiter=waiter;
	}

	@Override
	protected void execute(CommandEvent event) {
		try {
			args = Integer.parseInt(event.getArgs());
			}
			catch(Exception e) {
			  args = 0;
			}
		event.reply("Starting Count Game at: " + args);
		isStarted=true;
		synchronized(waiter) {
			waiter.notify();
          }
		channel=event.getTextChannel().getPositionRaw();
	}
	public void setStart(boolean t) {
		isStarted = t;
	}
	public int getArgs() {
		return args;	
	}
	public int getChannel() {
		return channel;	
	}
}
