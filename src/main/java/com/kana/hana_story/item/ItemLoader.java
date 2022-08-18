package com.kana.hana_story.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author kana
 * @decription TODO
 * @date 2022-08-13 17:27
 */

@Mod.EventBusSubscriber(modid = "hana_story")
public class ItemLoader {

    public static final CreativeTabs HANA_STORY_ITEM_TAB = new CreativeTabs("hanaStory Items") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.BED);
        }
    };

    public static Item kanaEgg = new Item();
    public ItemLoader(FMLPreInitializationEvent event)
    {
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event)
    {
        kanaEgg.setRegistryName("hana_story:kana_egg");
        kanaEgg.setCreativeTab(HANA_STORY_ITEM_TAB);
        kanaEgg.setUnlocalizedName("hana_story:kana_egg");
        event.getRegistry().registerAll(kanaEgg);
    }

    @SubscribeEvent
    public static void onModelReg(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ItemLoader.kanaEgg, 0, new ModelResourceLocation(ItemLoader.kanaEgg.getRegistryName(), "inventory"));
    }
}
