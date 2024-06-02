package com.strangesmell.thaumcraft.api;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
/**
 *
 * @author azanor
 *
 * Custom tile entity class I use for most of my tile entities. Setup in such a way that only
 * the nbt data within readCustomNBT / writeCustomNBT will be sent to the client when the tile
 * updates. Apart from all the normal TE data that gets sent that is.
 *
 */



/**
 * 自定义互动程序实体类我用于我的大多数互动程序实体。设置方式仅
 * 当tile时，除了发送的所有正常TE数据,readCustomNBT/writeCustomNBT中的nbt数据将被发送到客户端
 * 更新。
 */
public class TileThaumcraft extends BlockEntity {
    public TileThaumcraft(BlockEntityType<?> p_155228_, BlockPos p_155229_, BlockState p_155230_) {
        super(p_155228_, p_155229_, p_155230_);
    }
    //TODO 数据同步
}
