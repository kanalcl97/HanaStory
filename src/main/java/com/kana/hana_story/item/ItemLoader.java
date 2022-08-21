package com.kana.hana_story.item;

import com.kana.hana_story.food.FoodLoader;
import com.kana.hana_story.hana_story;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * @author kana
 * @decription TODO
 * @date 2022-08-13 17:27
 */

@Mod.EventBusSubscriber(modid = hana_story.MODID)
public class ItemLoader {

    public static final CreativeTabs HANA_STORY_ITEM_TAB = new CreativeTabs("hanaStory Items") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.BED);
        }
    };
    public static FoodLoader fdLoader = new FoodLoader();
    public static ItemKanaEgg kanaEgg = new ItemKanaEgg();
    public ItemLoader(FMLPreInitializationEvent event)
    {
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event)
    {
        fdLoader.registryFoods(event);
        registerCommonItems(event);
        GameRegistry.addShapedRecipe(kanaEgg.getRegistryName(), null, new ItemStack(kanaEgg, 1), "###", "#*#", "###", '#', Items.GOLD_INGOT, '*', Items.EGG);

    }

    private static void registerCommonItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(kanaEgg);
    }

    @SubscribeEvent
    public static void onModelReg(ModelRegistryEvent event) {
        fdLoader.registryFoodModels(event);
        registerCommonItemModels(event);
    }

    private static void registerCommonItemModels(ModelRegistryEvent event)
    {
        ModelLoader.setCustomModelResourceLocation(ItemLoader.kanaEgg, 0, new ModelResourceLocation(ItemLoader.kanaEgg.getRegistryName(), "inventory"));
    }
}
