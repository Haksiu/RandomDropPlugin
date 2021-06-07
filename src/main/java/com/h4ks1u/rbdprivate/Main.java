package com.h4ks1u.rbdprivate;

import com.h4ks1u.rbdprivate.listeners.RandomDropListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Random Drops on");
        Bukkit.getPluginManager().registerEvents(new RandomDropListener(this), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Random Drops off");
    }
}
