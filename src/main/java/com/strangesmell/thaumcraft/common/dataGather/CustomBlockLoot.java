package com.strangesmell.thaumcraft.common.dataGather;

import com.google.common.collect.Iterables;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.Set;

import static com.strangesmell.thaumcraft.common.config.ConfigBlocks.BLOCKS;

public class CustomBlockLoot extends BlockLootSubProvider {
    protected CustomBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());

    }

    @Override
    protected void generate() {
        //this.dropSelf(.get());
    }

    @Nonnull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Iterables.transform(BLOCKS.getEntries(), RegistryObject::get);
    }
}
