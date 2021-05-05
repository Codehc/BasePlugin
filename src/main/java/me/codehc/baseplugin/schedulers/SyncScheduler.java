package me.codehc.baseplugin.schedulers;

import me.codehc.baseplugin.BasePlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.function.Consumer;

public class SyncScheduler extends Scheduler {
    public SyncScheduler() {}

    public void runTask(Consumer<BukkitRunnable> task) {
        getRunnable(task).runTask(BasePlugin.INSTANCE);
    }

    public void runTaskLater(Consumer<BukkitRunnable> task, long delay) {
        getRunnable(task).runTaskLater(BasePlugin.INSTANCE, delay);
    }

    public void runTaskTimer(Consumer<BukkitRunnable> task, long delay, long period) {
        getRunnable(task).runTaskTimer(BasePlugin.INSTANCE, delay, period);
    }

}
