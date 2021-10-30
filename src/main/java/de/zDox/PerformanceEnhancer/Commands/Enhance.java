package de.zDox.PerformanceEnhancer.Commands;

import de.zDox.PerformanceEnhancer.Chunk;
import de.zDox.PerformanceEnhancer.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public class Enhance implements CommandExecutor {
    private final main plugin;
    public Enhance(main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(commandSender instanceof Player p){
            double [] tps = plugin.getServer().getTPS();
            Chunk chunk = new Chunk(plugin);
            if(args.length == 1){
                try {
                    int viewdistance = Integer.parseInt(args[0]);
                    if(Objects.requireNonNull(plugin.getServer().getWorld("world")).getViewDistance() != viewdistance){
                        chunk.set(plugin.getServer().getOnlinePlayers().size(), (int) tps[0], viewdistance);
                    }
                }catch (NumberFormatException exception){
                    chunk.set(plugin.getServer().getOnlinePlayers().size(), (int) tps[0], 99);
                }
            }else {
                chunk.set(plugin.getServer().getOnlinePlayers().size(), (int) tps[0], 99);
            }
            p.sendMessage(main.PREFIX + "View Distance erfolgreich geupdatet");
            return true;
        }
        return false;
    }
}
