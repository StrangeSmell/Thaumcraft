package com.strangesmell.thaumcraft.common.dataGather;

import com.strangesmell.thaumcraft.Thaumcraft;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.strangesmell.thaumcraft.Thaumcraft.MODID;
import static com.strangesmell.thaumcraft.common.config.ConfigItems.itemThaumonomicon;

public class ModelProvider extends ItemModelProvider {
    public ModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.singleTexture("item_thaumonomicon", new ResourceLocation("item/generated"), "layer0", new ResourceLocation(MODID, "item/" + "thaumonomicon"));
        this.singleTexture("item_researchnotes", new ResourceLocation("item/generated"), "layer0", new ResourceLocation(MODID, "item/" + "researchnotes"));
        //this.singleTexture("item_thaumometer", new ResourceLocation("item/generated"), "layer0", new ResourceLocation(MODID, "item/" + "thaumometer"));




    }
}
