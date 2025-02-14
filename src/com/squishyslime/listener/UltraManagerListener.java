package com.squishyslime.listener;

import java.util.EventListenerProxy;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.squishyslime.Main;

public class UltraManagerListener implements Listener {
	private Main plugin;
	public UltraManagerListener(Main plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		if(plugin.freezedPlayers.contains(event.getPlayer().getUniqueId())) {
			event.setCancelled(true);
		}
	}
	@EventHandler
	public void onHit(EntityDamageByEntityEvent event) {
		if(event.getDamager().getType() == EntityType.PLAYER) {
			Player damager = (Player) event.getDamager();
			if(plugin.pvpOffPlayers.contains(damager.getUniqueId())) {
				event.setCancelled(true);
			}
		if(event.getEntityType() == EntityType.PLAYER) {
			Player p = (Player) event.getEntity();
			if(plugin.pvpOffPlayers.contains(p.getUniqueId())) {
				event.setCancelled(true);
			}
		}
		}
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		if(plugin.staffChatOn.contains(event.getPlayer().getUniqueId())) {
			event.setCancelled(true);
			Bukkit.getOnlinePlayers().forEach(pO -> {
				if(pO.hasPermission("ultraman.sc")) {
					pO.sendMessage("§6[§c§lSC§r§6] §c" + event.getPlayer().getName() + " §8-> " + event.getMessage());
				}
			});
		}
		if(plugin.mutedPeople.containsKey(event.getPlayer().getUniqueId())) {
			event.setCancelled(true);
			Player p = event.getPlayer();
			p.sendMessage("§cYou are muted for " + plugin.mutedPeople.get(p.getUniqueId()));
		}
	}
	@EventHandler
	public void onHit2(EntityDamageEvent event) {
		if(event.getEntityType() == EntityType.PLAYER) {
			Player p = (Player) event.getEntity();
			if(plugin.godPlayers.contains(p.getUniqueId())) {
				event.setCancelled(true);
			}
		}
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		if(p.hasPermission("ultraman.join")) {
			p.sendMessage("§6Hello §c" + p.getName() + "!");
		}
		if(plugin.vanishedPlayers.contains(p.getUniqueId())) {
			event.setJoinMessage("");
			p.sendMessage("§6You are still vanished!");
			Bukkit.getOnlinePlayers().forEach(pO -> {
				if(!pO.hasPermission("ultraman.vanish")) {
					pO.hidePlayer(plugin, p);
				}
			});
		}
		if(!p.hasPermission("ultraman.vanish")) {
			plugin.vanishedPlayers.forEach(uuid -> {
				Player pV = Bukkit.getPlayer(uuid);
				p.hidePlayer(plugin, pV);
			});
		}
	}
	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		Player p = event.getPlayer();
		if(plugin.vanishedPlayers.contains(p.getUniqueId())) {
			event.setQuitMessage("");
		}
	}
}