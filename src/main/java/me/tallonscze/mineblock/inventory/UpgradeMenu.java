package me.tallonscze.mineblock.inventory;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.awt.*;

public class UpgradeMenu {

    public void createMenu() {
        Inventory mainMenu = Bukkit.createInventory(null, 54, Component.text("TestMenu"));
    }
}
