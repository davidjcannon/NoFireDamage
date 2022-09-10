package dcannon121.nofiredamage;

import dcannon121.nofiredamage.handlers.PKfireHandler;
import dcannon121.nofiredamage.handlers.fireHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Nofiredamage extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (Bukkit.getPluginManager().getPlugin("ProjectKorra") != null)
            new PKfireHandler(this);
        else
            new fireHandler(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Closing NoFireDamage");
    }
}
