package com.strangesmell.thaumcraft.api;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 *
 * @author Azanor
 *
 * Armor, held items or bauble slot items that implement this interface add warp when equipped or held.
 *当装备或持有时，实现该界面的盔甲、持有物品或小玩意槽物品会增加扭曲。
 */

public interface IWarpingGear {

    /**
     * returns how much warp this item adds while worn or held.
     */
    public int getWarp(ItemStack itemstack, Player player);


}
