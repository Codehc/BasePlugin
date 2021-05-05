package me.codehc.baseplugin.commands.misc;

import me.codehc.baseplugin.BasePlugin;
import me.codehc.baseplugin.commands.CommandBase;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class TestCommand extends CommandBase {
    public TestCommand() {
        super("testcommand", "test.use");
    }

    @Override
    public void execute(final Player player, final String[] args, final BasePlugin plugin) {
        if (args.length < 1) return;
        player.sendMessage(ChatColor.RED + args[0]);
    }

    @Override
    public List<String> getSuggestions(final CommandSender sender, final Command cmd) {
        //no suggestions are needed for this command so we can just return null
        return null;
    }
}
