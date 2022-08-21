package com.kana.hana_story.food;

import com.kana.hana_story.item.ItemLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/20 16:58
 */
public class FoodLoader {

    public hanaPie hanap;
    public FoodLoader()
    {
        hanap = new hanaPie(1,2,false);
    }

    public void registryFoods(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(hanap);
    }

    public void registryFoodModels(ModelRegistryEvent event)
    {
        ModelLoader.setCustomModelResourceLocation(hanap, 0, new ModelResourceLocation(hanap.getRegistryName(), "inventory"));
    }
}
