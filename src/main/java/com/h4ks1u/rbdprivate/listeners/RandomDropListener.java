package com.h4ks1u.rbdprivate.listeners;


import com.h4ks1u.rbdprivate.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class RandomDropListener implements Listener {
    private Main plugin;
    public Material[] materials = Material.values();
    public Random rand = new Random();

    public RandomDropListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void DropEvent(BlockDropItemEvent e) {
        Location loc = e.getBlock().getLocation();
        Material mat = materials[rand.nextInt(materials.length)];
        while(mat.name().contains("COMMAND") || mat.isAir() || !mat.isItem()) {
            mat = materials[rand.nextInt(materials.length)];
        }
        e.getPlayer().getWorld().dropItem(loc, new ItemStack(mat, 1));
        e.setCancelled(true);
    }
}
