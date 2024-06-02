package com.strangesmell.thaumcraft.common.config;

import com.strangesmell.thaumcraft.api.ThaumcraftApi;
import com.strangesmell.thaumcraft.api.ThaumcraftApi.*;
import com.strangesmell.thaumcraft.api.aspects.Aspect;
import com.strangesmell.thaumcraft.api.aspects.AspectList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.Iterator;

public class ConfigAspects {

    public static void init() {
        registerItemAspects();
        registerEntityAspects();
    }

    private static void registerItemAspects() {
        ThaumcraftApi.registerObjectTag(new ItemStack(Items.STONE), (new AspectList()).add(Aspect.EARTH, 2));


        ThaumcraftApi.registerObjectTag(new ItemStack(Items.CAKE), (new AspectList()).add(Aspect.METAL, 16));
        ThaumcraftApi.registerObjectTag(new ItemStack(Items.BELL), (new AspectList()).add(Aspect.CRYSTAL, 16).add(Aspect.METAL, 16));




    }

    private static void registerEntityAspects() {
        ThaumcraftApi.registerEntityTag("Zombie", (new AspectList()).add(Aspect.UNDEAD, 2).add(Aspect.MAN, 1).add(Aspect.EARTH, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Giant", (new AspectList()).add(Aspect.UNDEAD, 4).add(Aspect.MAN, 3).add(Aspect.EARTH, 3), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Skeleton", (new AspectList()).add(Aspect.UNDEAD, 3).add(Aspect.MAN, 1).add(Aspect.EARTH, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Skeleton", (new AspectList()).add(Aspect.UNDEAD, 4).add(Aspect.MAN, 1).add(Aspect.FIRE, 2), new EntityTagsNBT[]{new EntityTagsNBT("SkeletonType", (byte)1)});
        ThaumcraftApi.registerEntityTag("Creeper", (new AspectList()).add(Aspect.PLANT, 2).add(Aspect.FIRE, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Creeper", (new AspectList()).add(Aspect.PLANT, 3).add(Aspect.FIRE, 3).add(Aspect.ENERGY, 3), new EntityTagsNBT[]{new EntityTagsNBT("powered", (byte)1)});
        ThaumcraftApi.registerEntityTag("EntityHorse", (new AspectList()).add(Aspect.BEAST, 4).add(Aspect.EARTH, 1).add(Aspect.AIR, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Pig", (new AspectList()).add(Aspect.BEAST, 2).add(Aspect.EARTH, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("XPOrb", (new AspectList()).add(Aspect.MIND, 5), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Sheep", (new AspectList()).add(Aspect.BEAST, 2).add(Aspect.EARTH, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Cow", (new AspectList()).add(Aspect.BEAST, 3).add(Aspect.EARTH, 3), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("MushroomCow", (new AspectList()).add(Aspect.BEAST, 3).add(Aspect.PLANT, 1).add(Aspect.EARTH, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("SnowMan", (new AspectList()).add(Aspect.COLD, 3).add(Aspect.WATER, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Ozelot", (new AspectList()).add(Aspect.BEAST, 3).add(Aspect.ENTROPY, 3), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Chicken", (new AspectList()).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 2).add(Aspect.AIR, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Squid", (new AspectList()).add(Aspect.BEAST, 2).add(Aspect.WATER, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Wolf", (new AspectList()).add(Aspect.BEAST, 3).add(Aspect.EARTH, 3), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Bat", (new AspectList()).add(Aspect.BEAST, 1).add(Aspect.FLIGHT, 1).add(Aspect.AIR, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Boat", (new AspectList()).add(Aspect.MECHANISM, 2).add(Aspect.WATER, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Spider", (new AspectList()).add(Aspect.BEAST, 3).add(Aspect.ENTROPY, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Slime", (new AspectList()).add(Aspect.SLIME, 2).add(Aspect.WATER, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Ghast", (new AspectList()).add(Aspect.UNDEAD, 3).add(Aspect.FIRE, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("PigZombie", (new AspectList()).add(Aspect.UNDEAD, 4).add(Aspect.FIRE, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Enderman", (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.TRAVEL, 2).add(Aspect.AIR, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("CaveSpider", (new AspectList()).add(Aspect.BEAST, 2).add(Aspect.POISON, 2).add(Aspect.EARTH, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Silverfish", (new AspectList()).add(Aspect.BEAST, 1).add(Aspect.EARTH, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Blaze", (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.FIRE, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("LavaSlime", (new AspectList()).add(Aspect.SLIME, 3).add(Aspect.FIRE, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("EnderDragon", (new AspectList()).add(Aspect.ELDRITCH, 20).add(Aspect.BEAST, 20).add(Aspect.ENTROPY, 20), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("WitherBoss", (new AspectList()).add(Aspect.UNDEAD, 20).add(Aspect.ENTROPY, 20).add(Aspect.FIRE, 15), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Witch", (new AspectList()).add(Aspect.MAN, 3).add(Aspect.MAGIC, 2).add(Aspect.FIRE, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Villager", (new AspectList()).add(Aspect.MAN, 3).add(Aspect.AIR, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("VillagerGolem", (new AspectList()).add(Aspect.METAL, 4).add(Aspect.EARTH, 3), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("MinecartRideable", (new AspectList()).add(Aspect.MECHANISM, 3).add(Aspect.AIR, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("MinecartChest", (new AspectList()).add(Aspect.MECHANISM, 3).add(Aspect.AIR, 1).add(Aspect.VOID, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("MinecartFurnace", (new AspectList()).add(Aspect.MECHANISM, 3).add(Aspect.AIR, 1).add(Aspect.FIRE, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("MinecartTNT", (new AspectList()).add(Aspect.MECHANISM, 3).add(Aspect.AIR, 1).add(Aspect.FIRE, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("MinecartHopper", (new AspectList()).add(Aspect.MECHANISM, 3).add(Aspect.AIR, 1).add(Aspect.EXCHANGE, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("MinecartSpawner", (new AspectList()).add(Aspect.MECHANISM, 3).add(Aspect.AIR, 1).add(Aspect.MAGIC, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("EnderCrystal", (new AspectList()).add(Aspect.ELDRITCH, 3).add(Aspect.MAGIC, 3).add(Aspect.HEAL, 3), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("ItemFrame", (new AspectList()).add(Aspect.SENSES, 3).add(Aspect.CLOTH, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Painting", (new AspectList()).add(Aspect.SENSES, 5).add(Aspect.CLOTH, 3), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.PrimalOrb", (new AspectList()).add(Aspect.AIR, 5).add(Aspect.ENTROPY, 10).add(Aspect.MAGIC, 10).add(Aspect.ENERGY, 10), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.Firebat", (new AspectList()).add(Aspect.BEAST, 2).add(Aspect.FLIGHT, 1).add(Aspect.FIRE, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.Pech", (new AspectList()).add(Aspect.MAN, 2).add(Aspect.MAGIC, 2).add(Aspect.EXCHANGE, 2).add(Aspect.GREED, 2), new EntityTagsNBT[]{new EntityTagsNBT("PechType", (byte)0)});
        ThaumcraftApi.registerEntityTag("Thaumcraft.Pech", (new AspectList()).add(Aspect.MAN, 2).add(Aspect.MAGIC, 2).add(Aspect.EXCHANGE, 2).add(Aspect.WEAPON, 2), new EntityTagsNBT[]{new EntityTagsNBT("PechType", (byte)1)});
        ThaumcraftApi.registerEntityTag("Thaumcraft.Pech", (new AspectList()).add(Aspect.MAN, 2).add(Aspect.MAGIC, 4).add(Aspect.EXCHANGE, 2), new EntityTagsNBT[]{new EntityTagsNBT("PechType", (byte)2)});
        ThaumcraftApi.registerEntityTag("Thaumcraft.ThaumSlime", (new AspectList()).add(Aspect.SLIME, 2).add(Aspect.MAGIC, 1).add(Aspect.WATER, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.BrainyZombie", (new AspectList()).add(Aspect.UNDEAD, 3).add(Aspect.MAN, 1).add(Aspect.MIND, 1).add(Aspect.EARTH, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.GiantBrainyZombie", (new AspectList()).add(Aspect.UNDEAD, 4).add(Aspect.MAN, 2).add(Aspect.MIND, 1).add(Aspect.EARTH, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.Taintacle", (new AspectList()).add(Aspect.TAINT, 3).add(Aspect.WATER, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.TaintacleTiny", (new AspectList()).add(Aspect.TAINT, 1).add(Aspect.WATER, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.TaintSpider", (new AspectList()).add(Aspect.TAINT, 1).add(Aspect.EARTH, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.TaintSpore", (new AspectList()).add(Aspect.TAINT, 2).add(Aspect.AIR, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.TaintSwarmer", (new AspectList()).add(Aspect.TAINT, 2).add(Aspect.AIR, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.TaintSwarm", (new AspectList()).add(Aspect.TAINT, 3).add(Aspect.AIR, 3), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.TaintedPig", (new AspectList()).add(Aspect.TAINT, 2).add(Aspect.EARTH, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.TaintedSheep", (new AspectList()).add(Aspect.TAINT, 2).add(Aspect.EARTH, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.TaintedCow", (new AspectList()).add(Aspect.TAINT, 3).add(Aspect.EARTH, 3), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.TaintedChicken", (new AspectList()).add(Aspect.TAINT, 2).add(Aspect.FLIGHT, 2).add(Aspect.AIR, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.TaintedVillager", (new AspectList()).add(Aspect.TAINT, 3).add(Aspect.AIR, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.TaintedCreeper", (new AspectList()).add(Aspect.TAINT, 2).add(Aspect.FIRE, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.MindSpider", (new AspectList()).add(Aspect.TAINT, 2).add(Aspect.FIRE, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.EldritchGuardian", (new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.DEATH, 2).add(Aspect.UNDEAD, 4), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.EldritchOrb", (new AspectList()).add(Aspect.ELDRITCH, 2).add(Aspect.DEATH, 2), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.CultistKnight", (new AspectList()).add(Aspect.ELDRITCH, 1).add(Aspect.MAN, 2).add(Aspect.ENTROPY, 1), new EntityTagsNBT[0]);
        ThaumcraftApi.registerEntityTag("Thaumcraft.CultistCleric", (new AspectList()).add(Aspect.ELDRITCH, 1).add(Aspect.MAN, 2).add(Aspect.ENTROPY, 1), new EntityTagsNBT[0]);
        Iterator i$ = Aspect.aspects.values().iterator();

        while(i$.hasNext()) {
            Aspect tag = (Aspect)i$.next();
            ThaumcraftApi.registerEntityTag("Thaumcraft.Wisp", (new AspectList()).add(tag, 2).add(Aspect.MAGIC, 1).add(Aspect.AIR, 1), new EntityTagsNBT[]{new EntityTagsNBT("Type", tag.getTag())});
        }

        ThaumcraftApi.registerEntityTag("Thaumcraft.Golem", (new AspectList()).add(Aspect.AIR, 2).add(Aspect.EARTH, 2).add(Aspect.MAGIC, 2), new EntityTagsNBT[0]);
    }


}
