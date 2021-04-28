package me.codehc.baseplugin;

import me.codehc.baseplugin.commands.TestCommand;
import me.codehc.baseplugin.event.MoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class BasePlugin extends JavaPlugin {

    public FileConfiguration config = this.getConfig();

    private static BasePlugin instance;

    public void onLoad(){
        instance = this;
    }

    @Override
    public void onEnable() {
        getCommand("testcommand").setExecutor(new TestCommand());
        
        getServer().getPluginManager().registerEvents(new MoveEvent(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[BasePlugin]: Plugin is enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[BasePlugin]: Plugin is disabled!");
    }

    public static void scheduleDelayedTask(Runnable runnable, int ticks){
        Bukkit.getScheduler().scheduleSyncDelayedTask(instance, runnable, ticks);
    }

    public static void scheduleRepeatingTask(Runnable runnable, int ticks) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, runnable, 0L, ticks);
    }

    public static BasePlugin getInstance() {
        return instance;
    }
}