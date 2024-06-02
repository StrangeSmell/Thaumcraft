package com.strangesmell.thaumcraft.common.items.relics;

import com.strangesmell.thaumcraft.client.gui.ThaumonomiconScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemThaumonomicon extends Item {
    public int page;
    public float mouseX;
    public float mouseY;

    public ItemThaumonomicon(Properties properties ) {
        super(properties);
        page=0;
        mouseX=0;
        mouseY=0;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        if(level.isClientSide){
            opScreen();
        }
        return InteractionResultHolder.pass(itemstack);
    }

    @OnlyIn(Dist.CLIENT)
    public void opScreen(){
        ThaumonomiconScreen thaumonomiconScreen = new ThaumonomiconScreen(Component.translatable("thaumcraft.thaumonomicon_screen"),page,mouseX,mouseY,this);
        Minecraft.getInstance().setScreen(thaumonomiconScreen);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 30;
    }
}
