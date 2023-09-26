package me.tallonscze.mineblock.utility;

import me.tallonscze.mineblock.MineBlock;
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
            return new Location(Bukkit.getWorld(config.getString("Spawn.world")) ,config.getDouble("Spawn.x"), config.getDouble("Spawn.y"), config.getDouble("Spawn.z"), (float) config.getDouble("Spawn.yaw"), (float) config.getDouble("Spawn.pitch"));
        }
        return new Location(Bukkit.getWorld("world"), 100, 100, 100);
    }

    public static void showSideBar(Player player, String message){
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("ActionBar", Criteria.DUMMY, Component.text(message));

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = objective.getScore(message);
        score.setScore(1);

        player.setScoreboard(scoreboard);

    }
}
