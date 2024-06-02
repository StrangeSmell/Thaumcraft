package com.strangesmell.thaumcraft.common.dataGather;

import com.strangesmell.thaumcraft.Thaumcraft;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import static com.strangesmell.thaumcraft.common.config.ConfigItems.*;

public class EnglishLanguageProvider extends LanguageProvider {
    public EnglishLanguageProvider(PackOutput output) {
        super(output, Thaumcraft.MODID, "en_us");
    }

    @Override
    public void addTranslations() {
        // 等价于 this.add("item.xiaozhong.sulfur_dust", "Sulfur Dust")
        this.add(itemThaumonomicon.get(), "Thaumonomicon");
        // 等价于 this.add("block.xiaozhong.sulfur_block", "Sulfur Block")
        this.add(itemThaumometer.get(), "Thaumometer");
        this.add(itemResearchNotes.get(), "ResearchNotes");
    }
}
