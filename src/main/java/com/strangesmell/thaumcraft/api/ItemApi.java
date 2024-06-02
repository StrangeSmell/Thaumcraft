package com.strangesmell.thaumcraft.api;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

/**
 * @author Azanor
 *
 * This is used to gain access to the items in my mod.
 * I only give some examples and it will probably still
 * require a bit of work for you to get hold of everything you need.
 *
 */
public class ItemApi {


    public static ItemStack getItem(String itemString, int meta) {
        ItemStack item = null;

        try {
            String itemClass = "thaumcraft.common.config.ConfigItems";
            Object obj = Class.forName(itemClass).getField(itemString).get(null);
            if (obj instanceof Item) {
                //meta在低版本是什么意思,类似栏杆有不同状态
                //???
                item = new ItemStack((Item) obj,1);
                //item = new ItemStack((Item) obj,1,meta);
            } else if (obj instanceof ItemStack) {
                item = (ItemStack) obj;
            }
        } catch (Exception ex) {
            //FMLLog.warning("[Thaumcraft] Could not retrieve item identified by: " + itemString);
        }

        return item;
    }

    public static ItemStack getBlock(String itemString, int meta) {
        ItemStack item = null;

        try {
            String itemClass = "thaumcraft.common.config.ConfigBlocks";
            Object obj = Class.forName(itemClass).getField(itemString).get(null);
            if (obj instanceof Block) {
                item = new ItemStack((Block) obj,1);
                //item = new ItemStack((Block) obj,1,meta);
            } else if (obj instanceof ItemStack) {
                item = (ItemStack) obj;
            }
        } catch (Exception ex) {
            //FMLLog.warning("[Thaumcraft] Could not retrieve block identified by: " + itemString);
        }

        return item;
    }

    /**
     * 铸造棒：
     * 项目WandCasting
     *
     * 资源：
     * itemEssence，itemWispEssence，itemResource，itemShard，itemNugget，
     * 项目掘金鸡肉，项目掘金牛肉，项目掘金功，项目三重肉
     *
     *
     * 研究
     * itemResearchNotes，itemInkwell，itemThaumonomicon
     * */


    /**
     *
     * Some examples
     *
     * Casting Wands:
     * itemWandCasting
     *
     * Resources:
     * itemEssence, itemWispEssence, itemResource, itemShard, itemNugget,
     * itemNuggetChicken, itemNuggetBeef, itemNuggetPork, itemTripleMeatTreat
     *
     * Research:
     * itemResearchNotes, itemInkwell, itemThaumonomicon
     *
     */
}
