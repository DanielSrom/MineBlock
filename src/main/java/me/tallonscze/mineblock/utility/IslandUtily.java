package me.tallonscze.mineblock.utility;

import me.tallonscze.mineblock.MineBlock;
import me.tallonscze.mineblock.data.PlayerData;
import me.tallonscze.mineblock.worldEdit.WorldEditUtility;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class IslandUtily {
    private static int timeToFinish = 20*ConfigUtility.getConfig().getInt("game.time");
    public static void createIsland(Player player){
        PlayerData data = PlayerUtility.getPlayerData(player);
        data.setActive(true);
        data.setLast_value(0);
        int xCordsFinal = 100 * WorldEditUtility.activeIland;
        WorldEditUtility.pasteSchematic(xCordsFinal, 100, 100);
        WorldEditUtility.activeIland++;
        Location locationIsland = new Location(Bukkit.getWorld("world"), xCordsFinal, 102, 100);
        player.teleport(locationIsland);
        player.setBedSpawnLocation(locationIsland);
    }

    public static void deleteIsland(Player player){
        PlayerData data = PlayerUtility.getPlayerData(player);
        if (data.getLast_value() > data.getTop_value()) {
            data.setTop_value(data.getLast_value());
        }
        PlayerUtility.setPlayerData(player, data);
        player.teleport(OtherUtilites.getSpawnLocation());
        data.setActive(false);
        WorldEditUtility.activeIland--;
    }

    public static void playMineBLock(Player player) {
        createIsland(player);
        TimerUtils.setPlayerStartTime(player);
        TimerUtils.getCurrentTime(player, timeToFinish* 1000L);
        new BukkitRunnable(){
            @Override
            public void run(){
                player.sendMessage("Aktuální čas je: " + TimerUtils.getCurrentTime(player, timeToFinish* 1000L));
            }
        }.runTaskTimer(MineBlock.getPlugin(MineBlock.class), timeToFinish, 1);
        deleteIsland(player);
    }
}
