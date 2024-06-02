package com.strangesmell.thaumcraft.client.renderers.models;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.strangesmell.thaumcraft.api.ThaumcraftApi;
import com.strangesmell.thaumcraft.api.aspects.Aspect;
import com.strangesmell.thaumcraft.api.aspects.AspectList;
import com.strangesmell.thaumcraft.common.config.ConfigItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import static com.strangesmell.thaumcraft.api.research.ScanManager.isObjectsBeScanned;

public class ThaumometerItemRenderer extends BlockEntityWithoutLevelRenderer {
    private static int degree = 0;
    public ThaumometerItemRenderer(){
        super(null,null);
    }

    @Override
    public void renderByItem(ItemStack pStack, ItemDisplayContext pDisplayContext, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {


        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        BakedModel bakedModel = itemRenderer.getModel(pStack,null,null,1);
        BakedModel bakedModel2 = itemRenderer.getModel(new ItemStack(ConfigItems.itemThaumonomicon.get()),null,null,1);
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.XP.rotationDegrees(90));
        pPoseStack.translate(0F, 0F, -1F);
        RenderSystem.setShaderColor(1,1,1,1);
        itemRenderer.render(pStack, ItemDisplayContext.NONE, false, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, bakedModel);

        pPoseStack.popPose();

        pPoseStack.pushPose();

        GuiGraphics guiGraphics = new GuiGraphics(Minecraft.getInstance(),Minecraft.getInstance().renderBuffers().bufferSource());
        HitResult hitResult = ThaumcraftApi.getHitResult(Minecraft.getInstance().level,Minecraft.getInstance().player );
        if (hitResult instanceof BlockHitResult blockHitResult){
            if(!isObjectsBeScanned(Minecraft.getInstance().player,Minecraft.getInstance().level.getBlockState(blockHitResult.getBlockPos()).getBlock().getName().getString() )) return;
            AspectList aspects = AspectList.getObjectAspects(new ItemStack(Minecraft.getInstance().level.getBlockState(blockHitResult.getBlockPos()).getBlock()));
            int size = aspects.size()-1;
            for(int i = 0; i<aspects.size();i++){
                Aspect aspect = aspects.getAspects()[i];
                RenderSystem.enableBlend();
                RenderSystem.setShaderColor(aspect.getRed(),aspect.getGreen(),aspect.getBlue(),0.5f);
                guiGraphics.blit(aspect.getImage(),guiGraphics.guiWidth()/2 - 16 - size*16 + i*32,guiGraphics.guiHeight()/2-16,32,32,0,0,32,32,32,32);
                RenderSystem.setShaderColor(1,1,1,1);
                pPoseStack.translate(0F, -1F, 0.5F);
                pPoseStack.mulPose(Axis.XP.rotationDegrees(-90));
                itemRenderer.render(new ItemStack(ConfigItems.itemThaumonomicon.get()), ItemDisplayContext.NONE, false, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, bakedModel2);

                guiGraphics.drawString(Minecraft.getInstance().font,String.valueOf(aspects.getAmount(aspect)),guiGraphics.guiWidth()/2 + 11 - size*16 + i*32,guiGraphics.guiHeight()/2+11,0xFFF000);
                RenderSystem.disableBlend();
            }
        }




        pPoseStack.popPose();
    }
}
