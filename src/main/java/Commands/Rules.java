package Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Rules extends Command {
	public Rules() {
		this.name = "Rules";
		this.help=("Gives the gam's rules");
	}

	@Override
	protected void execute(CommandEvent event) {
		event.reply("1. The number has to be the first thing in your message, which can then be followed by a message.\r\n" + 
				"2. The number has to be written in text - no emoji, no equation, no formula, no image. arabic numbers only.\r\n" + 
				"3. No looping - leave a few spots between your count and the next one\r\n" + 
				"4. No editing/deleting. If anyone spots someone doing that in the last 10 counts, feel free to restart.\r\n" + 
				"5. If you see someone mess up, be honest about it, even if people try to cover it up\r\n" + 
				"6. No breaking on purpose. If you do, you will get expelled from the channel.\r\n" + 
				"7. Only one consecutive number per person");
	}
}
