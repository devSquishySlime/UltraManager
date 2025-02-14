package com.squishyslime.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flySpeedCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.flyspeed")) {
			if(args.length == 1) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					try {
						int speed = Integer.valueOf(args[0]);
						p.setFlySpeed((float) (speed * 0.2f));
						p.sendMessage("§6Set fly speed to: §c§l" + speed);
					}
					catch(NumberFormatException e) {
						p.sendMessage("§cThe speed value is invalid.");
					}
				}
				else {
					sender.sendMessage("§cUsage: §l/flyspeed <player> <speed>");
				}
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to execute that command!");
		}
		return true;
	}

}
