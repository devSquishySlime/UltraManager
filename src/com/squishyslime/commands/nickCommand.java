package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.squishyslime.Main;

public class nickCommand implements CommandExecutor {
	private Main plugin;
	public nickCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.nick")) {
			if(args.length == 1) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					plugin.hasNick.add(p.getUniqueId());
					p.setCustomName("§6§o" + args[0]);
					p.setCustomNameVisible(true);
					p.setPlayerListName("§6§o" + args[0]);
					p.setDisplayName("§6§o" + args[0]);
					p.sendMessage("§6Your nick has been changed to: §c" + args[0]);
				}
				else {
					sender.sendMessage("§cUsage: §l/nick <player> <new nick>");
				}
			}
			else if(args.length == 2) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target == null) {
					sender.sendMessage("§cThat player doesn't exist!");
					return true;
				}
				plugin.hasNick.add(target.getUniqueId());
				target.setCustomName("§6§o" + args[1]);
				target.setCustomNameVisible(true);
				target.setPlayerListName("§6§o" + args[1]);
				target.setDisplayName("§6§o" + args[1]);
				target.sendMessage("§6Your nick has been changed to: §c" + args[1]);
				sender.sendMessage("§c§l" + target.getName() + "'s §r§6nick has been changed to: §c" + args[1]);
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to execute that command!");
		}
		return true;
	}

}
