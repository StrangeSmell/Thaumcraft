package com.strangesmell.thaumcraft.common.dataGather;

import com.electronwill.nightconfig.core.EnumGetMethod;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
public class LootProvider extends LootTableProvider {
    public LootProvider(PackOutput pOutput) {
        super(pOutput, Set.of(SULFUR_BLOCK.getId()), List.of(new SubProviderEntry(CustomBlockLoot::new, LootContextParamSets.BLOCK)));
    }
    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationContext context) {

        //map.forEach((key, value) -> value.validate(context, key, value));
    }
    
}
*/
