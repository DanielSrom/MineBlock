package me.tallonscze.mineblock.commands;

import me.tallonscze.mineblock.data.PlayerData;
import me.tallonscze.mineblock.utility.PlayerUtility;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AddResource implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if ((sender instanceof Player)){
            sender.sendMessage("This command can by send only by Console");
            return true;
        }
        String playerName = args[0];
        String resource = args[1];
        double value = Double.parseDouble(args[2]);

        Player player = Bukkit.getPlayer(playerName);
        PlayerData pData = PlayerUtility.getPlayerData(player);
        switch (resource) {
            case "copper" -> pData.setCopper(pData.getCopper()+value);
            case "iron" -> pData.setIron(pData.getIron()+value);
            case "gold" -> pData.setGold(pData.getGold()+value);
            case "diamond" -> pData.setDiamond(pData.getDiamond()+value);
            case "emerald" -> pData.setEmerald(pData.getEmerald()+value);
        }
        PlayerUtility.setPlayerData(player, pData);

        return false;
    }
}
