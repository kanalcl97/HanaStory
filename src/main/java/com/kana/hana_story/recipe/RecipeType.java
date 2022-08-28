package com.kana.hana_story.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/28 14:14
 */
public class RecipeType {
    public int id;

    public int makeTime;//The ticks taken to finish this recipe

    //here i suppose there should not be two list item with the same Item(Minecraft class)
    public List<ItemStack> ingredient = new ArrayList<>();
    //Notice:
    //this list need to keep the same order as the Machine's output slot.
    //e.g: result[0] ==> the first output slot of that machine.
    public List<ItemStack> result = new ArrayList<>();


}
