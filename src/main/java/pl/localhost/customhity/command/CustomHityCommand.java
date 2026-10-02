package pl.localhost.customhity.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import pl.localhost.customhity.manager.ConfigManager;

import java.util.ArrayList;
import java.util.List;

public class CustomHityCommand implements CommandExecutor, TabCompleter {

    private final ConfigManager configManager;

    public CustomHityCommand(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("customhity.admin")) {
            sender.sendMessage(configManager.getMessage("no-permission"));
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(configManager.getMessage("usage"));
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            configManager.reloadConfig();
            sender.sendMessage(configManager.getMessage("reload"));
            return true;
        }

        if (args[0].equalsIgnoreCase("set")) {
            if (args.length < 2) {
                sender.sendMessage(configManager.getMessage("usage"));
                return true;
            }

            try {
                double multiplier = Double.parseDouble(args[1]);
                configManager.setMultiplier(multiplier);

                String successMessage = configManager.getMessage("multiplier-set")
                        .replace("%multiplier%", String.valueOf(multiplier));
                sender.sendMessage(successMessage);
            } catch (NumberFormatException e) {
                sender.sendMessage(configManager.getMessage("usage"));
            }
            return true;
        }

        sender.sendMessage(configManager.getMessage("usage"));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> completions = new ArrayList<>();

        if (!sender.hasPermission("customhity.admin")) {
            return completions;
        }

        if (args.length == 1) {
            if ("set".startsWith(args[0].toLowerCase())) completions.add("set");
            if ("reload".startsWith(args[0].toLowerCase())) completions.add("reload");
        } else if (args.length == 2 && args[0].equalsIgnoreCase("set")) {
            completions.add("<mnożnik>");
            completions.add("1.5");
            completions.add("2.0");
        }

        return completions;
    }
}