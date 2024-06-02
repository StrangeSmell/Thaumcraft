package com.strangesmell.thaumcraft.api;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;

public class WorldCoordinates implements Comparable{
    /*x坐标*/
    public int x;

    /** the y coordinate */
    public int y;

    /** the z coordinate */
    public int z;

    public String dim;

    public WorldCoordinates() {}

    public WorldCoordinates(int par1, int par2, int par3, String d)
    {
        this.x = par1;
        this.y = par2;
        this.z = par3;
        this.dim = d;
    }

    public WorldCoordinates(BlockEntity tile)
    {
        this.x = tile.getBlockPos().getX();
        this.y = tile.getBlockPos().getY();
        this.z = tile.getBlockPos().getZ();
        this.dim = tile.getLevel().dimension().toString();
    }

    public WorldCoordinates(WorldCoordinates par1ChunkCoordinates)
    {
        this.x = par1ChunkCoordinates.x;
        this.y = par1ChunkCoordinates.y;
        this.z = par1ChunkCoordinates.z;
        this.dim = par1ChunkCoordinates.dim;
    }

    public boolean equals(Object par1Obj)
    {
        if (!(par1Obj instanceof WorldCoordinates))
        {
            return false;
        }
        else
        {
            WorldCoordinates coordinates = (WorldCoordinates)par1Obj;
            return this.x == coordinates.x && this.y == coordinates.y && this.z == coordinates.z && this.dim == coordinates.dim ;
        }
    }

    public int hashCode()
    {   //modify ???  can this.dim.hashCode()?
        return this.x + this.y << 8 + this.z << 16 + this.dim.hashCode() << 24;
    }

    /**
     * Compare the coordinate with another coordinate
     */
    public int compareWorldCoordinate(WorldCoordinates par1)
    {
        return this.dim == par1.dim ? (
                this.y == par1.y ? (this.z == par1.z ? this.x - par1.x : this.z - par1.z) : this.y - par1.y) : -1;
    }

    public void set(int par1, int par2, int par3, String d)
    {
        this.x = par1;
        this.y = par2;
        this.z = par3;
        this.dim = d;
    }

    /**
     * Returns the squared distance between this coordinates and the coordinates given as argument.
     */
    public float getDistanceSquared(int par1, int par2, int par3)
    {
        float f = (float)(this.x - par1);
        float f1 = (float)(this.y - par2);
        float f2 = (float)(this.z - par3);
        return f * f + f1 * f1 + f2 * f2;
    }

    /**
     * Return the squared distance between this coordinates and the ChunkCoordinates given as argument.
     */
    public float getDistanceSquaredToWorldCoordinates(WorldCoordinates par1ChunkCoordinates)
    {
        return this.getDistanceSquared(par1ChunkCoordinates.x, par1ChunkCoordinates.y, par1ChunkCoordinates.z);
    }

    public int compareTo(Object par1Obj)
    {
        return this.compareWorldCoordinate((WorldCoordinates)par1Obj);
    }

    public void readNBT(CompoundTag nbt) {
        this.x = nbt.getInt("w_x");
        this.y = nbt.getInt("w_y");
        this.z = nbt.getInt("w_z");
        this.dim = nbt.getString("w_d");
    }

    public void writeNBT(CompoundTag nbt) {
        nbt.putInt("w_x",x);
        nbt.putInt("w_y",y);
        nbt.putInt("w_z",z);
        nbt.putString("w_d",dim);
    }
}
