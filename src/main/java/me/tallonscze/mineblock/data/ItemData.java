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

    private String name;
    private ItemStack item;
    private int size;
    private String type;

    ItemData(ItemStack item, String name){
        this.item = item;
        this.size = 1;
        this.type = null;
        this.name = name;
    }
}
