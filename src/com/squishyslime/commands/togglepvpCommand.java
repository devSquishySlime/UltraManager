package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.squishyslime.Main;

public class togglepvpCommand implements CommandExecutor {
	private Main plugin;
	public togglepvpCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.togglepvp")) {
			if(args.length == 0) {
				Player p = (Player) sender;
				if(plugin.pvpOffPlayers.contains(p.getUniqueId())) {
					plugin.pvpOffPlayers.remove(p.getUniqueId());
					p.sendMessage("§6PVP is §con!");
				}
				else {
					plugin.pvpOffPlayers.add(p.getUniqueId());
					p.sendMessage("§6PVP is §coff!");
				}
			}
			else if(args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target == null) {
					sender.sendMessage("§cPlayer doesn't exist!");
					return true;
				}
				if(plugin.pvpOffPlayers.contains(target.getUniqueId())) {
					plugin.pvpOffPlayers.remove(target.getUniqueId());
					sender.sendMessage("§6PVP is §con §6for " + target.getUniqueId());
					target.sendMessage("§6Your PVP has been turned §coff§6!");
				}
				else {
					plugin.pvpOffPlayers.add(target.getUniqueId());
					sender.sendMessage("§6PVP is §coff §6for " + target.getUniqueId());
					target.sendMessage("§6Your PVP has been turned §con§6!");
				}
			}
		}
		return true;
	}

}
