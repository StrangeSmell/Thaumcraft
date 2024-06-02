package com.strangesmell.thaumcraft.api.research;

import com.strangesmell.thaumcraft.Thaumcraft;
import com.strangesmell.thaumcraft.api.ThaumcraftApi;
import com.strangesmell.thaumcraft.api.aspects.Aspect;
import com.strangesmell.thaumcraft.api.aspects.AspectList;
import com.strangesmell.thaumcraft.api.aspects.AspectSourceHelper;
import com.strangesmell.thaumcraft.client.lib.PlayerNotifications;
import com.strangesmell.thaumcraft.common.lib.research.PlayerKnowledge;
import com.strangesmell.thaumcraft.common.lib.research.ResearchManager;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

import static com.strangesmell.thaumcraft.common.lib.research.ScanManager.generateEntityAspects;


public class ScanManager {
    public static boolean doObjectScan(Player player, Block block){
        if(isObjectsBeScanned(player,block.getName().getString())) return false;
        AspectList aspects = AspectList.getObjectAspects(new ItemStack(block));
        if( validScan(aspects,player)){

            for(Aspect aspect : aspects.getAspects())
            Thaumcraft.proxy.playerKnowledge.addDiscoveredAspect(player.getName().getString(),aspect);
            Thaumcraft.proxy.playerKnowledge.addScandObject(player.getName().getString(),block.getName().getString());
            return true;
        } else return false;

    }

    public static boolean doEntityScan(Player player, Entity entity){
        if(entity instanceof ItemEntity itemEntity){
            if(isObjectsBeScanned(player,itemEntity.getName().getString())) return false;
            AspectList aspects = AspectList.getObjectAspects(itemEntity.getItem());
            if( validScan(aspects,player)){

                for(Aspect aspect : aspects.getAspects())
                    Thaumcraft.proxy.playerKnowledge.addDiscoveredAspect(player.getName().getString(),aspect);
                Thaumcraft.proxy.playerKnowledge.addScandObject(player.getName().getString(),itemEntity.getName().getString());
                return true;
            } else return false;

        }else{
            if(isEntitiesBeScanned(player,entity.getName().getString())) return false;
            AspectList aspects = generateEntityAspects(entity);
            if( validScan(aspects,player)){
                for(Aspect aspect : aspects.getAspects())
                    Thaumcraft.proxy.playerKnowledge.addDiscoveredAspect(player.getName().getString(),aspect);
                    ResearchManager.completeScannedEntityUnsaved(player.getName().getString(),entity.getName().getString());

                return true;
            } else return false;
        }

    }



    public static boolean isObjectsBeScanned(Player player, String s){
        if(Thaumcraft.proxy.getScannedObjects().get(player.getName().getString()) == null ) {
            Thaumcraft.proxy.getScannedObjects().put(player.getName().getString(),new ArrayList<>());
        }
        return Thaumcraft.proxy.getScannedObjects().get(player.getName().getString()).contains(s);
    }

    public static boolean isEntitiesBeScanned(Player player, String s){
        return Thaumcraft.proxy.getScannedEntities().containsKey(s);
    }


    public static boolean validScan(AspectList aspects, Player player) {
        Thaumcraft var10000 = Thaumcraft.instance;
        PlayerKnowledge rp = Thaumcraft.proxy.getPlayerKnowledge();
        if (aspects != null && aspects.size() > 0) {
            Aspect[] arr$ = aspects.getAspects();
            int len$ = arr$.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Aspect aspect = arr$[i$];
                if (aspect != null && !aspect.isPrimal() && !rp.hasDiscoveredParentAspects(player.getName().getString(), aspect)) {
                    if (player.level().isClientSide) {
                         arr$ = aspect.getComponents();
                         len$ = arr$.length;

                        for(int ii$ = 0; i$ < len$; ++i$) {
                            Aspect parent = arr$[ii$];
                            if (!rp.hasDiscoveredAspect(player.getName().getString(), parent)) {
                                //may false
                                PlayerNotifications.addNotification((Component.translatable(("tc.discoveryerror"), ("tc.aspect.help." + parent.getTag()))).getString());
                                break;
                            }
                        }
                    }

                    return false;
                }
            }

            return true;
        } else {
            if (player.level().isClientSide) {
                PlayerNotifications.addNotification(Component.translatable("tc.unknownobject").getString());
            }

            return false;
        }
    }
}
