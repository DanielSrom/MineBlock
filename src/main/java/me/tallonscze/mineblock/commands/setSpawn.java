package me.tallonscze.mineblock.commands;

import me.tallonscze.mineblock.MineBlock;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class setSpawn implements CommandExecutor {

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
        File file = new File(MineBlock.getPlugin(MineBlock.class).getDataFolder(), "config.yml");
        if (file.exists()){
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            config.set("spawn.x", playerLocation.getX());
            config.set("spawn.y", playerLocation.getY());
            config.set("spawn.z", playerLocation.getZ());
            config.set("spawn.world", playerLocation.getWorld().getName());
            config.set("spawn.pitch", playerLocation.getPitch());
            config.set("spawn.yaw", playerLocation.getYaw());
            try{
                config.save(file);
            }catch (Exception e){
                e.printStackTrace();
            }
        }



        return true;
    }
}
