package com.kana.hana_story.recipe;

import com.kana.hana_story.food.FoodLoader;
import com.kana.hana_story.item.ItemLoader;
import net.minecraft.init.Items;
import net.minecraft.item.ItemLead;
import net.minecraft.item.ItemStack;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/28 14:20
 */
public class ExtractorRecipe extends RecipeHandler<RecipeType> {

    public ExtractorRecipe(String recipePath) {
        super(recipePath);
    }

    @Override
    protected void ReadfromJson(String path) {
        RecipeType rt = new RecipeType();
        rt.makeTime = 200;
        rt.ingredient.add(new ItemStack(FoodLoader.hanap, 5));
        rt.result.add(new ItemStack(ItemLoader.kanaEgg, 1));
        rt.id = 1;
        recipes.add(rt);
    }
}
