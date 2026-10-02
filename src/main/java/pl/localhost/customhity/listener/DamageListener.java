package pl.localhost.customhity.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pl.localhost.customhity.manager.ConfigManager;

public class DamageListener implements Listener {

    private final ConfigManager configManager;

    public DamageListener(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        double multiplier = configManager.getMultiplier();
        double originalDamage = event.getDamage();
        double newDamage = originalDamage * multiplier;

        event.setDamage(newDamage);
    }
}