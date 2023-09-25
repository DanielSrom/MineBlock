package me.tallonscze.mineblock.utility;

import me.tallonscze.mineblock.data.PlayerData;
import org.bukkit.entity.Player;

public class TimerUtils {

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

    public static long getCurrentTime(Player player){
        PlayerData data = PlayerUtility.getPlayerData(player);
        return System.currentTimeMillis()-data.getTimeStart();
    }
}
