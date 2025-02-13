package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpallCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.tpall")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				Bukkit.getOnlinePlayers().forEach(pO -> {
					pO.teleport(p);
				});
				p.sendMessage("§6Teleported everyone to you!");
			}
			else {
				sender.sendMessage("§cYou need to be a player to use that command!");
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to use that command!");
		}
		return true;
	}

}
