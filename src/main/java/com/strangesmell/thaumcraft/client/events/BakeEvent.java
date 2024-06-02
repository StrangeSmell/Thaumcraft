package com.strangesmell.thaumcraft.client.events;

import com.strangesmell.thaumcraft.common.config.ConfigItems;
import com.strangesmell.thaumcraft.common.items.relics.ItemThaumometer;
import com.strangesmell.thaumcraft.common.model.ThaumometerBakeModel;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class BakeEvent {
    @SubscribeEvent
    public static void onModelBaked(ModelEvent.ModifyBakingResult event){

        Map<ResourceLocation, BakedModel> modelRegistry = event.getModels();
        ModelResourceLocation location = new ModelResourceLocation(BuiltInRegistries.ITEM.getKey(ConfigItems.itemThaumometer.get()), "inventory");
        BakedModel existingModel = modelRegistry.get(location);
        if (existingModel == null) {
            throw new RuntimeException("Did not find thaumometer in registry");
        } else if (existingModel instanceof ItemThaumometer) {
            throw new RuntimeException("Tried to replace thaumometer twice");
        } else {
            ThaumometerBakeModel thaumometerBakeModel = new ThaumometerBakeModel(existingModel);
            event.getModels().put(location, thaumometerBakeModel);
        }
    }
}
