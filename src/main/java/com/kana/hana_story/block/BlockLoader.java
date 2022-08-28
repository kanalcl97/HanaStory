package com.kana.hana_story.block;

import com.kana.hana_story.hana_story;
import com.kana.hana_story.interfaces.IWithModel;
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
import org.apache.http.impl.conn.Wire;

import java.util.ArrayList;
import java.util.List;

import static com.kana.hana_story.item.ItemLoader.HANA_STORY_ITEM_TAB;

/**
 * @author kana
 * @decription TODO
 * @date 2022-08-14 0:08
 */
@Mod.EventBusSubscriber(modid = hana_story.MODID)
public final class BlockLoader {
    public static final List<Block> allBlocks = new ArrayList<>();
    public static final List<ItemBlock> allBlockItems = new ArrayList<>();

    //blocks
    public static TestBlock myBlock = new TestBlock();
    public static WiredBlock wb = new WiredBlock();
    public static BlockGrinder bg = new BlockGrinder();

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(allBlocks.toArray(new Block[0]));
        GameRegistry.registerTileEntity(bg.getTileEntityClass(), bg.getRegistryName().toString());
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(allBlockItems.toArray(new ItemBlock[0]));
    }

    @SubscribeEvent
    public static void onModelReg(ModelRegistryEvent event) {
        for (Block hbb : allBlocks)
        {
            if (hbb instanceof IWithModel)
            {
                ((IWithModel)hbb).RegisterModel();
            }
        }
    }
}
