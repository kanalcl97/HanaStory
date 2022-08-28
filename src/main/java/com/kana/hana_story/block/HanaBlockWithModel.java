package com.kana.hana_story.block;

import com.kana.hana_story.interfaces.IWithModel;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/25 10:33
 */
public class HanaBlockWithModel extends HanaBlockBase implements IWithModel {
    public HanaBlockWithModel(Material materialIn, String name) {
        super(materialIn, name);
    }

    @Override
    public void RegisterModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }
}
