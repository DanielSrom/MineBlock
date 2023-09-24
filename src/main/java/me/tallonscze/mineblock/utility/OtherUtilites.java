package me.tallonscze.mineblock.utility;

import me.tallonscze.mineblock.MineBlock;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class OtherUtilites {

    public static Location getSpawnLocation(){
        File file = new File(MineBlock.getPlugin(MineBlock.class).getDataFolder(), "config.yml");
        if (file.exists()){
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            return new Location(Bukkit.getWorld(config.getString("spawn.world")) ,config.getDouble("spawn.x"), config.getDouble("spawn.y"), config.getDouble("spawn.z"), (float) config.getDouble("spawn.yaw"), (float) config.getDouble("spawn.pitch"));
        }
        return new Location(Bukkit.getWorld("world"), 100, 100, 100);
    }
}
