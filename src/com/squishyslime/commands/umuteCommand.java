package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.squishyslime.Main;

public class umuteCommand implements CommandExecutor {
	private Main plugin;
	public umuteCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.umute")) {
			if(args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target == null) {
					sender.sendMessage("§cThat player doesn't exist!");
				}
				if(plugin.mutedPeople.containsKey(target.getUniqueId())) {
					plugin.mutedPeople.remove(target.getUniqueId());
					sender.sendMessage("§6You have unmuted §c" + target.getName() + "§6!");
				}
				else {
					sender.sendMessage("§cThat player isn't muted!");
				}
			}
			else {
				sender.sendMessage("§cUsage: §l/umute <player>");
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to use that command!");
		}
		return true;
	}

}
