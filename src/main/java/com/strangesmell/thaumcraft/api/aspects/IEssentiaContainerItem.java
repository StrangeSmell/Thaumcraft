package com.strangesmell.thaumcraft.api.aspects;

import net.minecraft.world.item.ItemStack;

/**
 *
 * @author azanor
 *
 * Used by wispy essences and essentia phials to hold their aspects.
 * Useful for similar item containers that store their aspect information in nbt form so TC
 * automatically picks up the aspects they contain
 * 适用于以nbt形式存储方面信息的类似容器，会自动拾取它们所包含的方面
 */
public interface IEssentiaContainerItem {
    public AspectList getAspects(ItemStack itemstack);
    public void setAspects(ItemStack itemstack, AspectList aspects);
}

//Example implementation
/*
	@Override
	public AspectList getAspects(ItemStack itemstack) {
		if (itemstack.hasTagCompound()) {
			AspectList aspects = new AspectList();
			aspects.readFromNBT(itemstack.getTagCompound());
			return aspects.size()>0?aspects:null;
		}
		return null;
	}

	@Override
	public void setAspects(ItemStack itemstack, AspectList aspects) {
		if (!itemstack.hasTagCompound()) itemstack.setTagCompound(new NBTTagCompound());
		aspects.writeToNBT(itemstack.getTagCompound());
	}
*/