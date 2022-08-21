package com.kana.hana_story.food;

import com.kana.hana_story.util.CommonUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import static com.kana.hana_story.item.ItemLoader.HANA_STORY_ITEM_TAB;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/20 17:28
 */
public class hanaPie extends ItemFood {

    private String Name = "hana_pie";
    private CommonUtils cu = new CommonUtils();
    public hanaPie(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.setAlwaysEdible();
        this.setRegistryName(cu.getRegisteryName(Name));
        this.setUnlocalizedName(cu.getRegisteryName(Name));
        this.setCreativeTab(HANA_STORY_ITEM_TAB);
        this.setPotionEffect(new PotionEffect(MobEffects.REGENERATION, 2400, 0),1);
    }

}
