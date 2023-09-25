package me.tallonscze.mineblock.utility;

import me.tallonscze.mineblock.MineBlock;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigUtility {

    private static File dataFolderPath = MineBlock.getPlugin(MineBlock.class).getDataFolder();

    public static FileConfiguration getConfig(){
        File file = new File(MineBlock.getPlugin(MineBlock.class).getDataFolder(), "config.yml");
        String nameSchematic;
        if(file.exists()){
            return YamlConfiguration.loadConfiguration(file);
        }else {
            return null;
        }
    }
}
