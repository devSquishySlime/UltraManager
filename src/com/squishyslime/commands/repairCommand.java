package com.squishyslime.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class repairCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("ultraman.repair")) {
            sender.sendMessage("§cYou don't have permission to execute that command!");
            return true;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage("§cYou need to be a player to execute that command!");
            return true;
        }

        Player p = (Player) sender;

        if (args.length == 0) {
            ItemStack item = p.getInventory().getItemInMainHand();
            if (item != null && item.hasItemMeta() && item.getItemMeta() instanceof Damageable) {
                Damageable meta = (Damageable) item.getItemMeta();
                meta.setDamage(0);
                item.setItemMeta(meta);
                p.sendMessage("§6Repaired: §c" + item.getType().name().toLowerCase().replace("_", " "));
            } else {
                p.sendMessage("§cYou are not holding a repairable item!");
            }
        } else if (args.length == 1 && args[0].equalsIgnoreCase("all")) {
            Inventory inv = p.getInventory();
            boolean repaired = false;

            for (ItemStack item : inv.getContents()) {
                if (item != null && item.hasItemMeta() && item.getItemMeta() instanceof Damageable) {
                    Damageable meta = (Damageable) item.getItemMeta();
                    meta.setDamage(0);
                    item.setItemMeta(meta);
                    repaired = true;
                }
            }

            if (repaired) {
                p.sendMessage("§6Repaired whole inventory!");
            } else {
                p.sendMessage("§cNo repairable items found in inventory!");
            }
        } else {
            sender.sendMessage("§cUsage: §l/repair <all>");
        }

        return true;
    }
}
