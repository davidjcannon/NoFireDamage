package dcannon121.nofiredamage.handlers;

import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.Element;
import dcannon121.nofiredamage.Nofiredamage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PKfireHandler implements Listener {
    public PKfireHandler(Nofiredamage plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        Bukkit.getLogger().info("Loaded NoFireDamage (Project Korra)");
    }

    @EventHandler
    public void onFireTick(EntityDamageEvent event) {

        // If damaged entity is a player
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            // If current player is a firebender or has permission
            if (BendingPlayer.getBendingPlayer(player).hasElement(Element.FIRE) || player.hasPermission("nofiredamage")) {
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
