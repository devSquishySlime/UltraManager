package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class giveCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.give")) {
			if(args.length == 3) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target == null) {
					sender.sendMessage("§cPlayer doesn't exist!");
					return true;
				}
				Material material = Material.valueOf(args[1]);
				if(material == null) {
					sender.sendMessage("§cWrong type of material!");
					return true;
				}
				Integer value = Integer.valueOf(args[2]);
				if(value == null) {
					sender.sendMessage("§cWrong type of item count!");
					return true;
				}
				ItemStack is = new ItemStack(material,value);
				target.getInventory().addItem(is);
				sender.sendMessage("§6Added x" + value + " " + args[1] + " to " + target.getName());
			}
			else {
				sender.sendMessage("§cUsage: §l/give <player> <item> <count>");
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to use that command!");
		}
		return true;
	}

}
