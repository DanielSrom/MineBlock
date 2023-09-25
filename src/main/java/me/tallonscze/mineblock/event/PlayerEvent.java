package me.tallonscze.mineblock.event;

import me.tallonscze.mineblock.MineBlock;
import me.tallonscze.mineblock.data.PlayerData;
import me.tallonscze.mineblock.utility.PlayerUtility;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class PlayerEvent implements Listener {

    private File dataFolderPath = MineBlock.getPlugin(MineBlock.class).getDataFolder();

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event){
        String playerUUID = event.getPlayer().getUniqueId().toString();

        event.getPlayer().sendMessage("Welcome...");
        PlayerData data = new PlayerData();
        File finalFile;
        File file = new File(dataFolderPath, "/players/" + playerUUID + "/stats.yml");
        if (!file.exists()) {
            File firstFolder = new File(dataFolderPath, "players");
            File targetFolder = new File(firstFolder, playerUUID);

            if (!targetFolder.exists()) {
                targetFolder.mkdirs();
            }

            File targetFile = new File(targetFolder, "stats.yml");

            try (InputStream inputStream = MineBlock.getPlugin(MineBlock.class).getResource("stats.yml")) {
                OutputStream outputStream = new FileOutputStream(targetFile);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        finalFile = new File(dataFolderPath, "/players/" + playerUUID + "/stats.yml");
        FileConfiguration stats = YamlConfiguration.loadConfiguration(finalFile);

        data.setBlock_brake(stats.getInt("stats.block_brake"));
        data.setBlock_brake_complete(stats.getInt("stats.block_brake_complete"));
        data.setLast_value(stats.getInt("stats.last_value"));
        data.setTop_value(stats.getInt("stats.top_value"));
        data.setPlayed(stats.getInt("stats.played"));
        data.setTimeStart(0);
        data.setTimeEnd(0);
        PlayerUtility.setPlayerData(event.getPlayer(), data);
        data.setActive(false);
    }


    @EventHandler
    private void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        PlayerData data = PlayerUtility.getPlayerData(player);
        String playerUUID = player.getUniqueId().toString();

        File file = new File(dataFolderPath, "/players/" + playerUUID + "/stats.yml");



        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.set("stats.block_brake", data.getBlock_brake());
        config.set("stats.block_brake_complete", data.getBlock_brake_complete());
        config.set("stats.last_value", data.getLast_value());
        config.set("stats.top_value", data.getTop_value());
        config.set("stats.played", data.getPlayed());
        try{
            config.save(file);
        }catch (Exception e){
            e.printStackTrace();
        }

        PlayerUtility.setPlayerData(player, null);
        Bukkit.getLogger().info(player.getName() + " se právě odpojil..");
    }

    @EventHandler
    public void playerBrakeBlock(BlockBreakEvent event){
        Player player = event.getPlayer();
        PlayerData data = PlayerUtility.getPlayerData(player);
        if (!data.isActive() && !player.hasPermission("mineblock.canbuild")){
            event.setCancelled(true);
            return;
        }
        int current_value = data.getLast_value();
        int block_brake = data.getBlock_brake();
        int block_value = 0;

        if (event.getBlock().getType().toString().equalsIgnoreCase("stone")){
            block_value = 1;
        }
        data.setLast_value(current_value+block_value);
        data.setBlock_brake(block_brake+1);
        PlayerUtility.setPlayerData(player, data);
    }
}


