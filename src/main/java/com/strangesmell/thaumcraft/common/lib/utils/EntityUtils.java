package com.strangesmell.thaumcraft.common.lib.utils;

import com.strangesmell.thaumcraft.api.ThaumcraftApi;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class EntityUtils {



/*    public static Entity getPointedEntity(Level world, Entity entityplayer, double minrange, double range, float padding, boolean nonCollide) {
        Entity pointedEntity = null;
        Vec3 vec3d = new Vec3(entityplayer.getX(), entityplayer.getY() + (double)entityplayer.getEyeHeight(), entityplayer.getZ());
        Vec3 vec3d1 = entityplayer.getLookAngle();
        Vec3 vec3d2 = vec3d.add(vec3d1.x * range, vec3d1.y * range, vec3d1.z * range);

        List list = world.getEntities(entityplayer, entityplayer.getBoundingBox().expandTowards(vec3d1.x * range, vec3d1.y * range, vec3d1.z * range).inflate((double)padding, (double)padding, (double)padding));
        double d2 = 0.0D;

        for(int i = 0; i < list.size(); ++i) {
            Entity entity = (Entity)list.get(i);
            if (!((double)entity.distanceTo(entityplayer) < minrange) && (entity.canBeCollidedWith() || nonCollide) && ThaumcraftApi.getHitResult(world,(Player) entityplayer).getType().equals(HitResult.Type.MISS)) {
                float f2 = Math.max(0.8F, (float) (entity.getBoundingBox().getSize()));
                AABB axisalignedbb = entity.getBoundingBox().inflate(f2, f2, f2);
                MovingObjectPosition movingobjectposition = axisalignedbb.func_72327_a(vec3d, vec3d2);
                if (axisalignedbb.contains(vec3d)) {
                    if (0.0D < d2 || d2 == 0.0D) {
                        pointedEntity = entity;
                        d2 = 0.0D;
                    }
                } else if (movingobjectposition != null) {
                    double d3 = vec3d.func_72438_d(movingobjectposition.field_72307_f);
                    if (d3 < d2 || d2 == 0.0D) {
                        pointedEntity = entity;
                        d2 = d3;
                    }
                }
            }
        }

        return pointedEntity;
    }*/
}
