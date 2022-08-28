package com.kana.hana_story.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

import static com.kana.hana_story.item.ItemLoader.HANA_STORY_ITEM_TAB;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/24 22:06
 */
public class WiredBlock extends HanaBlockBase {
    public WiredBlock() {
        super(Material.SAND, "wired_block");
    }

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

}

