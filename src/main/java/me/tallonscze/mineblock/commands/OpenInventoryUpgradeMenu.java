package me.tallonscze.mineblock.commands;

import me.tallonscze.mineblock.MineBlock;
import me.tallonscze.mineblock.inventory.MainMenu;
import me.tallonscze.mineblock.inventory.UpgradeMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class OpenInventoryUpgradeMenu implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = ((Player) commandSender).getPlayer();

        try{
            MainMenu inv = new MainMenu(MineBlock.getPlugin(MineBlock.class));
            player.openInventory(inv.getInventory());
        }catch (Exception e){
            e.printStackTrace();
        }

        /*
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("Tento příkaz může použít pouze hráč!");
            return true;
        }

        Player player = ((Player) commandSender).getPlayer();
        if(player == null){
            return false;
        }
        Inventory newInventory = UpgradeMenu.createMenu();
        if (newInventory == null){
            player.sendMessage("Jsi vedle...");
            return true;
        }
        player.closeInventory();
        player.openInventory(newInventory);
        return true;

         */
        System.out.println("Test");
        return true;
    }
}
