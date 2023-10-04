package me.tallonscze.mineblock.utility;

import me.tallonscze.mineblock.Mineblock;
import me.tallonscze.mineblock.data.PlayerData;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerUtility {

    public static void setPlayerStartTime(Player player){
        PlayerData data = PlayerUtility.getPlayerData(player);
        data.setTimeStart(System.currentTimeMillis());
    }

    public static void setPlayerStopTime(Player player){
        PlayerData data = PlayerUtility.getPlayerData(player);
        data.setTimeEnd(System.currentTimeMillis());
    }

    public static long getFinishTime(Player player){
        PlayerData data = PlayerUtility.getPlayerData(player);
        return data.getTimeEnd()-data.getTimeStart();
    }

    public static long getCurrentTime(Player player, long timer){
        PlayerData data = PlayerUtility.getPlayerData(player);
        return (System.currentTimeMillis()+timer)-data.getTimeStart();
    }

    public static void Timer(int startTime, Player player){
        new BukkitRunnable(){
            int time = startTime;
            @Override
            public void run(){
                if (time >0){
                    player.sendActionBar(Component.text("Do konce zbývá: " + time + " sekund."));
                    time--;
                }else{
                    this.cancel();
                    player.sendMessage("Čas Vyprešel");
                    IslandUtility.deleteIsland(player);
                }
            }
        }.runTaskTimer(Mineblock.getPlugin(Mineblock.class), 0, 20);
    }

    public static void timerToScoreboard(Player player){
        int refreshTime = ConfigUtility.getConfig().getInt("global.time_to_refresh_scoreboard");
        if (refreshTime == 0){

            System.out.println("[MineBlock] Time to refresh is not set!");
            return;
        }
        new BukkitRunnable(){
            @Override
            public void run(){
                if(!player.isOnline()){
                    this.cancel();
                }
                OtherUtility.showSideBar(player);
            }

        }.runTaskTimer(Mineblock.getPlugin(Mineblock.class), 0, refreshTime*20);
    }
}
