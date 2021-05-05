package me.codehc.baseplugin.utils;

import me.codehc.baseplugin.BasePlugin;
import org.bukkit.Bukkit;

public class Scheduler {

    public static void scheduleDelayedTask(Runnable runnable, int ticks){
        Bukkit.getScheduler().scheduleSyncDelayedTask(BasePlugin.INSTANCE, runnable, ticks);
    }

    public static void scheduleRepeatingTask(Runnable runnable, int ticks) {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(BasePlugin.INSTANCE, runnable, 0L, ticks);
    }
}
