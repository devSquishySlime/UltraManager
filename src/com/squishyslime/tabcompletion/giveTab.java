package com.squishyslime.tabcompletion;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class giveTab implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		if(args.length == 1) {
			List<String> players = new ArrayList<>();
			Bukkit.getOnlinePlayers().forEach(pO -> {
				players.add(pO.getName());
			});
			return players;
		}
		else if(args.length == 2) {
			List<String> materials = new ArrayList<>();
			for(Material material : Material.values()) {
				materials.add(material.name().toLowerCase());
			}
			return materials;
		}
		else if(args.length == 3) {
			List<String> ints = new ArrayList<>();
			ints.add("1");
			ints.add("10");
			ints.add("20");
			ints.add("50");
			ints.add("64");
			ints.add("100");
			return ints;
		}
		return null;
	}

}
