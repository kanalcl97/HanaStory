package com.kana.hana_story.block;

import com.kana.hana_story.item.ItemLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.kana.hana_story.item.ItemLoader.HANA_STORY_ITEM_TAB;

/**
 * @author kana
 * @decription TODO
 * @date 2022-08-14 0:08
 */
@Mod.EventBusSubscriber(modid = "hana_story")
public final class BlockLoader {

    public static Block myBlock;

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        myBlock = new TestBlock().setRegistryName("hana_story", "test_block")
                .setCreativeTab(HANA_STORY_ITEM_TAB);
        event.getRegistry().register(myBlock);
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        // 注意这个 ItemBlock 使用了和它对应的方块一样的注册名。
        // 对于所有有物品形态的方块，其物品的注册名和它自己的注册名需要保持一致。
        event.getRegistry().register(
                new ItemBlock(myBlock).setRegistryName("hana_story", "test_block")
        );
    }

    @SubscribeEvent
    public static void onModelReg(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(myBlock), 0, new ModelResourceLocation(myBlock.getRegistryName(), "inventory"));
    }
}
