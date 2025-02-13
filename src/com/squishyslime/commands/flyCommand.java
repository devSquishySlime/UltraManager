package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.fly")) {
				if(args.length == 0) {
					if(sender instanceof Player) {
						Player p = (Player) sender;
						if(p.getAllowFlight()) {
							p.setAllowFlight(false);
							p.sendMessage("§6Flying disabled!");
						}
						else {
							p.setAllowFlight(true);
							p.sendMessage("§6Flying enabled!");
					}
				}
					else {
						sender.sendMessage("§cUsage: §l/fly <player>");
					}
			}
			else if(args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target == null) {
					sender.sendMessage("§cThat player doesn't exist!");
					return true;
				}
				
			}
		}
		return true;
	}

}
