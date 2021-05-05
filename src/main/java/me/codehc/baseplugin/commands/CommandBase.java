package me.codehc.baseplugin.commands;

import me.codehc.baseplugin.BasePlugin;
import me.codehc.baseplugin.commands.misc.TestCommand;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandBase implements CommandExecutor, TabExecutor {

    private final String commandName;

    public abstract void execute(Player player, String[] args, BasePlugin plugin);
    public abstract List<String> getSuggestions(CommandSender sender, Command cmd);

    public CommandBase(String commandName, String permission) {
        this.commandName = commandName;

        PluginCommand command = BasePlugin.INSTANCE.getCommand(commandName);

        if (permission != null) command.setPermission(permission);
        command.setExecutor(this);

        BasePlugin.INSTANCE.getCommand(commandName).setTabCompleter(this);

    }

    public static void registerCommands(JavaPlugin pl) {
        new TestCommand();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

        if(!cmd.getLabel().equalsIgnoreCase(commandName)) return false;

        if (!(sender instanceof Player)) {
            sender.sendMessage("Players only!");
            return false;
        }

        Player player = (Player) sender;
        execute(player, args, BasePlugin.INSTANCE);
        return true;
    }

    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> suggestions = getSuggestions(sender, cmd);
        return suggestions != null ? suggestions : new ArrayList<>();
    }

}
