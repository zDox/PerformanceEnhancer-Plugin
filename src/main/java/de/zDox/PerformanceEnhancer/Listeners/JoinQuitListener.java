package de.zDox.PerformanceEnhancer.Listeners;

import de.zDox.PerformanceEnhancer.Chunk;
import de.zDox.PerformanceEnhancer.main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class JoinQuitListener implements Listener {
    private final main plugin;
    public JoinQuitListener(main plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void JoinListener(PlayerJoinEvent e){
        double [] tps = plugin.getServer().getTPS();
        Chunk chunk = new Chunk(plugin);
        chunk.set(plugin.getServer().getOnlinePlayers().size(), (int) tps[0], 99);
    }
    @EventHandler
    public void QuitListener(PlayerQuitEvent e){
        double [] tps = plugin.getServer().getTPS();
        Chunk chunk = new Chunk(plugin);
        chunk.set(plugin.getServer().getOnlinePlayers().size(), (int) tps[0], 99);
    }
}
