package com.strangesmell.thaumcraft.api.internal;

import com.strangesmell.thaumcraft.api.aspects.Aspect;
import com.strangesmell.thaumcraft.api.aspects.AspectList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public interface IInternalMethodHandler {

    public void generateVisEffect(int dim, int x, int y, int z, int x2, int y2, int z2, int color);
    public boolean isResearchComplete(String username, String researchkey);
    public ItemStack getStackInRowAndColumn(Object instance, int row, int column);
    public AspectList getObjectAspects(ItemStack is);
    public AspectList getBonusObjectTags(ItemStack is, AspectList ot);
    public AspectList generateTags(Item item, int meta);
    public boolean consumeVisFromWand(ItemStack wand, Player player, AspectList cost, boolean doit, boolean crafting);
    public boolean consumeVisFromWandCrafting(ItemStack wand,Player player, AspectList cost, boolean doit);
    public boolean consumeVisFromInventory(Player player, AspectList cost);
    public void addWarpToPlayer(Player player, int amount,boolean temporary);
    public void addStickyWarpToPlayer(Player player, int amount);
    public boolean hasDiscoveredAspect(String username, Aspect aspect);
    public AspectList getDiscoveredAspects(String username);

}
