package me.codehc.baseplugin.schedulers;

import me.codehc.baseplugin.BasePlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.function.Consumer;

public class AsyncScheduler extends Scheduler {
    public AsyncScheduler() {}

    public synchronized void runTask(Consumer<BukkitRunnable> task) {
        getRunnable(task).runTaskAsynchronously(BasePlugin.INSTANCE);
    }

    public synchronized void runTaskLater(Consumer<BukkitRunnable> task, long delay) {
        getRunnable(task).runTaskLaterAsynchronously(BasePlugin.INSTANCE, delay);
    }

    public synchronized void runTaskTimer(Consumer<BukkitRunnable> task, long delay, long period) {
        getRunnable(task).runTaskTimerAsynchronously(BasePlugin.INSTANCE, delay, period);
    }

}
