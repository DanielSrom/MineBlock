package me.tallonscze.mineblock.commands;

import me.tallonscze.mineblock.utility.InventoryUtility;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class OpenMainMenu implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = ((Player) sender).getPlayer();
        Inventory menu = InventoryUtility.getInventory(args[0]);
        if (menu == null){
            player.sendMessage("Inventory neexistuje");
            return true;

        }

        player.openInventory(menu);
        return true;
    }
}
