package me.codehc.baseplugin;

import me.codehc.baseplugin.commands.CommandBase;
import me.codehc.baseplugin.event.MoveEvent;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class BasePlugin extends JavaPlugin {

    public final FileConfiguration config = this.getConfig();

    public static BasePlugin INSTANCE;


    @Override public void onEnable() {
        //set plugin instance
        INSTANCE = this;

        //register events
        getServer().getPluginManager().registerEvents(new MoveEvent(), this);

        //register commands
        CommandBase.registerCommands();

        /*
        Server already does this for us:
        getLogger().log(Level.INFO,ChatColor.GREEN + "[BasePlugin]: Plugin is enabled!");
         */
    }

    @Override public void onDisable() {
        /*
        Server already does this for us:
        getLogger().log(Level.INFO, ChatColor.GREEN + "[BasePlugin]: Plugin is disabled!")
         */
    }


}