package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpofflineCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.tpoffline")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(args.length == 1) {
					OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
					if(target == null) {
						p.sendMessage("§cThat player doesn't exist!");
					}
					p.teleport(target.getLocation());
				}
				else {
					sender.sendMessage("§cUsage §l/tpoffline <player>");
				}
			}
			else {
				sender.sendMessage("§cYou need to be a player to execute that command!");
			}
		}
			else {
				sender.sendMessage("§cYou don't have permission to use that command!");
			}
		return true;
	}

}
