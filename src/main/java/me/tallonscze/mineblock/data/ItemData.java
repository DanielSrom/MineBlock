package me.tallonscze.mineblock.data;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemData {

    private ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommand() {
        return command;
    }
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setCommand(String command) {
        this.command = command;
    }
    public String getName() {
        return name;
    }

    public ItemStack getItemStack(){
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text(name));
        item.setItemMeta(meta);
        item.setAmount(getSize());
        return item;
    }

    public void setName(String name) {
        this.name = name;
    }




    private double cost;
    private String command;
    private String name;
    private ItemStack item;
    private int size;
    private String type;

    ItemData(ItemStack item, String name, String Command, double cost){
        this.item = item;
        this.size = 1;
        this.type = null;
        this.name = name;
        this.command = Command;
        this.cost = cost;
    }

    public boolean isEqual(ItemStack itemStack){
        return getItemStack().equals(itemStack);
    }
}
