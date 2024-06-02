package com.strangesmell.thaumcraft.common.lib.research;

import com.strangesmell.thaumcraft.Thaumcraft;
import com.strangesmell.thaumcraft.api.ThaumcraftApi;
import com.strangesmell.thaumcraft.api.aspects.Aspect;
import com.strangesmell.thaumcraft.api.aspects.AspectList;
import com.strangesmell.thaumcraft.api.research.IScanEventHandler;
import com.strangesmell.thaumcraft.api.research.ScanResult;
import com.strangesmell.thaumcraft.common.lib.utils.Utils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.datafix.fixes.EntityIdFix;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ScanManager implements IScanEventHandler {
    public ScanManager() {
    }
    @Override
    public ScanResult scanPhenomena(ItemStack stack, Level world, Player player) {
        return null;
    }


/*    public static boolean isValidScanTarget(Player player, ScanResult scan, String prefix) {
        if (scan == null) {
            return false;
        } else if (prefix.equals("@") && !isValidScanTarget(player, scan, "#")) {
            return false;
        } else {
            List list;
            if (scan.type == 1) {
                if (ThaumcraftApi.groupedObjectTags.containsKey(Arrays.asList(Item.byId(scan.id), scan.meta))) {
                    scan.meta = ((int[]) ThaumcraftApi.groupedObjectTags.get(Arrays.asList(Item.byId(scan.id), scan.meta)))[0];
                }

                list = (List) Thaumcraft.proxy.getScannedObjects().get(player.getName().getString());
                if (list != null && list.contains(prefix + generateItemHash(Item.byId(scan.id), scan.meta))) {
                    return false;
                }
            } else if (scan.type == 2) {
                if (scan.entity instanceof EntityItem) {
                    EntityItem item = (EntityItem)scan.entity;
                    ItemStack t = item.func_92059_d().func_77946_l();
                    t.field_77994_a = 1;
                    if (ThaumcraftApi.groupedObjectTags.containsKey(Arrays.asList(t.func_77973_b(), t.func_77960_j()))) {
                        t.func_77964_b(((int[])ThaumcraftApi.groupedObjectTags.get(Arrays.asList(t.func_77973_b(), t.func_77960_j())))[0]);
                    }

                    List<String> list = (List)Thaumcraft.proxy.getScannedObjects().get(player.func_70005_c_());
                    if (list != null && list.contains(prefix + generateItemHash(t.func_77973_b(), t.func_77960_j()))) {
                        return false;
                    }
                } else {
                    list = (List)Thaumcraft.proxy.getScannedEntities().get(player.func_70005_c_());
                    if (list != null && list.contains(prefix + generateEntityHash(scan.entity))) {
                        return false;
                    }
                }
            } else if (scan.type == 3) {
                list = (List)Thaumcraft.proxy.getScannedPhenomena().get(player.func_70005_c_());
                if (list != null && list.contains(prefix + scan.phenomena)) {
                    return false;
                }
            }

            return true;
        }
    }*/

    public static AspectList generateEntityAspects(Entity entity) {
        AspectList tags = null;
        String s = null;


        s = entity.getName().getString();

        if (s == null) {
            s = "generic";
        }

        if (entity instanceof Player player) {
            s = "player_" + player.getName().getString();
            tags = new AspectList();
            tags.add(Aspect.MAN, 4);
            if (player.getName().getString().equalsIgnoreCase("azanor")) {
                tags.add(Aspect.ELDRITCH, 20);
            } else if (player.getName().getString().equalsIgnoreCase("direwolf20")) {
                tags.add(Aspect.BEAST, 20);
            } else if (player.getName().getString().equalsIgnoreCase("pahimar")) {
                tags.add(Aspect.EXCHANGE, 20);
            } else if (player.getName().getString().equalsIgnoreCase("strange_smell")){
                tags.add(Aspect.HEAL, 20);
            } else {
                Random rand = new Random(s.hashCode());
                Aspect[] posa = Aspect.aspects.values().toArray(new Aspect[0]);
                tags.add(posa[rand.nextInt(posa.length)], 4);
                tags.add(posa[rand.nextInt(posa.length)], 4);
                tags.add(posa[rand.nextInt(posa.length)], 4);
            }
        } else {
            Iterator i$ = ThaumcraftApi.scanEntities.iterator();

            while(true) {
                while(true) {
                    label60:
                    while(true) {
                        ThaumcraftApi.EntityTags et;
                        do {
                            if (!i$.hasNext()) {
                                return tags;
                            }
                            et = (ThaumcraftApi.EntityTags)i$.next();
                        } while(!et.entityName.equals(s));

                        if (et.nbts != null && et.nbts.length != 0) {
                            CompoundTag tc = new CompoundTag();
                            entity.getPersistentData().put("your_aspects",tc);
                            ThaumcraftApi.EntityTagsNBT[] arr$ = et.nbts;
                            int len$ = arr$.length;
                            //may false
                            for(int i = 0; i < len$; ++i) {
                                ThaumcraftApi.EntityTagsNBT nbt = arr$[i];
                                if (!tc.contains(nbt.name) || !Utils.getNBTDataFromId(tc, tc.getId(), nbt.name).equals(nbt.value)) {
                                    continue label60;
                                }
                            }

                            tags = et.aspects;
                        } else {
                            tags = et.aspects;
                        }
                    }
                }
            }
        }

        return tags;
    }
}
