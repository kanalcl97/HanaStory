package com.kana.hana_story.block;

import com.kana.hana_story.util.CommonUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import static com.kana.hana_story.item.ItemLoader.HANA_STORY_ITEM_TAB;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/24 22:16
 */
public class HanaBlockBase extends Block {

    protected CommonUtils cu = new CommonUtils();
    public HanaBlockBase(Material materialIn, String name) {
        super(materialIn);
        this.setRegistryName(cu.getRegisteryName(name));
        this.setCreativeTab(HANA_STORY_ITEM_TAB);
    }
}
