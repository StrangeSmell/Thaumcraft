package com.strangesmell.thaumcraft.common.lib.research;

import com.strangesmell.thaumcraft.api.aspects.Aspect;
import com.strangesmell.thaumcraft.api.aspects.AspectList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PlayerKnowledge {
    public Map<String, ArrayList<String>> researchCompleted = new HashMap();
    public Map<String, AspectList> aspectsDiscovered = new HashMap();
    public Map<String, ArrayList<String>> objectsScanned = new HashMap();
    public Map<String, ArrayList<String>> entitiesScanned = new HashMap();
    public Map<String, ArrayList<String>> phenomenaScanned = new HashMap();
    public Map<String, Integer> warpCount = new HashMap();
    public Map<String, Integer> warp = new HashMap();
    public Map<String, Integer> warpSticky = new HashMap();//稳定扭曲
    public Map<String, Integer> warpTemp = new HashMap();//临时扭曲

    public PlayerKnowledge() {
    }

    public void wipePlayerKnowledge(String player) {
        this.researchCompleted.remove(player);
        this.aspectsDiscovered.remove(player);
        this.objectsScanned.remove(player);
        this.entitiesScanned.remove(player);
        this.phenomenaScanned.remove(player);
        this.warp.remove(player);
        this.warpTemp.remove(player);
        this.warpSticky.remove(player);
    }

    public AspectList getAspectsDiscovered(String player) {
        AspectList known = (AspectList)this.aspectsDiscovered.get(player);
        if (known == null || known.size() <= 6) {
            this.addDiscoveredPrimalAspects(player);
            known = (AspectList)this.aspectsDiscovered.get(player);
        }

        return known;
    }

    public boolean hasDiscoveredAspect(String player, Aspect aspect) {
        return this.getAspectsDiscovered(player).aspects.containsKey(aspect);
    }

    public boolean hasDiscoveredParentAspects(String player, Aspect aspect) {
        if (aspect == null) {
            return false;
        } else {
            Aspect[] components = aspect.getComponents();
            if (components == null) {
                return true;
            } else {
                return Arrays.asList(this.getAspectsDiscovered(player).getAspects()).containsAll(Arrays.asList(components));
            }
        }
    }

    public void addDiscoveredPrimalAspects(String player) {
        AspectList known = (AspectList)this.aspectsDiscovered.get(player);
        if (known == null) {
            known = new AspectList();
        }

        if (!known.aspects.containsKey(Aspect.AIR)) {
            known.add(Aspect.AIR, 0);
        }

        if (!known.aspects.containsKey(Aspect.FIRE)) {
            known.add(Aspect.FIRE, 0);
        }

        if (!known.aspects.containsKey(Aspect.EARTH)) {
            known.add(Aspect.EARTH, 0);
        }

        if (!known.aspects.containsKey(Aspect.WATER)) {
            known.add(Aspect.WATER, 0);
        }

        if (!known.aspects.containsKey(Aspect.ORDER)) {
            known.add(Aspect.ORDER, 0);
        }

        if (!known.aspects.containsKey(Aspect.ENTROPY)) {
            known.add(Aspect.ENTROPY, 0);
        }

        this.aspectsDiscovered.put(player, known);
    }

    public boolean addDiscoveredAspect(String player, Aspect aspect) {
        AspectList known = this.getAspectsDiscovered(player);
        if (!known.aspects.containsKey(aspect)) {
            known.add(aspect, 0);
            this.aspectsDiscovered.put(player, known);
            return true;
        } else {
            return false;
        }
    }

    public void addScandObject(String player, String object){
        ArrayList<String> arrayList = this.objectsScanned.get(player);
        if(arrayList == null) arrayList = new ArrayList<>();
        if(arrayList.contains(object)) return;
        arrayList.add(object);
        this.objectsScanned.put(player,arrayList);
    }

    public short getAspectPoolFor(String username, Aspect aspect) {
        AspectList known = this.getAspectsDiscovered(username);
        return known != null ? (short)known.getAmount(aspect) : 0;
    }

    public boolean addAspectPool(String username, Aspect aspect, short amount) {
        AspectList al = this.getAspectsDiscovered(username);
        if (al == null) {
            al = new AspectList();
        }

        if (aspect != null && amount != 0) {
            boolean ret = false;
            if (amount > 0) {
                al.add(aspect, amount);
                ret = true;
            } else if (al.getAmount(aspect) > 0) {
                al.reduce(aspect, -amount);
                ret = true;
            }

            if (ret) {
                this.aspectsDiscovered.put(username, al);
            }

            return ret;
        } else {
            return false;
        }
    }

    public boolean setAspectPool(String username, Aspect aspect, short amount) {
        AspectList al = this.getAspectsDiscovered(username);
        if (al == null) {
            al = new AspectList();
        }

        if (aspect != null) {
            al.aspects.put(aspect, Integer.valueOf(amount));
            this.aspectsDiscovered.put(username, al);
            return true;
        } else {
            return false;
        }
    }

    public int getWarpCounter(String player) {
        int known = 0;
        if (!this.warpCount.containsKey(player)) {
            this.warpCount.put(player, 0);
        } else {
            known = (Integer)this.warpCount.get(player);
        }

        return known;
    }

    public void setWarpCounter(String player, int amount) {
        this.warpCount.put(player, amount);
    }

    public int getWarpTotal(String player) {
        return this.getWarpPerm(player) + this.getWarpTemp(player) + this.getWarpSticky(player);
    }

    public int getWarpPerm(String player) {
        int known = 0;
        if (!this.warp.containsKey(player)) {
            this.warp.put(player, 0);
        } else {
            known = (Integer)this.warp.get(player);
        }

        return known;
    }

    public int getWarpTemp(String player) {
        int known = 0;
        if (!this.warpTemp.containsKey(player)) {
            this.warpTemp.put(player, 0);
        } else {
            known = (Integer)this.warpTemp.get(player);
        }

        return known;
    }

    public int getWarpSticky(String player) {
        int known = 0;
        if (!this.warpSticky.containsKey(player)) {
            this.warpSticky.put(player, 0);
        } else {
            known = (Integer)this.warpSticky.get(player);
        }

        return known;
    }

    public void addWarpTemp(String player, int amount) {
        int er = this.getWarpTemp(player) + amount;
        this.warpTemp.put(player, Math.max(0, er));
    }

    public void addWarpPerm(String player, int amount) {
        int er = this.getWarpPerm(player) + amount;
        this.warp.put(player, Math.max(0, er));
    }

    public void addWarpSticky(String player, int amount) {
        int er = this.getWarpSticky(player) + amount;
        this.warpSticky.put(player, Math.max(0, er));
    }

    public void setWarpSticky(String player, int amount) {
        this.warpSticky.put(player, Math.max(0, amount));
    }

    public void setWarpPerm(String player, int amount) {
        this.warp.put(player, Math.max(0, amount));
    }

    public void setWarpTemp(String player, int amount) {
        this.warpTemp.put(player, Math.max(0, amount));
    }


}
