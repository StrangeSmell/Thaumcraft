package com.strangesmell.thaumcraft.common.lib.utils;

import net.minecraft.nbt.CompoundTag;

public class Utils {

    public static Object getNBTDataFromId(CompoundTag nbt, byte id, String key) {
        switch(id) {
            case 1:
                return nbt.getByte(key);
            case 2:
                return nbt.getShort(key);
            case 3:
                return nbt.getInt(key);
            case 4:
                return nbt.getLong(key);
            case 5:
                return nbt.getFloat(key);
            case 6:
                return nbt.getDouble(key);
            case 7:
                return nbt.getByteArray(key);
            case 8:
                return nbt.getString(key);
            case 9:
                return nbt.getList(key, 10);
            case 10:
                return nbt.get(key);
            case 11:
                return nbt.getIntArray(key);
            default:
                return null;
        }
    }
}
