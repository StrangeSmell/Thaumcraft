package com.strangesmell.thaumcraft.common.items.relics;

import com.strangesmell.thaumcraft.api.ThaumcraftApi;
import com.strangesmell.thaumcraft.api.research.ScanManager;
import com.strangesmell.thaumcraft.api.research.ScanResult;
import com.strangesmell.thaumcraft.client.renderers.models.ThaumometerItemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class ItemThaumometer extends Item implements IClientItemExtensions {
    public ItemThaumometer(Properties p_41383_) {
        super(p_41383_);
    }

    public ScanResult doScan(){
        return  null;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        player.startUsingItem(interactionHand);
        if(level.isClientSide){

        }
        return InteractionResultHolder.pass(itemstack);
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
            if(pRemainingUseDuration<=1){
                Player player=(Player) pLivingEntity;
                HitResult hitResult= ThaumcraftApi.getHitResult(pLevel,player );
                if( pLivingEntity.getName().getString().equals(Minecraft.getInstance().player.getName().getString())  & (hitResult.getType() != HitResult.Type.MISS)){
                    Vec3 pos;
                    if (hitResult instanceof EntityHitResult) {
                        EntityHitResult entityHitResult = (EntityHitResult)hitResult;
                        Entity entity = entityHitResult.getEntity();
                        pos = new Vec3(entity.getX(), entity.getY() + (double)(entity.getEyeHeight() / 2.0f), entity.getZ());
                        ScanManager.doEntityScan(player,entity);
                    } else {
                        BlockHitResult blockHitResult = (BlockHitResult)hitResult;
                        BlockPos blockPos = blockHitResult.getBlockPos();
                        pos = new Vec3((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5);
                        ScanManager.doObjectScan(player,pLevel.getBlockState(blockPos).getBlock());

                    }
            }
        }
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new ThaumometerItemRenderer();
            }
        });
    }



/*
    private ScanResult doScan(ItemStack stack, Level world, Player p, int count) {
        Entity pointedEntity = EntityUtils.getPointedEntity(p.level(), p, 0.5D, 10.0D, 0.0F, true);
        if (pointedEntity != null) {
            ScanResult sr = new ScanResult((byte)2, 0, 0, pointedEntity, "");
            if (ScanManager.isValidScanTarget(p, sr, "@")) {
                Thaumcraft.proxy.blockRunes(world, pointedEntity.field_70165_t - 0.5D, pointedEntity.field_70163_u + (double)(pointedEntity.func_70047_e() / 2.0F), pointedEntity.field_70161_v - 0.5D, 0.3F + world.field_73012_v.nextFloat() * 0.7F, 0.0F, 0.3F + world.field_73012_v.nextFloat() * 0.7F, (int)(pointedEntity.field_70131_O * 15.0F), 0.03F);
                return sr;
            } else {
                return null;
            }
        } else {
            MovingObjectPosition mop = this.func_77621_a(p.field_70170_p, p, true);
            if (mop != null && mop.field_72313_a == MovingObjectType.BLOCK) {
                TileEntity tile = world.func_147438_o(mop.field_72311_b, mop.field_72312_c, mop.field_72309_d);
                if (tile instanceof INode) {
                    ScanResult sr = new ScanResult((byte)3, 0, 0, (Entity)null, "NODE" + ((INode)tile).getId());
                    if (ScanManager.isValidScanTarget(p, sr, "@")) {
                        Thaumcraft.proxy.blockRunes(world, (double)mop.field_72311_b, (double)mop.field_72312_c + 0.25D, (double)mop.field_72309_d, 0.3F + world.field_73012_v.nextFloat() * 0.7F, 0.0F, 0.3F + world.field_73012_v.nextFloat() * 0.7F, 15, 0.03F);
                        return sr;
                    }

                    return null;
                }

                Block bi = world.func_147439_a(mop.field_72311_b, mop.field_72312_c, mop.field_72309_d);
                if (bi != Blocks.field_150350_a) {
                    int md = bi.func_149643_k(world, mop.field_72311_b, mop.field_72312_c, mop.field_72309_d);
                    ItemStack is = bi.getPickBlock(mop, p.field_70170_p, mop.field_72311_b, mop.field_72312_c, mop.field_72309_d);
                    ScanResult sr = null;

                    try {
                        if (is == null) {
                            is = BlockUtils.createStackedBlock(bi, md);
                        }
                    } catch (Exception var14) {
                    }

                    try {
                        if (is == null) {
                            sr = new ScanResult((byte)1, Block.func_149682_b(bi), md, (Entity)null, "");
                        } else {
                            sr = new ScanResult((byte)1, Item.func_150891_b(is.func_77973_b()), is.func_77960_j(), (Entity)null, "");
                        }
                    } catch (Exception var13) {
                    }

                    if (ScanManager.isValidScanTarget(p, sr, "@")) {
                        Thaumcraft.proxy.blockRunes(world, (double)mop.field_72311_b, (double)mop.field_72312_c + 0.25D, (double)mop.field_72309_d, 0.3F + world.field_73012_v.nextFloat() * 0.7F, 0.0F, 0.3F + world.field_73012_v.nextFloat() * 0.7F, 15, 0.03F);
                        return sr;
                    }

                    return null;
                }
            }

            Iterator i$ = ThaumcraftApi.scanEventhandlers.iterator();

            ScanResult scan;
            do {
                if (!i$.hasNext()) {
                    return null;
                }

                IScanEventHandler seh = (IScanEventHandler)i$.next();
                scan = seh.scanPhenomena(stack, world, p);
            } while(scan == null);

            return scan;
        }
    }
*/

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 40;
    }
}
