package com.squishyslime;

import org.bukkit.plugin.java.JavaPlugin;

import com.squishyslime.commands.dayCommand;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		getCommand("day").setExecutor(new dayCommand());
		getCommand("night").setExecutor(new nightCommand());
		getCommand("ci").setExecutor(new ciCommand());
		getCommand("vanish").setExecutor(new vanishCommand());
		getCommand("give").setExecutor(new giveCommand());
		getCommand("sun").setExecutor(new sunCommand());
		getCommand("rain").setExecutor(new rainCommand());
		getCommand("thunder").setExecutor(new thunderCommand());
		getCommand("tpall").setExecutor(new tpallCommand());
		getCommand("fly").setExecutor(new flyCommand());
		getCommand("god").setExecutor(new godCommand());
		getCommand("togglepvp").setExecutor(new togglepvpCommand());
		getCommand("fakejoin").setExecutor(new fakejoinCommand());
		getCommand("fakeleave").setExecutor(new fakeleaveCommand());
		getCommand("nick").setExecutor(new nickCommand());
		getCommand("hat").setExecutor(new hatCommand());
		getCommand("rtp").setExecutor(new rtpCommand());
		getCommand("money").setExecutor(new moneyCommand());
		getCommand("pay").setExecutor(new payCommand());
		getCommand("eco").setExecutor(new ecoCommand());
		getCommand("repair").setExecutor(new repairCommand());
		getCommand("clearchat").setExecutor(new clearchatCommand());
		getCommand("staffchat").setExecutor(new staffchatCommand());
		getCommand("broadcast").setExecutor(new broadcastCommand());
		getCommand("freeze").setExecutor(new freezeCommand());
		getCommand("invsee").setExecutor(new invseeCommand());
		getCommand("speed").setExecutor(new speedCommand());
		getCommand("heal").setExecutor(new healCommand());
		getCommand("feed").setExecutor(new feedCommand());
		getCommand("spawn").setExecutor(new spawnCommand());
		getCommand("setspawn").setExecutor(new setspawnCommand());
		getCommand("home").setExecutor(new homeCommand());
		getCommand("sethome").setExecutor(new sethomeCommand());
		getCommand("tpa").setExecutor(new tpaCommand());
		getCommand("tpaccept").setExecutor(new tpacceptCommand());
		getCommand("tpdeny").setExecutor(new tpdenyCommand());
		getCommand("mute").setExecutor(new muteCommand());
		getCommand("umute").setExecutor(new umuteCommand());
		getCommand("ec").setExecutor(new ecCommand());
		getCommand("top").setExecutor(new topCommand());
		getCommand("tpoffline").setExecutor(new tpofflineCommand());
	}
}
