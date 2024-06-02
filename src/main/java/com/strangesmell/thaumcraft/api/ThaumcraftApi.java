package com.strangesmell.thaumcraft.api;


import com.strangesmell.thaumcraft.api.aspects.Aspect;
import com.strangesmell.thaumcraft.api.aspects.AspectList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Azanor
 *
 *
 * IMPORTANT: If you are adding your own aspects to items it is a good idea to do it AFTER Thaumcraft adds its aspects, otherwise odd things may happen.
 *
 */
public class ThaumcraftApi {
    public static ConcurrentHashMap<List, AspectList> objectTags = new ConcurrentHashMap();
    public static ConcurrentHashMap<List,int[]> groupedObjectTags = new ConcurrentHashMap<List,int[]>();


    public static void registerEntityTag(String entityName, AspectList aspects, EntityTagsNBT... nbt ) {
        scanEntities.add(new EntityTags(entityName,aspects,nbt));
    }
    //RESEARCH/////////////////////////////////////////
    //public static ArrayList<IScanEventHandler> scanEventhandlers = new ArrayList<IScanEventHandler>();
    public static ArrayList<EntityTags> scanEntities = new ArrayList<EntityTags>();
    public static class EntityTagsNBT {
        public EntityTagsNBT(String name, Object value) {
            this.name = name;
            this.value = value;
        }
        public String name;
        public Object value;
    }
    public static class EntityTags {
        public EntityTags(String entityName, AspectList aspects, EntityTagsNBT... nbts) {
            this.entityName = entityName;
            this.nbts = nbts;
            this.aspects = aspects;
        }
        public String entityName;
        public EntityTagsNBT[] nbts;
        public AspectList aspects;
    }



    public static void registerObjectTag(ItemStack item, AspectList aspects) {
        if (aspects == null) {
            aspects = new AspectList();
        }

        try {
            objectTags.put(Arrays.asList(item.getItem(), item.getDamageValue()), aspects);
        } catch (Exception var3) {
        }

    }



    public static HitResult getHitResult(Level level, Player player) {
        AABB aabb;
        double range = Objects.requireNonNull(player.getAttribute(ForgeMod.BLOCK_REACH.get())).getValue();
        Vec3 eyePosition = player.getEyePosition();
        Vec3 viewVector = player.getViewVector(1.0f);
        Vec3 endPosition = eyePosition.add(viewVector.x * range, viewVector.y * range, viewVector.z * range);
        //may false
        HitResult hitResult = ProjectileUtil.getEntityHitResult((Level)level, (Entity)player, (Vec3)eyePosition, (Vec3)endPosition, (AABB)(aabb = player.getBoundingBox().expandTowards(viewVector.scale(range)).inflate(1.0, 1.0, 1.0)), entity -> !entity.isSpectator() );
        if (hitResult == null) {
            hitResult = level.clip(new ClipContext(eyePosition, endPosition, ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, (Entity)player));
        }
        return hitResult;
    }

}
