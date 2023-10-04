package me.tallonscze.mineblock.utility;

import me.tallonscze.mineblock.Mineblock;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigUtility {

    private static File dataFolderPath = Mineblock.getPlugin(Mineblock.class).getDataFolder();

    public static FileConfiguration getConfig(){
        File file = new File(Mineblock.getPlugin(Mineblock.class).getDataFolder(), "config.yml");
        if(file.exists()){
            return YamlConfiguration.loadConfiguration(file);
        }else {
            return null;
        }
    }
}
