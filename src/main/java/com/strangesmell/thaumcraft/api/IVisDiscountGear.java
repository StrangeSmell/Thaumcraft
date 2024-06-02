package com.strangesmell.thaumcraft.api;


import com.strangesmell.thaumcraft.api.aspects.Aspect;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/**
 * @author Azanor
 * ItemArmor with this interface will grant a discount to the vis cost of actions the wearer performs with casting wands.
 * The amount returned is the percentage by which the cost is discounted. There is a built-int max discount of 50%, but
 * individual items really shouldn't have a discount more than 5%
 */

/**
* ItemArmor将为佩戴者使用投掷魔杖执行的动作的视觉成本提供折扣。返回的金额是成本贴现的百分比。有50%的内部最大折扣，但个别商品的折扣不应该超过5%
*
* */
public interface IVisDiscountGear {

    int getVisDiscount(ItemStack stack, Player player, Aspect aspect);

}
