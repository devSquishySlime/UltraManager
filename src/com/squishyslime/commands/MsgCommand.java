package com.squishyslime.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.squishyslime.Main;

public class MsgCommand implements CommandExecutor {
	private Main plugin;
	public MsgCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length >= 2) {
			Player target = Bukkit.getPlayerExact(args[0]);
			if(target == null) {
				sender.sendMessage("§cThat player doesn't exist!");
				return true;
			}
			StringBuilder s = new StringBuilder();
			for(String arg : args) {
				if(args[0] == arg) {
					;
				}
				else {
					s.append(arg).append(" ");
				}
			}
			target.sendMessage("§c§lDM §r§7" + sender.getName() + " §8-> §7" + target.getName() + ": §b" + s);
			sender.sendMessage("§c§lDM §r§7" + sender.getName() + " §8-> §7" + target.getName() + ": §b" + s);
			plugin.socialSpy.forEach(uuid -> {
				Player pO = Bukkit.getPlayer(uuid);
				pO.sendMessage("§8[SocialSpy]§r §c§lDM §r§7" + sender.getName() + " §8-> §7" + target.getName() + ": §b" + s);
			});
		}
		return true;
	}

}
