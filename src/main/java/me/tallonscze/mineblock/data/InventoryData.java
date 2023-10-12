package me.tallonscze.mineblock.data;

import me.tallonscze.mineblock.Mineblock;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class InventoryData {

    private final Inventory inventory;
    private final File pathToInventoryItem;
    private final FileConfiguration menuConfig;
    private final String id;
    private final boolean cancelClick = true;

    private Map<Integer, ItemStack>items = new HashMap<>();
    public InventoryData(String name){

        pathToInventoryItem = new File(Mineblock.getPlugin(Mineblock.class).getDataFolder() + "/inventories/" + name);
        menuConfig = YamlConfiguration.loadConfiguration(pathToInventoryItem);
        inventory = Bukkit.createInventory(null, menuConfig.getInt("info.size"), Component.text(menuConfig.getString("info.name").replace("&", "§")));
        loadItemFromFile();
        loadToInventory();
        id = menuConfig.getString("info.id", menuConfig.getString("info.name"));
    }

    public void loadItemFromFile(){
        ConfigurationSection itemSection = menuConfig.getConfigurationSection("item");
        if(itemSection != null){
            for(String key : itemSection.getKeys(false)){
                ConfigurationSection itemConfig = itemSection.getConfigurationSection(key);
                String type = itemConfig.getString("type");
                String name = itemConfig.getString("name");
                int count = itemConfig.getInt("count");
                int slot = itemConfig.getInt("slot");
                String id = itemConfig.getString("id", "minecraft:stone").toUpperCase();
                Material itemMate = Material.getMaterial(id);
                if (itemMate == null){
                    System.out.println("itemMete je null");
                    continue;
                }
                ItemStack item = new ItemStack(itemMate);
                ItemMeta itemMeta = item.getItemMeta();
                itemMeta.displayName(Component.text(name));
                item.setAmount(count);
                item.setItemMeta(itemMeta);
                if (!items.containsKey(slot)){
                    items.put(slot, item);
                }
                System.out.println(itemMate);
            }
        }
    }

    public String getId(){
        return this.id;
    }

    public void loadToInventory(){
        items.forEach(inventory::setItem);
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public void setItem(ItemStack item, int position){
        inventory.setItem(position, item);
    }
    public boolean isCancelClick() {
        return cancelClick;
    }
}
