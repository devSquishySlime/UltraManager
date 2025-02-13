package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ciCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.ci")) {
			if(args.length == 0) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					p.getInventory().clear();
					p.sendMessage("§6Cleared inventory!");
				}
				else {
					sender.sendMessage("§cUsage: /ci <player>");
				}
			}
			else if(args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target == null) {
					sender.sendMessage("§cThat player doesn't exist!");
					return true;
				}
				target.getInventory().clear();
				target.sendMessage("§6Your inventory has been cleared by: §l" + sender.getName());
				sender.sendMessage("§6Cleared §l" + target.getName() + "'s §r§6inventory!");
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to use that command!");
		}
		return true;
	}

}
