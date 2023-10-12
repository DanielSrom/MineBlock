package me.tallonscze.mineblock.utility;


import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import me.tallonscze.mineblock.Mineblock;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileInputStream;

public class WorldEditUtility{

    public static int activeIland = 0;

    private static File dataFolderPath = Mineblock.getPlugin(Mineblock.class).getDataFolder();

    private static Clipboard loadSchematic(){
        File file = new File(Mineblock.getPlugin(Mineblock.class).getDataFolder(), "config.yml");
        String nameSchematic;
        if(file.exists()){
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            nameSchematic = config.getString("schematic.name");
        }else {
            nameSchematic = null;
        }

        Clipboard clipboard;
        File schemFile = new File(dataFolderPath, "schematic");
        File fileSchem = new File(schemFile, nameSchematic+".schem");
        if(fileSchem.exists()){
            ClipboardFormat format = ClipboardFormats.findByFile(fileSchem);
            try(ClipboardReader reader = format.getReader(new FileInputStream(fileSchem))){
                clipboard = reader.read();
                return clipboard;
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        return null;


    }

    public static void pasteSchematic(double x, double y, double z){
        Clipboard schem = loadSchematic();
        if (schem == null){
            return;
        }

        World world = Bukkit.getWorld("MineBlock");
        com.sk89q.worldedit.bukkit.BukkitWorld worldBukkit = (BukkitWorld) BukkitAdapter.adapt(world);

        try(EditSession editSession = WorldEdit.getInstance().newEditSessionBuilder().world(worldBukkit).build()){
            Operation operation = new ClipboardHolder(schem)
                    .createPaste(editSession)
                    .to(BlockVector3.at(x, y , z))
                    .build();
            Operations.complete(operation);
        }

    }

}
