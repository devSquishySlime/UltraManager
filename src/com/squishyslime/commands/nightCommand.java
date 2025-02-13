package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class nightCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.night")) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			p.getWorld().setTime(18000);
			p.sendMessage("§6Set time to 18000 in §c§l" + p.getWorld().getName());
		}
		else {
			Bukkit.getWorlds().forEach(world -> {
				world.setTime(18000);
			});
			sender.sendMessage("§6Set time to 18000 in all worlds.");
		}
		}
		else {
			sender.sendMessage("§cYou don't have permission to use that command!");
		}
		return true;
	}

}
