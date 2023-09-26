package me.tallonscze.mineblock.commands;

import me.tallonscze.mineblock.MineBlock;
import me.tallonscze.mineblock.utility.OtherUtilites;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

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
        OtherUtilites.setSpawnLocation(playerLocation);



        return true;
    }
}
