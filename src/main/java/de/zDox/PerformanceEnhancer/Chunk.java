package de.zDox.PerformanceEnhancer;


import java.util.Objects;

public class Chunk {
    public static int   LOWEST = 3,
                        LOW = 4,
                        MEDIUM = 6,
                        HIGH = 8,
                        EXTREME = 10;
    private final main plugin;
    public Chunk(main plugin){
        this.plugin = plugin;
    }
    public void set(int playercount, int tps, int viewdistance){
        if(viewdistance == 99){
            if(tps<=8){setViewdistance(Chunk.LOWEST);return;}
            if(tps<=12){setViewdistance(Chunk.LOW);return;}
            if(tps<=16){setViewdistance(Chunk.MEDIUM);return;}
            if(tps==20 && playercount<=2){setViewdistance(Chunk.EXTREME);return;}
            if(tps==20){setViewdistance(Chunk.HIGH);}
        }else {
            if((viewdistance<=20) && (viewdistance>=0)){
                setViewdistance(viewdistance);
            }
        }
    }

    private void setViewdistance(int chunk){
        plugin.getServer().getLogger().info(main.PREFIX + "Viewdistance neu: " + chunk + "Viewdistance alt: " + Objects.requireNonNull(plugin.getServer().getWorld("world")).getViewDistance());
        Objects.requireNonNull(plugin.getServer().getWorld("world")).setViewDistance(chunk);
    }
}
