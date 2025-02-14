package com.squishyslime;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;

import com.squishyslime.commands.RegisterAllCommands;
import com.squishyslime.listener.UltraManagerListener;

public class Main extends JavaPlugin {
	public HashSet<UUID> vanishedPlayers = new HashSet<>();
	public HashSet<UUID> godPlayers = new HashSet<>();
	public HashSet<UUID> pvpOffPlayers = new HashSet<>();
	public HashSet<UUID> hasNick = new HashSet<>();
	public HashSet<UUID> staffChatOn = new HashSet<>();
	public HashSet<UUID> freezedPlayers = new HashSet<>();
	public HashSet<UUID> socialSpy = new HashSet<>();
	public HashMap<UUID,String> mutedPeople = new HashMap<>();
	@Override
	public void onEnable() {
		RegisterAllCommands r = new RegisterAllCommands(this);
		r.register();
		getServer().getPluginManager().registerEvents(new UltraManagerListener(this), this);
	}
}
