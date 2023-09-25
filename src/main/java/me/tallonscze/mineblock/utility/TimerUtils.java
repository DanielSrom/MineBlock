package me.tallonscze.mineblock.utility;

import me.tallonscze.mineblock.data.PlayerData;
import org.bukkit.entity.Player;

public class TimerUtils {

    public void createTimer(Player player){
        PlayerData data = PlayerUtility.getPlayerData(player);
        data.setTimeStart(System.currentTimeMillis());
    }

    public void stopTimer(){

    }
}
