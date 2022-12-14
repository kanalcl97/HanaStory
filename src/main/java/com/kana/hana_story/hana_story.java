package com.kana.hana_story;

import com.kana.hana_story.common.CommonProxy;
import com.kana.hana_story.recipe.ExtractorRecipe;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = hana_story.MODID, name = "HanaStory", version = "1.0.0", acceptedMinecraftVersions = "1.12.2")
public class hana_story
{
    public static final String MODID = "hana_story";
    @Mod.Instance(hana_story.MODID)
    public static hana_story instance;

    public ExtractorRecipe extractorRecipe;

    @SidedProxy(clientSide = "com.kana.hana_story.client.ClientProxy",
                serverSide = "com.kana.hana_story.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Hello from Kana's mod!");
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}