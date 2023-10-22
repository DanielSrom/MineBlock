package me.tallonscze.mineblock.utility;

import me.tallonscze.mineblock.data.PlayerData;
import org.bukkit.entity.Player;

public class MoneyUtility {

    public static void sellCommand(Player player, double amount, String command){
        PlayerData data = PlayerUtility.getPlayerData(player);
        double playerMoney = data.getMoney();
        data.setMoney(playerMoney+amount);
        player.sendMessage("Provedena akce");
        PlayerUtility.setPlayerData(player, data);
    }

    public static void buyCommand(Player player, double amount, String command){
        PlayerData data = PlayerUtility.getPlayerData(player);
        double playerMoney = data.getMoney();
        if(playerMoney < amount){
            player.sendMessage("Nemáš dostatek money");
            return;
        }
        data.setMoney(playerMoney-amount);
        player.sendMessage("Provedena akce");
        PlayerUtility.setPlayerData(player, data);
    }

}
