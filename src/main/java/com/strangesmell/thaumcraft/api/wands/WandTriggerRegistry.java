package com.strangesmell.thaumcraft.api.wands;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * This class serves a similar function to IWandable in that it allows wands to interact
 * with object in the world. In this case it is most useful for adding interaction with non-mod
 * blocks where you can't control what happens in their code.
 * Example where it is used is in crafting the thaumonomicon from a bookshelf and the
 * crucible from a cauldron
 * 这个类的功能与IWandable类似，因为它允许魔杖与世界上的对象进行交互。在这种情况下，它最有用的是添加与非mod块的交互
 * @author azanor
 *
 */
public class WandTriggerRegistry {

    private static HashMap<String, HashMap<List,List>> triggers = new HashMap<String,HashMap<List,List>>();
    private static final String DEFAULT = "default";

    /**
     * Registers an action to perform when a casting wand right clicks on a specific block.
     * A manager class needs to be created that implements IWandTriggerManager.
     * @param manager
     * @param event a logical number that you can use to differentiate different events or actions
     * @param block
     * @param meta send -1 as a wildcard value for all possible meta values
     * @param modid a unique identifier. It is best to register your own triggers using your mod id to avoid conflicts with mods that register triggers for the same block
     */
    public static void registerWandBlockTrigger(IWandTriggerManager manager, int event, Block block, int meta, String modid) {
        if (!triggers.containsKey(modid)) {
            triggers.put(modid, new HashMap<List,List>());
        }
        HashMap<List,List> temp = triggers.get(modid);
        temp.put(Arrays.asList(block,meta),Arrays.asList(manager,event));
        triggers.put(modid, temp);
    }

    /**
     * for legacy support
     */
    public static void registerWandBlockTrigger(IWandTriggerManager manager, int event, Block block, int meta) {
        registerWandBlockTrigger(manager, event, block, meta, DEFAULT);
    }

    /**
     * Checks all trigger registries if one exists for the given block and meta
     * @param block
     * @param meta
     * @return
     */
    public static boolean hasTrigger(Block block, int meta) {
        for (String modid:triggers.keySet()) {
            HashMap<List,List> temp = triggers.get(modid);
            if (temp.containsKey(Arrays.asList(block,meta)) ||
                    temp.containsKey(Arrays.asList(block,-1))) return true;
        }
        return false;
    }

    /**
     * modid sensitive version
     */
    public static boolean hasTrigger(Block block, int meta, String modid) {
        if (!triggers.containsKey(modid)) return false;
        HashMap<List,List> temp = triggers.get(modid);
        if (temp.containsKey(Arrays.asList(block,meta)) ||
                temp.containsKey(Arrays.asList(block,-1))) return true;
        return false;
    }


    /**
     * This is called by the onItemUseFirst function in wands.
     * Parameters and return value functions like you would expect for that function.
     */
    public static boolean performTrigger(Level world, ItemStack wand, Player player,
                                         int x, int y, int z, int side, Block block, int meta) {

        for (String modid:triggers.keySet()) {
            HashMap<List,List> temp = triggers.get(modid);
            List l = temp.get(Arrays.asList(block,meta));
            if (l==null) l = temp.get(Arrays.asList(block,-1));
            if (l==null) continue;

            IWandTriggerManager manager = (IWandTriggerManager) l.get(0);
            int event = (Integer) l.get(1);
            boolean result = manager.performTrigger(world, wand, player, x, y, z, side, event);
            if (result) return true;
        }
        return false;
    }

    /**
     * modid sensitive version
     */
    public static boolean performTrigger(Level world, ItemStack wand, Player player,
                                         int x, int y, int z, int side, Block block, int meta, String modid) {
        if (!triggers.containsKey(modid)) return false;
        HashMap<List,List> temp = triggers.get(modid);
        List l = temp.get(Arrays.asList(block,meta));
        if (l==null) l = temp.get(Arrays.asList(block,-1));
        if (l==null) return false;

        IWandTriggerManager manager = (IWandTriggerManager) l.get(0);
        int event = (Integer) l.get(1);
        return manager.performTrigger(world, wand, player, x, y, z, side, event);
    }

}