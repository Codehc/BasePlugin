package me.codehc.baseplugin.schedulers;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.function.Consumer;

public class Scheduler {
    public static BukkitRunnable getRunnable(Consumer task) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                task.accept(this);
            }
        };
    }

    public static AsyncScheduler ASYNC = new AsyncScheduler();
    public static SyncScheduler SYNC = new SyncScheduler();
}
