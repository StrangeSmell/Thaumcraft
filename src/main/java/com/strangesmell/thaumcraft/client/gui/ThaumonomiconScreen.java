package com.strangesmell.thaumcraft.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.strangesmell.thaumcraft.Thaumcraft;
import com.strangesmell.thaumcraft.common.config.ConfigGui;
import com.strangesmell.thaumcraft.common.items.relics.ItemThaumonomicon;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

import static com.strangesmell.thaumcraft.Thaumcraft.MODID;
import static com.strangesmell.thaumcraft.common.config.ConfigGui.BookBackGroundId;
import static com.strangesmell.thaumcraft.common.config.ConfigGui.BookGuiResourceLocation;

public class ThaumonomiconScreen extends Screen {
    public int page;
    public float x;
    public float y;
    protected EditBox timeEdit;
    protected Button doneButton;
    protected List<BookTabBase> buttons=new ArrayList<>();
    public ItemThaumonomicon itemThaumonomicon;
    protected BookTabBase lastDisplayButton;

    public ThaumonomiconScreen(Component p_96550_, int page, float x, float y, ItemThaumonomicon itemThaumonomicon) {
        super(p_96550_);
        this.page=page;
        this.x=x;
        this.y=y;
        this.itemThaumonomicon = itemThaumonomicon;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        if(-x >128*2) x=-128*2;
        if(-x <0) x=0;
        if(-y >115*2) y=-115*2;
        if(-y <0) y=0;
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        this.renderBackground(graphics);

        super.render(graphics, mouseX, mouseY, partialTick);

        RenderSystem.enableBlend();
        graphics.blit(BookGuiResourceLocation.get(BookBackGroundId.get(page)),this.width/2 - 128,this.height/2-115,256,230,0-x,0-y,256,230,512,512);

        //TODO modify Book
        graphics.blit(BookGuiResourceLocation.get(MODID+"BookGui"),this.width/2 - 128,this.height/2-115,256,230,0,0,256,230,256,256);

        RenderSystem.enableBlend();

    }

    @Override
    protected void init() {
        buttons.clear();
        super.init();
        page= itemThaumonomicon.page;
        x=itemThaumonomicon.mouseX;
        y=itemThaumonomicon.mouseY;

        for(int i = 0 ;i<ConfigGui.getBookTabId();i++){
            int j =i;//176, 232  152, 232
            int xTextStart = 176;
            if(page==i){
                xTextStart = 152;
            }
            buttons.add(new BookTabBase(this.width / 2 -128 - 20, this.height/2-115 + 24*j, 24, 24, xTextStart, 232,0,ConfigGui.BookTabId.get(i) ,16, BookGuiResourceLocation.get(Thaumcraft.MODID+"BookGui"), (p_289630_) -> {
                this.page  = j;
                this.lastDisplayButton.xTexStart=176;
                this.lastDisplayButton.isDisplay=false;
                buttons.get(j).isDisplay=true;
                this.lastDisplayButton=buttons.get(page);
                this.lastDisplayButton.xTexStart=152;
                itemThaumonomicon.page=page;
            }));

        }
        for (BookTabBase button : buttons) {
            this.addRenderableWidget(button);
        }
        buttons.get(page).isDisplay=true;
        this.lastDisplayButton = buttons.get(page);
    }

    public void scroll(double dx, double dy) {

        x = x + (float) dx;
        y = y + (float) dy;

        itemThaumonomicon.mouseX=x;
        itemThaumonomicon.mouseY=y;
    }
    //int button 左键为0右键为1

    @Override
    public boolean mouseDragged(double pMouseX, double pMouseY, int button, double pDragX, double pDragY) {
        if (button == 0) {
            if (this.isMouseOver(this.width/2 - 128,this.height/2-115)) {
                scroll(pDragX, pDragY);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean isPauseScreen() {
        return false;
    }
}
