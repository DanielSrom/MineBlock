package me.tallonscze.mineblock.commands;

import me.tallonscze.mineblock.utility.IslandUtility;
import me.tallonscze.mineblock.utility.WorldEditUtility;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CreateIsland implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("This command can by send only by Player");
            return true;
        }
        Player player = ((Player) commandSender).getPlayer();
        if (player == null){
            return false;
        }
        //IslandUtily.createIsland(player);
        player.sendMessage("Momentální počet ostrovů je:" + WorldEditUtility.activeIland);
        IslandUtility.playMineBLock(player);




        return true;
    }
}
