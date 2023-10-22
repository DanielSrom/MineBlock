package me.tallonscze.mineblock.utility;

import me.tallonscze.mineblock.Mineblock;
import me.tallonscze.mineblock.data.PlayerData;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.io.File;

public class OtherUtility {

    public static Location getSpawnLocation(){
        File file = new File(Mineblock.getPlugin(Mineblock.class).getDataFolder(), "config.yml");
        if (file.exists()){
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            return new Location(Bukkit.getWorld(config.getString("spawn.world")) ,config.getDouble("spawn.x"), config.getDouble("spawn.y"), config.getDouble("spawn.z"), (float) config.getDouble("spawn.yaw"), (float) config.getDouble("spawn.pitch"));
        }
        return new Location(Bukkit.getWorld("world"), 100, 100, 100);
    }

    public static void setSpawnLocation(Location playerLocation){
        File file = new File(Mineblock.getPlugin(Mineblock.class).getDataFolder(), "config.yml");
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

    public static void createWorld(){
        WorldCreator c = new WorldCreator("MineBlock");
        c.generator(new WorldGenerator());
        c.generateStructures(false);
        c.createWorld();
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
        Score s12 = objective.getScore("Your money: "+data.getMoney());
        s12.setScore(12);
        Score s11 = objective.getScore("---------------");
        s11.setScore(11);
        Score s10 = objective.getScore("Resource: ");
        Score s9 = objective.getScore("- §6Copper: §f"+data.getCopper());
        Score s8 = objective.getScore("- Iron: §f"+data.getIron());
        Score s7 = objective.getScore("- §eGold: §f"+data.getGold());
        Score s6 = objective.getScore("- §bDiamond: §f"+data.getDiamond());
        Score s5 = objective.getScore("- §aEmerald: §f"+data.getEmerald());
        s10.setScore(10);
        s9.setScore(9);
        s8.setScore(8);
        s7.setScore(7);
        s6.setScore(6);
        s5.setScore(5);



        player.setScoreboard(scoreboard);

    }
}
