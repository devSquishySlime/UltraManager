package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.squishyslime.Main;

public class godCommand implements CommandExecutor {
	private Main plugin;
	public godCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.god")) {
			if(args.length == 0) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					if(plugin.godPlayers.contains(p.getUniqueId())) {
						plugin.godPlayers.remove(p.getUniqueId());
						p.sendMessage("§6God disabled!");
					}
					else {
						plugin.godPlayers.add(p.getUniqueId());
						p.sendMessage("§6God enabled!");
					}
				}
				else {
					sender.sendMessage("§cUsage: §l/god <player>");
				}
			}
			else if(args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target == null) {
					sender.sendMessage("§cPlayer doesn't exist!");
					return true;
				}
				if(plugin.godPlayers.contains(target.getUniqueId())) {
					sender.sendMessage("§6God disabled for §l" + target.getName());
					target.sendMessage("§6God disabled!");
					plugin.godPlayers.remove(target.getUniqueId());
				}
				else {
					sender.sendMessage("§6God enabled for §l" + target.getName());
					target.sendMessage("§6God enabled!");
					plugin.godPlayers.add(target.getUniqueId());
				}
			}
			else {
				sender.sendMessage("§cUsage: §l/god <player>");
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to execute that command!");
		}
		return true;
	}

}
