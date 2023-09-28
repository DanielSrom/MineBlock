package me.tallonscze.mineblock.inventory;

import jdk.tools.jmod.Main;
import me.tallonscze.mineblock.MineBlock;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class MainMenu implements InventoryHolder {

    private final Inventory inventory;

    public MainMenu(MineBlock plugin){
        this.inventory = plugin.getServer().createInventory(this, 9);
    }

    @Override
    public Inventory getInventory(){
        return this.inventory;
    }
}
