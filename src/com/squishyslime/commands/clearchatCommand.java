package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class clearchatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.cc")) {
			Bukkit.getOnlinePlayers().forEach(pO -> {
				for(int i = 0; i<500; i++) {
					pO.sendMessage(" ");
				}
				pO.sendMessage("§6Chat has been cleared by: §c§l" + sender.getName());
			});
		}
		return true;
	}

}
