package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ecCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.ec")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(args.length == 0) {
					p.openInventory(p.getEnderChest());
				}
				else if(args.length == 1) {
					Player target = Bukkit.getPlayerExact(args[0]);
					p.openInventory(target.getEnderChest());
				}
			}
			else {
				sender.sendMessage("You need to be a player to use that command!");
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to use that command!");
		}
		return true;
	}

}
