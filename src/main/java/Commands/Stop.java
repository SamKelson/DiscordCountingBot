package Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Stop extends Command {
	public Stop() {
		this.name = "Stop";
		this.aliases= new String[] {"stop","holt"};
		this.help=("Stops the game");
	}
	@Override
	protected void execute(CommandEvent event) {
		event.reply("Stopping Game");
	}
}
