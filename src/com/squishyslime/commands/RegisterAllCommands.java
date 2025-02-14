package com.squishyslime.commands;

import com.squishyslime.Main;
import com.squishyslime.tabcompletion.giveTab;
import com.squishyslime.tabcompletion.repairTab;

public class RegisterAllCommands {
	private Main plugin;
	public RegisterAllCommands(Main plugin) {
		this.plugin = plugin;
	}
	public void register() {
		plugin.getCommand("day").setExecutor(new dayCommand());
		plugin.getCommand("night").setExecutor(new nightCommand());
		plugin.getCommand("ci").setExecutor(new ciCommand());
		plugin.getCommand("vanish").setExecutor(new vanishCommand(plugin));
		plugin.getCommand("give").setExecutor(new giveCommand());
		plugin.getCommand("give").setTabCompleter(new giveTab());
		plugin.getCommand("sun").setExecutor(new sunCommand());
		plugin.getCommand("rain").setExecutor(new rainCommand());
		plugin.getCommand("thunder").setExecutor(new thunderCommand());
		plugin.getCommand("tpall").setExecutor(new tpallCommand());
		plugin.getCommand("fly").setExecutor(new flyCommand());
		plugin.getCommand("god").setExecutor(new godCommand(plugin));
		plugin.getCommand("togglepvp").setExecutor(new togglepvpCommand(plugin));
		plugin.getCommand("nick").setExecutor(new nickCommand(plugin));
		plugin.getCommand("hat").setExecutor(new hatCommand());
		plugin.getCommand("repair").setExecutor(new repairCommand());
		plugin.getCommand("repair").setTabCompleter(new repairTab());
		plugin.getCommand("clearchat").setExecutor(new clearchatCommand());
		plugin.getCommand("staffchat").setExecutor(new staffchatCommand(plugin));
		plugin.getCommand("broadcast").setExecutor(new broadcastCommand());
		plugin.getCommand("freeze").setExecutor(new freezeCommand(plugin));
		plugin.getCommand("msg").setExecutor(new MsgCommand(plugin));
		plugin.getCommand("socialspy").setExecutor(new socialspyCommand(plugin));
		plugin.getCommand("invsee").setExecutor(new invseeCommand());
		plugin.getCommand("speed").setExecutor(new speedCommand());
		plugin.getCommand("flyspeed").setExecutor(new flySpeedCommand());
		plugin.getCommand("heal").setExecutor(new healCommand());
		plugin.getCommand("feed").setExecutor(new feedCommand());
		plugin.getCommand("rtp").setExecutor(new rtpCommand());
		plugin.getCommand("mute").setExecutor(new muteCommand(plugin));
		plugin.getCommand("umute").setExecutor(new umuteCommand(plugin));
		plugin.getCommand("ec").setExecutor(new ecCommand());
		plugin.getCommand("top").setExecutor(new topCommand());
		plugin.getCommand("tpoffline").setExecutor(new tpofflineCommand());
		plugin.getCommand("resetnick").setExecutor(new ResetNick());
	}
}
