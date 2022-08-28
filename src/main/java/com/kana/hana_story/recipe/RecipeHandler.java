package com.kana.hana_story.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/28 14:12
 */
public class RecipeHandler<T extends RecipeType>{
    public List<T> recipes = new ArrayList<>();

    public RecipeHandler(String recipePath)
    {
        ReadfromJson(recipePath);
    }

    public T getRecipeFromInput(List<ItemStack> inputs)
    {
        for (T rc: recipes)
        {
            int matCnt = 0;
            for(ItemStack itemStack : rc.ingredient)
            {
                if (isItemInList(itemStack, inputs))
                {
                    matCnt++;
                }
            }
            if (matCnt == inputs.size()) return rc;
        }
        return null;
    }

    private boolean isItemInList(ItemStack item, List<ItemStack> list)
    {
        for(ItemStack itemStack : list)
        {
            if (item.isItemEqual(itemStack)) return true;
        }
        return false;
    }

    public List<ItemStack> getResultFromInput(List<ItemStack> inputs)
    {
        T rec = getRecipeFromInput(inputs);
        if (rec == null) return null;

        return rec.result;
    }

    protected void ReadfromJson(String path)
    {

    }
}
