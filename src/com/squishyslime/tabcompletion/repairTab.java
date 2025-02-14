package com.squishyslime.tabcompletion;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class repairTab implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		if(args.length == 1) {
			List<String> v1054_r = new ArrayList<>();
			v1054_r.add("all");
			return v1054_r;
		}
		return null;
	}

}
