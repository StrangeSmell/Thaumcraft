package com.strangesmell.thaumcraft.api.wands;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public interface IWandTriggerManager {

    /**
     * This class will be called by wands with the proper parameters. It is up to you to decide what to do with them.
     */
    public boolean performTrigger(Level world, ItemStack wand, Player player,
                                  int x, int y, int z, int side, int event);

}
