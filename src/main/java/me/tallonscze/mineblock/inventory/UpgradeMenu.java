package me.tallonscze.mineblock.inventory;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.awt.*;

public class UpgradeMenu {

    public static Inventory createMenu() {
        Inventory mainMenu = Bukkit.createInventory(null, 9, Component.text("Test"));
        return mainMenu;
    }
}
