package com.strangesmell.thaumcraft.api;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/**
 *
 * @author Azanor
 *
 * Equipped head slot items that extend this class will be able to perform most functions that
 * goggles of revealing can apart from view nodes which is handled by IRevealer.
 *配备的扩展此类的头槽项目将能够执行以下大多数功能,暴露护目镜可以与由IRevealer处理的视图节点分开。
 */

public interface IGoggles {

    /*
     * If this method returns true things like block essentia contents will be shown.
     * 如果此方法返回true，则会显示块本质内容等内容。
     */
    public boolean showIngamePopups(ItemStack itemstack, LivingEntity player);

}
