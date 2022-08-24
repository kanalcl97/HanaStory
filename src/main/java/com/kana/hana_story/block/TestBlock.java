package com.kana.hana_story.block;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
/**
 * @author kana
 * @decription TODO
 * @date 2022-08-13 21:42
 */
public class TestBlock extends HanaBlockBase{
    public TestBlock()
    {
        super(Material.GROUND, "test_block");
        this.setUnlocalizedName("grassBlock");
        this.setHardness(0.5F);
    }
}
