package com.strangesmell.thaumcraft.api.wands;

import com.strangesmell.thaumcraft.api.aspects.AspectList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public interface IWandFocus {
    int getFocusColor();

/*    IIcon getFocusDepthLayerIcon();

    IIcon getOrnament();*/

    IWandFocus.WandFocusAnimation getAnimation();

    AspectList getVisCost();

    boolean isVisCostPerTick();

    //ItemStack onFocusRightClick(ItemStack var1, Level var2, Player var3, MovingObjectPosition var4);

    void onUsingFocusTick(ItemStack var1, Player var2, int var3);

    void onPlayerStoppedUsingFocus(ItemStack var1, Level var2, Player var3, int var4);

    String getSortingHelper(ItemStack var1);

    boolean onFocusBlockStartBreak(ItemStack var1, int var2, int var3, int var4, Player var5);

    boolean acceptsEnchant(int var1);

    public static enum WandFocusAnimation {
        WAVE,
        CHARGE;

        private WandFocusAnimation() {
        }
    }
}