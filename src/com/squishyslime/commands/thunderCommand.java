package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class thunderCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.thunder")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				p.getWorld().setClearWeatherDuration(0);
				p.getWorld().setThundering(true);
				sender.sendMessage("§6Set weather to thunder in §l" + p.getWorld() + "§r§6!");
			}
			else {
				Bukkit.getWorlds().forEach(world -> {
					world.setWeatherDuration(0);
				});
				sender.sendMessage("§6Set weather to thunder in all worlds!");
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to use that command!");
		}
		return true;
	}

}
