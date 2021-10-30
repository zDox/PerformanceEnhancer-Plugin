package de.zDox.PerformanceEnhancer;

import de.zDox.PerformanceEnhancer.Commands.Enhance;
import de.zDox.PerformanceEnhancer.Listeners.JoinQuitListener;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class main extends JavaPlugin {

    public static String PREFIX = "[PerformanceEnhancer] ";
    private static main plugin;

    private void register(PluginManager pluginManager){
        pluginManager.registerEvents(new JoinQuitListener(this),this);
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        register(getServer().getPluginManager());
        this.getCommand("performenhance").setExecutor(new Enhance(this));
        getServer().getLogger().info(main.PREFIX + "Plugin wurde erfolgreich geladen!");
    }

}
