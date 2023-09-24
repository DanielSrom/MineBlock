package me.tallonscze.mineblock;

import me.tallonscze.mineblock.commands.createIsland;
import me.tallonscze.mineblock.commands.setSpawn;
import me.tallonscze.mineblock.commands.spawn;
import me.tallonscze.mineblock.event.PlayerEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class MineBlock extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerEvent(), this);

        if(!getDataFolder().exists()){
            getDataFolder().mkdirs();
        }

        File playerFile = new File(getDataFolder(), "players");

        if(!playerFile.exists()){
            playerFile.mkdirs();
        }

        File schemFile = new File(getDataFolder(), "schematic");

        if(!schemFile.exists()){
            schemFile.mkdirs();
        }

        File config = new File(getDataFolder(), "config.yml");
        if(!config.exists()){
            saveResource("config.yml", false);
        }

        getCommand("play").setExecutor(new createIsland());
        getCommand("spawn").setExecutor(new spawn());
        getCommand("setspawn").setExecutor(new setSpawn());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
