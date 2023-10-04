package me.tallonscze.mineblock.commands;

import me.tallonscze.mineblock.Mineblock;
import me.tallonscze.mineblock.utility.OtherUtility;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawn implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player)){
            return false;
        }
        Player player = ((Player) commandSender).getPlayer();
        if(player == null){
            return false;
        }
        Location playerLocation = player.getLocation();
        OtherUtility.setSpawnLocation(playerLocation);



        return true;
    }
}
