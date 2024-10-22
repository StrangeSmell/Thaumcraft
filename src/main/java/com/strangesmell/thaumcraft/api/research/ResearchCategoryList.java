package com.strangesmell.thaumcraft.api.research;

import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class ResearchCategoryList {


    /** Is the smallest column used on the GUI. */
    public int minDisplayColumn;

    /** Is the smallest row used on the GUI. */
    public int minDisplayRow;

    /** Is the biggest column used on the GUI. */
    public int maxDisplayColumn;

    /** Is the biggest row used on the GUI. */
    public int maxDisplayRow;

    /** display variables **/
    public ResourceLocation icon;
    public ResourceLocation background;

    public ResearchCategoryList(ResourceLocation icon, ResourceLocation background) {
        this.icon = icon;
        this.background = background;
    }

    //Research
    public Map<String, ResearchItem> research = new HashMap<String,ResearchItem>();

}
