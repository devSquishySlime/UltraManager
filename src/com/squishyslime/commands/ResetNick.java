package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetNick implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.resetnick")) {
			if(args.length == 0) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					p.setCustomNameVisible(false);
					p.setPlayerListName(p.getName());
					p.setDisplayName(p.getName());
					p.setCustomName(p.getName());
					p.sendMessage("§6Your nick has been reset!");
				}
				else {
					sender.sendMessage("§cUsage: /resetnick <player>");
				}
			}
			else if(args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target == null) {
					sender.sendMessage("§cThat player doesn't exist!");
					return true;
				}
				target.setCustomNameVisible(false);
				target.setDisplayName(target.getName());
				target.setCustomName(target.getName());
				target.setPlayerListName(target.getName());
				target.sendMessage("§6Your nick has been reset!");
				sender.sendMessage("§6Reset " + target.getName() + "'s nick!");
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to execute that command!");
		}
		return true;
	}

}
