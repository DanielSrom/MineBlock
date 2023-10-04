package me.tallonscze.mineblock.utility;

import me.tallonscze.mineblock.data.PlayerData;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;


public class PlayerUtility {


    private static Map<String, PlayerData> playerData = new HashMap<>();

    public static PlayerData getPlayerData(Player player){
        if(!playerData.containsKey(player.getUniqueId().toString())){
            PlayerData m = new PlayerData();
            playerData.put(player.getUniqueId().toString(), m);
            return m;
        }
        return playerData.get(player.getUniqueId().toString());
    }

    public static void setPlayerData(Player player, PlayerData data){
        if(data == null){
            playerData.remove(player.getUniqueId().toString());
        }else{
            playerData.put(player.getUniqueId().toString(), data);
        }

    }
}
