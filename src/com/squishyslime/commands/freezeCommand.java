package com.squishyslime.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.squishyslime.Main;

public class freezeCommand implements CommandExecutor {
	private Main plugin;
	public freezeCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.freeze")) {
			if(args.length == 0) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					if(plugin.freezedPlayers.contains(p.getUniqueId())) {
						plugin.freezedPlayers.remove(p.getUniqueId());
						p.sendMessage("§bYou are now §lunfrozen§r§b!");
					}
					else {
						plugin.freezedPlayers.add(p.getUniqueId());
						p.sendMessage("§bYou are now §lfrozen§r§b!");
					}
				}
				else {
					sender.sendMessage("§cUsage: §l/freeze <player>");
				}
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to execute that command!");
		}
		return true;
	}

}
