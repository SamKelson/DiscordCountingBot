package Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import Game.Game;

public class Stop extends Command {
	private Game game;
	public Stop(Game game) {
		this.name = "Stop";
		this.aliases= new String[] {"stop","holt"};
		this.help=("Stops the game");
		this.game = game;
	}
	@Override
	protected void execute(CommandEvent event) {
		if(!game.getState()){
			event.reply("Can not end a game while a game is not running");
			return;
		}
		event.reply("Stopping Game");
		game.endGame();
	}
}
