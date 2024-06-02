package com.strangesmell.thaumcraft.client.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import com.strangesmell.thaumcraft.Thaumcraft;
import com.strangesmell.thaumcraft.api.ThaumcraftApi;
import com.strangesmell.thaumcraft.api.aspects.Aspect;
import com.strangesmell.thaumcraft.api.aspects.AspectList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.client.gui.overlay.ForgeGui;

import static com.strangesmell.thaumcraft.api.research.ScanManager.isObjectsBeScanned;
import static com.strangesmell.thaumcraft.common.config.ConfigGui.BookBackGroundId;
import static com.strangesmell.thaumcraft.common.config.ConfigGui.BookGuiResourceLocation;

public class ScanHud extends ForgeGui {

    public ScanHud(Minecraft minecraft) {
        super(minecraft);
    }
    public void render(GuiGraphics guiGraphics, float partialTick)
    {
/*        HitResult hitResult = ThaumcraftApi.getHitResult(Minecraft.getInstance().level,Minecraft.getInstance().player );

        if (hitResult instanceof BlockHitResult blockHitResult){
            if(!isObjectsBeScanned(Minecraft.getInstance().player,Minecraft.getInstance().level.getBlockState(blockHitResult.getBlockPos()).getBlock().getName().getString() )) return;
            AspectList aspects = AspectList.getObjectAspects(new ItemStack(Minecraft.getInstance().level.getBlockState(blockHitResult.getBlockPos()).getBlock()));
            int size = aspects.size()-1;
            for(int i = 0; i<aspects.size();i++){
                Aspect aspect = aspects.getAspects()[i];
                RenderSystem.enableBlend();
                RenderSystem.setShaderColor(aspect.getRed(),aspect.getGreen(),aspect.getBlue(),0.5f);
                guiGraphics.blit(aspect.getImage(),guiGraphics.guiWidth()/2 - 16 - size*16 + i*32,guiGraphics.guiHeight()/2-16,32,32,0,0,32,32,32,32);
                guiGraphics.drawString(this.getFont(),String.valueOf(aspects.getAmount(aspect)),guiGraphics.guiWidth()/2 + 11 - size*16 + i*32,guiGraphics.guiHeight()/2+11,0xFFF000);
                RenderSystem.disableBlend();
            }
        }*/

    }
}
