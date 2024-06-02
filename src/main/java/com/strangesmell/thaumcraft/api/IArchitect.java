package com.strangesmell.thaumcraft.api;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;

public interface IArchitect {

    /**
     * Returns a list of blocks that should be highlighted in world.
     */
    public ArrayList<BlockCoordinates> getArchitectBlocks(ItemStack stack, Level world,
                                                          int x, int y, int z, int side, Player player);

    /**
     * which axis should be displayed.
     */
    public boolean showAxis(ItemStack stack, Level world, Player player, int side, EnumAxis axis);

    public enum EnumAxis {
        X, // east / west
        Y, // up / down
        Z; // north / south
    }
}
