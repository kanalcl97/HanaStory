package com.kana.hana_story.item;

import com.kana.hana_story.util.CommonUtils;
import net.minecraft.item.Item;

import static com.kana.hana_story.item.ItemLoader.HANA_STORY_ITEM_TAB;

/**
 * @author kana
 * @decription TODO
 * @date 2022-08-13 17:26
 */
public class ItemKanaEgg extends Item {

    public String ItemName = "kana_egg";
    public CommonUtils cu = new CommonUtils();
    public ItemKanaEgg()
    {
        super();
        setRegistryName(cu.getRegisteryName(ItemName));
        setCreativeTab(HANA_STORY_ITEM_TAB);
        setUnlocalizedName(cu.getRegisteryName(ItemName));
    }
}
