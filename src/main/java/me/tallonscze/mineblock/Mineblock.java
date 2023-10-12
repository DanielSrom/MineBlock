package me.tallonscze.mineblock;

import me.tallonscze.mineblock.commands.CreateIsland;
import me.tallonscze.mineblock.commands.OpenMainMenu;
import me.tallonscze.mineblock.commands.SetSpawn;
import me.tallonscze.mineblock.commands.Spawn;
import me.tallonscze.mineblock.event.IslandEvent;
import me.tallonscze.mineblock.event.PlayerEvent;
import me.tallonscze.mineblock.utility.ConfigUtility;
import me.tallonscze.mineblock.utility.InventoryUtility;
import me.tallonscze.mineblock.utility.OtherUtility;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class Mineblock extends JavaPlugin {

    @Override
    public void onEnable() {

        int configVersion = 3;

        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerEvent(), this);
        getServer().getPluginManager().registerEvents(new IslandEvent(), this);

        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        File inventoryFile = new File(getDataFolder(), "inventories");

        if (!inventoryFile.exists()) {
            inventoryFile.mkdirs();
            File exampleInventory = new File(inventoryFile, "/exampleInventory.yml");
            try (InputStream inputStream = Mineblock.getPlugin(Mineblock.class).getResource("exampleInventory.yml")) {
                OutputStream outputStream = new FileOutputStream(exampleInventory);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        File playerFile = new File(getDataFolder(), "players");

        if (!playerFile.exists()) {
            playerFile.mkdirs();
        }

        File schemFile = new File(getDataFolder(), "schematic");

        if (!schemFile.exists()) {
            schemFile.mkdirs();
        }

        File config = new File(getDataFolder(), "config.yml");
        if (!config.exists()) {
            saveResource("config.yml", false);
        } else if (ConfigUtility.getConfig().getInt("global.version") != configVersion) {
            config.delete();
            saveResource("config.yml", false);
        }
        Location spawnLocation = getServer().getWorld("world").getSpawnLocation();
        if (spawnLocation != null && ConfigUtility.getConfig().getBoolean("global.spawnset") != true) {
            OtherUtility.setSpawnLocation(spawnLocation);
            ConfigUtility.getConfig().set("global.spawnset", true);
        }
        System.out.println(Bukkit.getWorld("MineBlock"));
        if(Bukkit.getWorld("MineBlock") == null){
            OtherUtility.createWorld();

            System.out.println("Vytvářím svět");
        }


        getCommand("play").setExecutor(new CreateIsland());
        getCommand("spawn").setExecutor(new Spawn());
        getCommand("setspawn").setExecutor(new SetSpawn());
        getCommand("menu").setExecutor(new OpenMainMenu());

        InventoryUtility.loadAllInventories();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
