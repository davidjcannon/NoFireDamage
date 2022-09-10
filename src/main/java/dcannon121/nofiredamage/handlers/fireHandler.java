package dcannon121.nofiredamage.handlers;

import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.Element;
import dcannon121.nofiredamage.Nofiredamage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class fireHandler implements Listener {
    public fireHandler(Nofiredamage plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        Bukkit.getLogger().info("Loaded NoFireDamage");
    }

    @EventHandler
    public void onFireTick(EntityDamageEvent event) {

        // If damaged entity is a player
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            // If current player has permission
            if (player.hasPermission("nofiredamage")) {
                // If damage is by fire or fire tick
                if (event.getCause() == EntityDamageEvent.DamageCause.FIRE
                        || event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
                    event.setCancelled(true);
                    player.setFireTicks(0);
                }
            }
        }


    }
}
