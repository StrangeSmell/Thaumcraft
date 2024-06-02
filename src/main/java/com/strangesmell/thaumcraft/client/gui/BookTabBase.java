package com.strangesmell.thaumcraft.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class BookTabBase extends Button {
    protected final ResourceLocation resourceLocation;
    public int xTexStart;
    public int yTexStart;
    protected final int yDiffTex;
    protected final int textureWidth;
    protected final int textureHeight;
    protected final  ResourceLocation icon;
    public boolean isDisplay=false;
    private int iconSize ;
    public BookTabBase(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, ResourceLocation icon,int size, ResourceLocation pResourceLocation, Button.OnPress pOnPress) {
        this(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pHeight,  icon, size,pResourceLocation, 256, 256, pOnPress);
    }

    public BookTabBase(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, ResourceLocation icon,int size, ResourceLocation pResourceLocation, Button.OnPress pOnPress) {
        this(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex,icon,size, pResourceLocation, 256, 256, pOnPress);
    }

    public BookTabBase(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex, ResourceLocation icon,int size, ResourceLocation pResourceLocation, int pTextureWidth, int pTextureHeight, Button.OnPress pOnPress) {
        this(pX, pY, pWidth, pHeight, pXTexStart, pYTexStart, pYDiffTex,icon,size, pResourceLocation, pTextureWidth, pTextureHeight, pOnPress, CommonComponents.EMPTY);
    }

    public BookTabBase(int pX, int pY, int pWidth, int pHeight, int pXTexStart, int pYTexStart, int pYDiffTex,  ResourceLocation icon,int size, ResourceLocation pResourceLocation, int pTextureWidth, int pTextureHeight, Button.OnPress pOnPress, Component pMessage) {
        super(pX, pY, pWidth, pHeight, pMessage, pOnPress, DEFAULT_NARRATION);
        this.textureWidth = pTextureWidth;
        this.textureHeight = pTextureHeight;
        this.xTexStart = pXTexStart;
        this.yTexStart = pYTexStart;
        this.yDiffTex = pYDiffTex;
        this.resourceLocation = pResourceLocation;
        this.icon=icon;
        this.iconSize = size;
    }

    public void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {

        if(isDisplay){
            RenderSystem.enableBlend();
            this.renderTexture(pGuiGraphics, this.resourceLocation, this.getX(), this.getY(), this.xTexStart, this.yTexStart, this.yDiffTex, this.width, this.height, this.textureWidth, this.textureHeight);
            this.renderTexture(pGuiGraphics, this.icon, this.getX()+5, this.getY()+4, 0, 0, 0, iconSize, iconSize,iconSize , iconSize);
            RenderSystem.disableBlend();
        }else{
            RenderSystem.enableBlend();
            this.renderTexture(pGuiGraphics, this.resourceLocation, this.getX(), this.getY(), this.xTexStart, this.yTexStart, this.yDiffTex, this.width, this.height, this.textureWidth, this.textureHeight);
            this.renderTexture(pGuiGraphics, this.icon, this.getX()+13, this.getY()+4, 0, 0, 0, iconSize,iconSize, iconSize, iconSize);
            this.renderTexture(pGuiGraphics, this.resourceLocation, this.getX(), this.getY(), this.xTexStart+24, 232, this.yDiffTex, this.width, this.height, this.textureWidth, this.textureHeight);
            RenderSystem.disableBlend();
        }
    }

    @Override
    public void playDownSound(SoundManager pHandler) {
        pHandler.play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0F));
    }
}
