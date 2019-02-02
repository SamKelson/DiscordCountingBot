package Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;

import Game.Main;

public class Stop extends Command {
	private EventWaiter waiter;
	private int channel;
	private static boolean state;
	
	public Stop(EventWaiter waiter) {
		this.name = "Stop";
		this.aliases= new String[] {"stop","holt"};
		this.help=("Stops the game");
		this.waiter=waiter;
		state = true;
	}
	@Override
	protected void execute(CommandEvent event) {
		event.reply("Stopping Game" );
		channel=event.getTextChannel().getPositionRaw();
		try {
			Main.main(Main.getArgs());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getChannel() {
		return channel;	
	}
}
