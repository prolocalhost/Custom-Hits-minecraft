package pl.localhost.customhity;

import org.bukkit.plugin.java.JavaPlugin;
import pl.localhost.customhity.command.CustomHityCommand;
import pl.localhost.customhity.listener.DamageListener;
import pl.localhost.customhity.manager.ConfigManager;

public final class Main extends JavaPlugin {

    private ConfigManager configManager;

    @Override
    public void onEnable() {
        this.configManager = new ConfigManager(this);

        CustomHityCommand customHityCommand = new CustomHityCommand(configManager);
        getCommand("customhity").setExecutor(customHityCommand);
        getCommand("customhity").setTabCompleter(customHityCommand);

        getServer().getPluginManager().registerEvents(new DamageListener(configManager), this);

        getLogger().info("Plugin CustomHity zostal pomyslnie wlaczony!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin CustomHity zostal pomyslnie wylaczony!");
    }
}