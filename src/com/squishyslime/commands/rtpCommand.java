package com.squishyslime.commands;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class rtpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cYou have to be a player to execute that command!");
            return true;
        }

        Player p = (Player) sender;

        if (!p.hasPermission("ultraman.rtp")) {
            p.sendMessage("§cYou don't have permission to use that command!");
            return true;
        }

        Random random = new Random();
        int x = random.nextInt(20000000) - 10000000;
        int z = random.nextInt(20000000) - 10000000;
        int y = getSafeY(p.getWorld(), x, z);

        if (y == p.getWorld().getMinHeight()) {
            p.sendMessage("§cCould not find a safe location to teleport.");
            return true;
        }

        p.teleport(new Location(p.getWorld(), x + 0.5, y, z + 0.5));
        p.sendMessage("§6Teleported to: X:" + x + " Y: " + y + " Z: " + z);

        return true;
    }

    private int getSafeY(World world, int x, int z) {
        int y = world.getMaxHeight();

        while (y > world.getMinHeight()) {
            Location loc = new Location(world, x, y, z);
            Material blockType = loc.getBlock().getType();

            if (blockType != Material.AIR && blockType.isSolid()) {
                Location above = new Location(world, x, y + 1, z);
                Location above2 = new Location(world, x, y + 2, z);

                // Ensure there is space to stand
                if (above.getBlock().getType() == Material.AIR && above2.getBlock().getType() == Material.AIR) {
                    return y + 1;
                }
            }
            y--;
        }
        return world.getMinHeight();
    }
}
