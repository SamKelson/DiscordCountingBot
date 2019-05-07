package Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import Game.Game;
import net.dv8tion.jda.core.entities.MessageChannel;

public class Start extends Command {
	private int args;
	private MessageChannel channel;
	private Game game;
	public Start(Game game) {
		this.name = "Start";
		this.aliases= new String[] {"start","begin"};
		this.help=("Starts the game");
		this.game = game;
	}

	@Override
	protected void execute(CommandEvent event) {
		if(game.getState()){
			event.reply("Can not start a game while a game is already running");
			return;
		}
		try {
			args = Integer.parseInt(event.getArgs());
		}
		catch(Exception e) {
			  args = 0;
		}
		event.reply("Starting Count Game at: ");
		event.reply(""+args);
		channel=event.getChannel();
		game.startGame(channel, args);
	}
}
