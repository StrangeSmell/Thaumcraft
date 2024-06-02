package com.strangesmell.thaumcraft.common.config;

import com.strangesmell.thaumcraft.Thaumcraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = Thaumcraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();




    private static final ForgeConfigSpec.IntValue NOTIFICATION_DELAY = BUILDER
            .comment("notificationDelay")
            .defineInRange("notificationDelay", 5000, 0, Integer.MAX_VALUE);


    public static final ForgeConfigSpec SPEC = BUILDER.build();


    public static double notificationDelay;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {

        notificationDelay = NOTIFICATION_DELAY.get();

    }
}
