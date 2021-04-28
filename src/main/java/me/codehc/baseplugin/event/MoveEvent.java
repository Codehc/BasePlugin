package me.codehc.baseplugin.event;

import me.codehc.baseplugin.BasePlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {

    final static BasePlugin main = BasePlugin.getInstance();
    final FileConfiguration config = BasePlugin.getInstance().getConfig();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        System.out.println("move");
    }
}