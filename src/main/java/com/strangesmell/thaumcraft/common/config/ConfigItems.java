package com.strangesmell.thaumcraft.common.config;

import com.strangesmell.thaumcraft.common.items.ItemResearchNotes;
import com.strangesmell.thaumcraft.common.items.relics.ItemThaumometer;
import com.strangesmell.thaumcraft.common.items.relics.ItemThaumonomicon;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;

import static com.strangesmell.thaumcraft.Thaumcraft.MODID;

public class ConfigItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> itemThaumonomicon =ITEMS.register("item_thaumonomicon",()->new ItemThaumonomicon(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> itemThaumometer =ITEMS.register("item_thaumometer",()->new ItemThaumometer(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> itemResearchNotes =ITEMS.register("item_researchnotes",()->new ItemResearchNotes(new Item.Properties().stacksTo(1)));





    public ConfigItems() {
    }
    public static void postInit() {
        //利用矿物词典来动态初始化某些矿物
/*        if (Config.foundCopperIngot) {
            WAND_CAP_COPPER = new WandCap("copper", 1.1F, Arrays.asList(Aspect.ORDER, Aspect.ENTROPY), 1.0F, new ItemStack(itemWandCap, 1, 3), 2);
        }

        if (Config.foundSilverIngot) {
            WAND_CAP_SILVER = new WandCap("silver", 1.0F, Arrays.asList(Aspect.AIR, Aspect.EARTH, Aspect.FIRE, Aspect.WATER), 0.95F, new ItemStack(itemWandCap, 1, 4), 4);
        }*/

    }



}
