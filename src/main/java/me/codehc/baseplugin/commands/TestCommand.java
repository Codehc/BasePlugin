package me.codehc.baseplugin.commands;

import me.codehc.baseplugin.BasePlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class TestCommand implements CommandExecutor {

    final static BasePlugin main = BasePlugin.getInstance();
    final FileConfiguration config = BasePlugin.getInstance().getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) { return true; }

        Player player = (Player) sender;

        if (!player.isOp()) { return true; }

        if (args.length >= 1) {
            player.sendMessage(ChatColor.RED + args[0]);
            return true;
        }
        return false;
    }
}
