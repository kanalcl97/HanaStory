package com.kana.hana_story.block;

import com.kana.hana_story.util.CommonUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

import static com.kana.hana_story.item.ItemLoader.HANA_STORY_ITEM_TAB;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/24 22:16
 */
public class HanaBlockBase extends Block {

    protected CommonUtils cu = new CommonUtils();
    protected ItemBlock b_item;
    public HanaBlockBase(Material materialIn, String name) {
        super(materialIn);
        this.setRegistryName(cu.getRegisteryName(name));
        this.setCreativeTab(HANA_STORY_ITEM_TAB);
        this.setUnlocalizedName(name);
        BlockLoader.allBlocks.add(this);
        b_item = new ItemBlock(this);
        b_item.setRegistryName(cu.getRegisteryName(name));
        BlockLoader.allBlockItems.add(b_item);
    }
}
