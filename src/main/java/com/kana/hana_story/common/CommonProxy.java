package com.kana.hana_story.common;

import com.kana.hana_story.inventory.GuiElementLoader;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {
        new GuiElementLoader();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerItemRender(Item i, int meta, String id) {

    }
}