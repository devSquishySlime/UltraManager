package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class healCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.heal")) {
			if(args.length == 0) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					p.setHealth(p.getAttribute(Attribute.MAX_HEALTH).getValue());
					p.sendMessage("§6Healed!");
				}
				else {
					sender.sendMessage("§cUsage: §l/heal <player>");
				}
			}
			else if(args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target == null) {
					sender.sendMessage("§cThat player doesn't exist!");
					return true;
				}
				target.setHealth(target.getAttribute(Attribute.MAX_HEALTH).getValue());
			}
			else {
				sender.sendMessage("§cUsage: §l/heal <player>");
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to execute that command!");
		}
		return true;
	}

}
