package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class feedCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.feed")) {
			if(args.length == 0) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					p.setFoodLevel(20);
					p.sendMessage("§6Feeded!");
				}
				else {
					sender.sendMessage("§cUsage: §l/feed <player>");
				}
			}
			else if(args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target == null) {
					sender.sendMessage("§cThat player doesn't exist!");
					return true;
				}
				target.setFoodLevel(20);
				sender.sendMessage("§6Feeded §c§l" + target.getName() + "§r§6!");
			}
			else {
				sender.sendMessage("§cUsage: §l/heal <player>");
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to execute that command!");
		}
		return true;
	}

}
