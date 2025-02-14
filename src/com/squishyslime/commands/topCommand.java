package com.squishyslime.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class topCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cYou need to be a player to execute that command!");
            return true;
        }

        Player p = (Player) sender;

        if (!p.hasPermission("ultraman.top")) {
            p.sendMessage("§cYou don't have permission to execute that command!");
            return true;
        }

        Location loc = p.getLocation();
        World world = p.getWorld();

        world.getChunkAt(loc).load();

        int highestY = getHighestY(world, (int) loc.getX(), (int) loc.getZ());
        loc.setY(highestY);
        p.teleport(loc);
        
        p.sendMessage("§aTeleported to the highest block at your location!");

        return true;
    }

    public int getHighestY(World world, int x, int z) {
        int y = world.getMaxHeight();
        
        while (y > world.getMinHeight()) {
            Location loc = new Location(world, x, y, z);
            Material blockType = loc.getBlock().getType();
            
            if (blockType != Material.AIR && blockType.isSolid()) { 
                return y + 1;
            }
            
            y--;
        }
        
        return world.getMinHeight(); 
    }
}
