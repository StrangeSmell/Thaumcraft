package com.strangesmell.thaumcraft.api;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemRunic extends Item implements IRunicArmor  {

    int charge;

    public ItemRunic (int charge)
    {
        super(new Properties());
        this.charge = charge;
    }

    @Override
    public int getRunicCharge(ItemStack itemstack) {
        return charge;
    }

}
