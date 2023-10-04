package me.tallonscze.mineblock.inventory;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class MainMenu {

    private final Inventory inventory;

    public MainMenu() {
        this.inventory = Bukkit.createInventory(null, 27);
    }

    public Inventory getInventory(){
        return this.inventory;
    }
}
