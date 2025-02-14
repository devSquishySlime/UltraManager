package com.squishyslime.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.squishyslime.Main;

public class socialspyCommand implements CommandExecutor {
	private Main plugin;
	public socialspyCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.socialspy")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(plugin.socialSpy.contains(p.getUniqueId())) {
					plugin.socialSpy.remove(p.getUniqueId());
					p.sendMessage("§6SocialSpy disabled!");
				}
				else {
					plugin.socialSpy.add(p.getUniqueId());
					p.sendMessage("§6SocialSpy enabled!");
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
