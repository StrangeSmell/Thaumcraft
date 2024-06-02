package com.strangesmell.thaumcraft.api.wands;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 *
 * @author azanor
 *
 * Implemented by a class that you wish to be called whenever a wand with this rod performs its
 * update tick.
 *
 */
public interface IWandRodOnUpdate {
    void onUpdate(ItemStack itemstack, Player player);
}
