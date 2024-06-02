package com.strangesmell.thaumcraft.api.wands;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 *
 * @author azanor
 * Add this to a tile entity that you wish wands to interact with in some way.
 */

/**
 * BlockEntity实现这个接口，实现法杖互交
*/
public interface IWandable {

    public int onWandRightClick(Level world, ItemStack wandstack, Player player, int x, int y, int z, int side, int md);

    public ItemStack onWandRightClick(Level world, ItemStack wandstack, Player player);

    public void onUsingWandTick(ItemStack wandstack, Player player, int count);

    public void onWandStoppedUsing(ItemStack wandstack, Level world, Player player, int count);

}