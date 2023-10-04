package me.tallonscze.mineblock.commands;

import me.tallonscze.mineblock.inventory.MainMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class OpenMainMenu implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = ((Player) sender).getPlayer();
        MainMenu menu = new MainMenu();
        player.openInventory(menu.getInventory());
        return false;
    }
}
