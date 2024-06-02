package com.strangesmell.thaumcraft.common.dataGather;

import com.strangesmell.thaumcraft.Thaumcraft;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import static com.strangesmell.thaumcraft.common.config.ConfigItems.*;

public class ChineseLanguageProvider extends LanguageProvider {
    public ChineseLanguageProvider(PackOutput output) {
        super(output, Thaumcraft.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        // 等价于 this.add("item.xiaozhong.sulfur_dust", "Sulfur Dust")
        this.add(itemThaumonomicon.get(), "魔导书");
        // 等价于 this.add("block.xiaozhong.sulfur_block", "Sulfur Block")
        this.add(itemThaumometer.get(), "魔导透镜");
        this.add(itemResearchNotes.get(), "研究笔记");
    }
}
