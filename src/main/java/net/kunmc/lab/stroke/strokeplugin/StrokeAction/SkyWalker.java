package net.kunmc.lab.stroke.strokeplugin.StrokeAction;

import net.kunmc.lab.stroke.strokeplugin.StrokePlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class SkyWalker implements Listener{
    private Player player;
    private int r = 2;//半径

    public void skywall(Player player,String stroke){
        player.sendTitle("You can walk on the sky!!", ChatColor.AQUA +stroke,0,10,0);


        BukkitRunnable task = new BukkitRunnable() {
            int count = 0;
            public void run() {
                Location startLoc = player.getLocation().subtract(r, r, r);

                for (int i = startLoc.getBlockX(); i < startLoc.getBlockX() + r * 2; i++) {
                    for (int k = startLoc.getBlockZ(); k < startLoc.getBlockZ() + r * 2; k++) {
                        Location loc = new Location(startLoc.getWorld(), i, startLoc.getBlockY() + 1, k);
                        Block b = loc.getBlock();

                        if (b.getType() == Material.AIR) {
                            b.setType(Material.CYAN_STAINED_GLASS);

                            BukkitRunnable task3 = new BukkitRunnable() {
                                public void run() {
                                    b.setType(Material.AIR);
                                    cancel();
                                }
                            };
                            task3.runTaskTimer(StrokePlugin.getPlugin(), 60L, 0L);
                        }
                    }
                }
                if(count > 200){
                    cancel();
                }
                count++;
            }
        };
        task.runTaskTimer(StrokePlugin.getPlugin(), 0L,1L);
    }
}