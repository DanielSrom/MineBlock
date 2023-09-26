package me.tallonscze.mineblock.utility;

import me.tallonscze.mineblock.MineBlock;
import me.tallonscze.mineblock.data.PlayerData;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

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

    public static void setSpawnLocation(Location playerLocation){
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
    }

    public static void showSideBar(Player player){
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("SideBar", Criteria.DUMMY, Component.text("§4§lBurning§f§lCube Network"));

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = objective.getScore("---------------");
        score.setScore(15);
        Score s14 = objective.getScore("Your Name: "+player.getName());
        s14.setScore(14);
        PlayerData data = PlayerUtility.getPlayerData(player);
        Score s13 = objective.getScore("You played: "+data.getPlayed());
        s13.setScore(13);
        player.setScoreboard(scoreboard);

    }
}
