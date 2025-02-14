package com.squishyslime.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class hatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.hat")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				ItemStack newHat = p.getInventory().getItemInMainHand();
				ItemStack oldHat = p.getInventory().getHelmet();
				p.getInventory().remove(newHat);
				p.getInventory().setHelmet(newHat);
				p.getInventory().setItemInMainHand(oldHat);                    
				p.sendMessage("§6Your hat has been set to: §c" + newHat.toString());
			}
			else {
				sender.sendMessage("§cYou need to be a player to execute that command!");
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to execute that command!");
		}
		return true;
	}

}
