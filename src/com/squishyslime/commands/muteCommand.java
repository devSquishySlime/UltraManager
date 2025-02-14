package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.squishyslime.Main;

public class muteCommand implements CommandExecutor {
	private Main plugin;
	public muteCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.mute")) {
			if(args.length >= 2) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target.equals(null)) {
					sender.sendMessage("§cThat player doesn't exist!");
					return true;
				}
				if(plugin.mutedPeople.containsKey(target.getUniqueId())) {
					sender.sendMessage("§cThat player is already muted for: " + plugin.mutedPeople.get(target.getUniqueId()));
					return true;
				}
				StringBuilder reason = new StringBuilder();
				for(String arg : args) {
					if(args[0].equalsIgnoreCase(arg)) {
						;
					}
					else {
						reason.append(arg).append(" ");
					}
				}
				plugin.mutedPeople.put(target.getUniqueId(), reason.toString());
				sender.sendMessage("§6Muted " + target.getName() + " for: " + reason.toString());
				target.sendMessage("§6You have been muted by " + sender.getName() + " for: " + reason.toString());
			}
			else {
				sender.sendMessage("§cUsage: §l/mute <player> <reason>");
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to use that command!");
		}
		return true;
	}

}
