package com.strangesmell.thaumcraft.common.config;

import com.strangesmell.thaumcraft.Thaumcraft;
import com.strangesmell.thaumcraft.client.gui.BookTabBase;
import net.minecraft.client.gui.components.Button;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigGui {
    public static HashMap<String, ResourceLocation> BookGuiResourceLocation = new HashMap<>();

    public static HashMap<Integer,String> BookBackGroundId = new HashMap<>();
    private static int bookBackGroundId = 0;

    public static HashMap<Integer, ResourceLocation> BookTabId = new HashMap<>();
    private static int bookTabId = 0;

    public static List<Button> buttons;

    public static void init() {

        initBookBackGroundId(Thaumcraft.MODID+"BookBackGround1");
        initBookBackGroundId(Thaumcraft.MODID+"BookBackGround1");
        initBookBackGroundId(Thaumcraft.MODID+"BookBackGround1");
        initBookBackGroundId(Thaumcraft.MODID+"BookBackGround1");
        initBookBackGroundId(Thaumcraft.MODID+"BookBackGround1");
        initBookBackGroundId(Thaumcraft.MODID+"BookBackGround2");


        initBookTabId(BOOK_GUI_TAB0);
        initBookTabId(BOOK_GUI_TAB1);
        initBookTabId(BOOK_GUI_TAB2);
        initBookTabId(BOOK_GUI_TAB3);
        initBookTabId(BOOK_GUI_TAB4);
        initBookTabId(BOOK_GUI_TAB5);



        //书框
        BookGuiResourceLocation.put(Thaumcraft.MODID+"BookGui",new ResourceLocation(Thaumcraft.MODID, "textures/gui/gui_research.png"));
        //背景
        BookGuiResourceLocation.put(Thaumcraft.MODID+"BookBackGround1",new ResourceLocation(Thaumcraft.MODID, "textures/gui/gui_researchback.png"));
        //邪术背景
        BookGuiResourceLocation.put(Thaumcraft.MODID+"BookBackGround2",new ResourceLocation(Thaumcraft.MODID, "textures/gui/gui_researchbackeldritch.png"));
    }


    public static void initBookBackGroundId(String resourceLocation){
        BookBackGroundId.put(bookBackGroundId,resourceLocation);
        bookBackGroundId++;
    }

    public static void initBookTabId(ResourceLocation resourceLocation){
        BookTabId.put(bookTabId,resourceLocation);
        bookTabId++;
    }

    public static int getBookBackGroundId(){
        return bookBackGroundId;
    }
    public static int getBookTabId(){
        return bookTabId;
    }

    static ResourceLocation BOOK_GUI_TAB0 = new ResourceLocation(Thaumcraft.MODID, "textures/item/thaumonomiconcheat.png");
    static ResourceLocation BOOK_GUI_TAB1 = new ResourceLocation(Thaumcraft.MODID, "textures/misc/r_thaumaturgy.png");
    static ResourceLocation BOOK_GUI_TAB2 = new ResourceLocation(Thaumcraft.MODID, "textures/misc/r_crucible.png");
    static ResourceLocation BOOK_GUI_TAB3 = new ResourceLocation(Thaumcraft.MODID, "textures/misc/r_artifice.png");
    static ResourceLocation BOOK_GUI_TAB4 = new ResourceLocation(Thaumcraft.MODID, "textures/misc/r_golemancy.png");
    static ResourceLocation BOOK_GUI_TAB5 = new ResourceLocation(Thaumcraft.MODID, "textures/misc/r_eldritch.png");
}
