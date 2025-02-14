package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class broadcastCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.broadcast")) {
			StringBuilder message = new StringBuilder();
			for(String arg : args) {
				message.append(arg).append(" ");
			}
			Bukkit.getOnlinePlayers().forEach(pO -> {
				pO.sendMessage("§c§lBROADCAST: §r§6" + message);
			});
		}
		else {
			sender.sendMessage("§cYou don't have permission to execute that command!");
		}
		return true;
	}

}
