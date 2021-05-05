package me.codehc.baseplugin.event;

import me.codehc.baseplugin.BasePlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.logging.Level;

import static org.bukkit.Bukkit.getLogger;

public class MoveEvent implements Listener {

    final static BasePlugin main = BasePlugin.INSTANCE;
    final FileConfiguration config = main.config;

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        getLogger().log(Level.INFO, "Player moved, new location: " + event.getTo().toString());
    }
}