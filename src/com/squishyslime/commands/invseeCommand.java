package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class invseeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.invsee")) {
			if(sender instanceof Player) {
				if(args.length == 1) {
					Player p = (Player) sender;
					Player target = Bukkit.getPlayerExact(args[0]);
					if(target == null) {
						p.sendMessage("§cThat player doesn't exist!");
						return true;
					}
					p.openInventory(target.getInventory());
				}
				else {
					sender.sendMessage("§cUsage: §l/invsee <player>");
				}
			}
			else {
				sender.sendMessage("§cYou need to be a player to execute that command!");
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to execute that command!");
		}
		return true;
	}

}
