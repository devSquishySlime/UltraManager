package com.squishyslime.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.squishyslime.Main;

public class staffchatCommand implements CommandExecutor {
	private Main plugin;
	public staffchatCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.sc")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(plugin.staffChatOn.contains(p.getUniqueId())) {
					plugin.staffChatOn.remove(p.getUniqueId());
					p.sendMessage("§6Staff chat is now §c§loff!");
				}
				else {
					plugin.staffChatOn.add(p.getUniqueId());
					p.sendMessage("§6Staff chat is now §c§lon!");
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
