package com.strangesmell.thaumcraft.api.internal;

import net.minecraft.util.random.WeightedRandom;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;

public class WeightedRandomLoot  {
    /** The Item/Block ID to generate in the bag. */
    public ItemStack item;
/*extends WeightedRandom
    public WeightedRandomLoot(ItemStack stack, int weight)
    {
        super(weight);
        this.item = stack;
    }*/

    public static ArrayList<WeightedRandomLoot> lootBagCommon = new ArrayList<WeightedRandomLoot>();
    public static ArrayList<WeightedRandomLoot> lootBagUncommon = new ArrayList<WeightedRandomLoot>();
    public static ArrayList<WeightedRandomLoot> lootBagRare = new ArrayList<WeightedRandomLoot>();

}
