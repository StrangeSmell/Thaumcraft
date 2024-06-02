package com.strangesmell.thaumcraft.common.lib.research;

import com.google.common.io.Files;
import com.mojang.datafixers.types.templates.Tag;
import com.strangesmell.thaumcraft.Thaumcraft;
import com.strangesmell.thaumcraft.api.aspects.Aspect;
import com.strangesmell.thaumcraft.api.aspects.AspectList;
import com.strangesmell.thaumcraft.api.research.ResearchItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.player.Player;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResearchManager {
    static ArrayList<ResearchItem> allHiddenResearch = null;
    static ArrayList<ResearchItem> allValidResearch = null;
    private static final String RESEARCH_TAG = "THAUMCRAFT.RESEARCH";
    private static final String ASPECT_TAG = "THAUMCRAFT.ASPECTS";
    private static final String SCANNED_OBJ_TAG = "THAUMCRAFT.SCAN.OBJECTS";
    private static final String SCANNED_ENT_TAG = "THAUMCRAFT.SCAN.ENTITIES";
    private static final String SCANNED_PHE_TAG = "THAUMCRAFT.SCAN.PHENOMENA";

    public ResearchManager() {
    }


    public static void scheduleSave(Player player) {
        if (player.level().isClientSide) {
            ;
        }
    }

    public static boolean savePlayerData(Player player, File file1, File file2) {
        boolean success = true;

        try {
            CompoundTag data = new CompoundTag();
            //saveResearchNBT(data, player);
            saveAspectNBT(data, player);
            saveScannedNBT(data, player);
/*            if (Thaumcraft.instance.runicEventHandler.runicCharge.containsKey(player.getId())) {
                data.putInt("Thaumcraft.shielding", (Integer)Thaumcraft.instance.runicEventHandler.runicCharge.get(player.getId()));
            }*/

            data.putInt("Thaumcraft.eldritch", Thaumcraft.proxy.getPlayerKnowledge().getWarpPerm(player.getName().getString()));
            data.putInt("Thaumcraft.eldritch.temp", Thaumcraft.proxy.getPlayerKnowledge().getWarpTemp(player.getName().getString()));
            data.putInt("Thaumcraft.eldritch.sticky", Thaumcraft.proxy.getPlayerKnowledge().getWarpSticky(player.getName().getString()));
            data.putInt("Thaumcraft.eldritch.counter", Thaumcraft.proxy.getPlayerKnowledge().getWarpCounter(player.getName().getString()));
            if (file1 != null && file1.exists()) {
                try {
                    Files.copy(file1, file2);
                } catch (Exception var8) {
                    //Thaumcraft.log.error("Could not backup old research file for player " + player.getName().getString());
                }
            }

/*            try {
                if (file1 != null) {
                    FileOutputStream fileoutputstream = new FileOutputStream(file1);
                    CompressedStreamTools.func_74799_a(data, fileoutputstream);
                    fileoutputstream.close();
                }
            } catch (Exception var9) {
                Thaumcraft.log.error("Could not save research file for player " + player.getName().getString());
                if (file1.exists()) {
                    try {
                        file1.delete();
                    } catch (Exception var7) {
                    }
                }

                success = false;
            }*/
        } catch (Exception var10) {
            var10.printStackTrace();
            //Thaumcraft.log.fatal("Error saving Thaumcraft data");
            success = false;
        }

        return success;
    }

/*    public static void saveResearchNBT(CompoundTag entityData, Player player) {
        ListTag tagList = new ListTag();
        List res = getResearchForPlayer(player.getName().getString());
        if (res != null && res.size() > 0) {
            Iterator i$ = res.iterator();

            label45:
            while(true) {
                Object key;
                String k;
                do {
                    do {
                        do {
                            do {
                                if (!i$.hasNext()) {
                                    break label45;
                                }

                                key = i$.next();
                            } while((String)key == null);
                        } while(!((String)key).startsWith("@") && ResearchCategories.getResearch((String)key) == null);

                        if (!((String)key).startsWith("@")) {
                            break;
                        }

                        k = ((String)key).substring(1);
                    } while(isResearchComplete(player.getName().getString(), k));
                } while(ResearchCategories.getResearch((String)key) != null && ResearchCategories.getResearch((String)key).isAutoUnlock());

                CompoundTag f = new CompoundTag();
                f.putString("key", (String)key);
                tagList.add(f);
            }
        }

        entityData.put("THAUMCRAFT.RESEARCH", tagList);
    }*/

    public static boolean completeAspectUnsaved(String username, Aspect aspect, short amount) {
        if (aspect == null) {
            return false;
        } else {
            Thaumcraft.proxy.getPlayerKnowledge().addDiscoveredAspect(username, aspect);
            Thaumcraft.proxy.getPlayerKnowledge().setAspectPool(username, aspect, amount);
            return true;
        }
    }

    public void completeAspect(Player player, Aspect aspect, short amount) {
        if (completeAspectUnsaved(player.getName().getString(), aspect, amount)) {
            scheduleSave(player);
        }

    }

    public static boolean completeScannedObjectUnsaved(String username, String object) {
        ArrayList<String> completed = (ArrayList) Thaumcraft.proxy.getScannedObjects().get(username);
        if (completed == null) {
            completed = new ArrayList();
        }

        if (!completed.contains(object)) {
            completed.add(object);
            String t = object.replaceFirst("#", "@");
            if (object.startsWith("#") && completed.contains(t) && completed.remove(t)) {
            }

            Thaumcraft.proxy.getScannedObjects().put(username, completed);
        }

        return true;
    }

    public static boolean completeScannedEntityUnsaved(String username, String key) {
        ArrayList<String> completed = (ArrayList) Thaumcraft.proxy.getScannedEntities().get(username);
        if (completed == null) {
            completed = new ArrayList();
        }

        if (!completed.contains(key)) {
            completed.add(key);
            String t = key.replaceFirst("#", "@");
            if (key.startsWith("#") && completed.contains(t) && completed.remove(t)) {
            }

            Thaumcraft.proxy.getScannedEntities().put(username, completed);
        }

        return true;
    }

    public static boolean completeScannedPhenomenaUnsaved(String username, String key) {
        ArrayList<String> completed = (ArrayList) Thaumcraft.proxy.getScannedPhenomena().get(username);
        if (completed == null) {
            completed = new ArrayList();
        }

        if (!completed.contains(key)) {
            completed.add(key);
            String t = key.replaceFirst("#", "@");
            if (key.startsWith("#") && completed.contains(t) && completed.remove(t)) {
            }

            Thaumcraft.proxy.getScannedPhenomena().put(username, completed);
        }

        return true;
    }

    public void completeScannedObject(Player player, String object) {
        if (completeScannedObjectUnsaved(player.getName().getString(), object)) {
            scheduleSave(player);
        }

    }

    public void completeScannedEntity(Player player, String key) {
        if (completeScannedEntityUnsaved(player.getName().getString(), key)) {
            scheduleSave(player);
        }

    }

    public void completeScannedPhenomena(Player player, String key) {
        if (completeScannedPhenomenaUnsaved(player.getName().getString(), key)) {
            scheduleSave(player);
        }

    }

    public static void saveAspectNBT(CompoundTag entityData, Player player) {
        ListTag tagList = new ListTag();
        AspectList res = (AspectList) Thaumcraft.proxy.getKnownAspects().get(player.getName().getString());
        if (res != null && res.size() > 0) {
            Aspect[] arr$ = res.getAspects();
            int len$ = arr$.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                Aspect aspect = arr$[i$];
                if (aspect != null) {
                    CompoundTag f = new CompoundTag();
                    f.putString("key", aspect.getTag());
                    f.putShort("amount", (short) res.getAmount(aspect));
                    tagList.add(f);
                }
            }
        }

        entityData.put("THAUMCRAFT.ASPECTS", tagList);
    }

    public static void saveScannedNBT(CompoundTag entityData, Player player) {
        ListTag tagList = new ListTag();
        List<String> obj = Thaumcraft.proxy.getScannedObjects().get(player.getName().getString());
        if (obj != null && obj.size() > 0) {
            Iterator i$ = obj.iterator();

            while (i$.hasNext()) {
                String object = (String) i$.next();
                if (object != null) {
                    CompoundTag f = new CompoundTag();
                    f.putString("key", object);
                    tagList.add(f);
                }
            }
        }

        entityData.put("THAUMCRAFT.SCAN.OBJECTS", tagList);
        tagList = new ListTag();
        List<String> ent = Thaumcraft.proxy.getScannedEntities().get(player.getName().getString());
        if (ent != null && ent.size() > 0) {
            Iterator i$ = ent.iterator();

            while (i$.hasNext()) {
                String key = (String) i$.next();
                if (key != null) {
                    CompoundTag f = new CompoundTag();
                    f.putString("key", key);
                    tagList.add(f);
                }
            }
        }

        entityData.put("THAUMCRAFT.SCAN.ENTITIES", tagList);
        tagList = new ListTag();
        List<String> phe = Thaumcraft.proxy.getScannedPhenomena().get(player.getName().getString());
        if (phe != null && phe.size() > 0) {
            Iterator i$ = phe.iterator();

            while (i$.hasNext()) {
                String key = (String) i$.next();
                if (key != null) {
                    CompoundTag f = new CompoundTag();
                    f.putString("key", key);
                    tagList.add(f);
                }
            }
        }

        entityData.put("THAUMCRAFT.SCAN.PHENOMENA", tagList);
    }

    public static class HexEntry {
        public Aspect aspect;
        public int type;

        public HexEntry(Aspect aspect, int type) {
            this.aspect = aspect;
            this.type = type;
        }
    }
}
