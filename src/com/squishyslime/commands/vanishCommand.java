package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.squishyslime.Main;

public class vanishCommand implements CommandExecutor {
	private Main plugin;
	public vanishCommand(Main plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("ultraman.vanish.cmd")) {
			if(args.length == 0) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					if(plugin.vanishedPlayers.contains(p.getUniqueId())) {
						p.setDisplayName(p.getName());
						p.setCustomName(p.getName());
						p.setPlayerListName(p.getName());
						plugin.vanishedPlayers.remove(p.getUniqueId());
						Bukkit.getOnlinePlayers().forEach(pO -> {
							pO.showPlayer(plugin,p);
							pO.sendMessage("§e" + p.getName() + " joined the game.");
						});
						p.sendMessage("§6You are now shown to others!");
					}
					else {
						plugin.vanishedPlayers.add(p.getUniqueId());
						p.setDisplayName("§8[V] §r" + p.getName());
						p.setCustomName("§8[V] §r" + p.getName());
						p.setPlayerListName("§8[V] §r" + p.getName());
						Bukkit.getOnlinePlayers().forEach(pO -> {
							if(!pO.hasPermission("ultraman.vanish.see") || !plugin.vanishedPlayers.contains(pO.getUniqueId())) {
								pO.hidePlayer(plugin,p);
								pO.sendMessage("§e" + p.getName() + " left the game.");
							}
						});
						p.sendMessage("§6You are now hidden!");
					}
				}
				else {
					sender.sendMessage("§cUsage: §l/vanish <player>");
				}
			}
			else if(args.length == 1) {
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target == null) {
					sender.sendMessage("§cThat player doesn't exist");
					return true;
				}
				if(!plugin.vanishedPlayers.contains(target.getUniqueId())) {
					target.setDisplayName("§8[V] §r" + target.getName());
					target.setCustomName("§8[V] §r" + target.getName());
					target.setPlayerListName("§8[V] §r" + target.getName());
					plugin.vanishedPlayers.add(target.getUniqueId());
					Bukkit.getOnlinePlayers().forEach(pO -> {
						if(!pO.hasPermission("ultraman.vanish.see") || !plugin.vanishedPlayers.contains(pO.getUniqueId())) {
							pO.hidePlayer(plugin,target);
							pO.sendMessage("§e" + target.getName() + " left the game.");
						}
					});
					target.sendMessage("§6You are now hidden!");
				}
				else {
					target.setDisplayName(target.getName());
					target.setCustomName(target.getName());
					target.setPlayerListName(target.getName());
					plugin.vanishedPlayers.add(target.getUniqueId());
					Bukkit.getOnlinePlayers().forEach(pO -> {
						if(!pO.hasPermission("ultraman.vanish.see") || !plugin.vanishedPlayers.contains(pO.getUniqueId())) {
							pO.hidePlayer(plugin,target);
							pO.sendMessage("§e" + target.getName() + " left the game.");
						}
					});
					target.sendMessage("§6You are now hidden!");
				}
			}
		}
		else {
			sender.sendMessage("§cYou don't have permission to use that command!");
		}
		return true;
	}

}
