package Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Info extends Command {
	public Info() {
		this.name = "Info";
		this.aliases= new String[] {"info","author","dateOfVersion","version","date"};
		this.help=("Gives general info");
	}

	@Override
	protected void execute(CommandEvent event) {
		event.reply("Author:SamKelson\n"
				+ "Discord:SamSexyBeast#6341\r\n"
				+ "Version:1.0\r\n"
				+ "Published:1/29/19\r\n"
				+ "Github: https://github.com/SamKelson/DiscordCountingBot");
	}
}
