package com.strangesmell.thaumcraft.api.research;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public interface IScanEventHandler {
    ScanResult scanPhenomena(ItemStack stack, Level world, Player player);
}
