package me.tallonscze.mineblock.commands;

import me.tallonscze.mineblock.utility.IslandUtily;
import me.tallonscze.mineblock.worldEdit.WorldEditUtility;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class createIsland implements CommandExecutor {


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
        IslandUtily.playMineBLock(player);



        return true;
    }
}
