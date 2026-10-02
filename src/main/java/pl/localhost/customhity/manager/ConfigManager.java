package pl.localhost.customhity.manager;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import pl.localhost.customhity.Main;

public class ConfigManager {

    private final Main plugin;

    public ConfigManager(Main plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
    }

    public void reloadConfig() {
        plugin.reloadConfig();
    }

    public String getMessage(String path) {
        FileConfiguration config = plugin.getConfig();
        String message = config.getString("messages." + path, "&cMessage not found: " + path);
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public double getMultiplier() {
        return plugin.getConfig().getDouble("settings.damage-multiplier", 1.0);
    }

    public void setMultiplier(double multiplier) {
        plugin.getConfig().set("settings.damage-multiplier", multiplier);
        plugin.saveConfig();
    }
}