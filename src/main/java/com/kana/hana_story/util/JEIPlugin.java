package com.kana.hana_story.util;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IAdvancedGuiHandler;
import mezz.jei.api.gui.IGhostIngredientHandler;
import mezz.jei.api.gui.IGlobalGuiHandler;
import mezz.jei.api.gui.IGuiScreenHandler;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.*;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

import java.util.Collection;
import java.util.List;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/21 0:44
 */

@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin, IModRegistry {

    @Override
    public IJeiHelpers getJeiHelpers() {
        return null;
    }

    @Override
    public IIngredientRegistry getIngredientRegistry() {
        return null;
    }

    @Override
    public void addRecipes(Collection<?> collection, String s) {

    }

    @Override
    public <T> void handleRecipes(Class<T> aClass, IRecipeWrapperFactory<T> iRecipeWrapperFactory, String s) {

    }

    @Override
    public void addRecipeClickArea(Class<? extends GuiContainer> aClass, int i, int i1, int i2, int i3, String... strings) {

    }

    @Override
    public void addRecipeCatalyst(Object o, String... strings) {

    }

    @Override
    public void addAdvancedGuiHandlers(IAdvancedGuiHandler<?>... iAdvancedGuiHandlers) {

    }

    @Override
    public void addGlobalGuiHandlers(IGlobalGuiHandler... iGlobalGuiHandlers) {

    }

    @Override
    public <T extends GuiScreen> void addGuiScreenHandler(Class<T> aClass, IGuiScreenHandler<T> iGuiScreenHandler) {

    }

    @Override
    public <T extends GuiScreen> void addGhostIngredientHandler(Class<T> aClass, IGhostIngredientHandler<T> iGhostIngredientHandler) {

    }

    @Override
    public <T> void addIngredientInfo(T t, IIngredientType<T> iIngredientType, String... strings) {

    }

    @Override
    public <T> void addIngredientInfo(List<T> list, IIngredientType<T> iIngredientType, String... strings) {

    }

    @Override
    public IRecipeTransferRegistry getRecipeTransferRegistry() {
        return null;
    }

    @Override
    public void addRecipeRegistryPlugin(IRecipeRegistryPlugin iRecipeRegistryPlugin) {

    }

    @Override
    public <T> void addIngredientInfo(List<T> list, Class<? extends T> aClass, String... strings) {

    }

    @Override
    public <T> void addIngredientInfo(T t, Class<? extends T> aClass, String... strings) {

    }

    @Override
    public void addRecipeCategories(IRecipeCategory... iRecipeCategories) {

    }

    @Override
    public void addRecipeHandlers(IRecipeHandler... iRecipeHandlers) {

    }

    @Override
    public void addRecipes(Collection collection) {

    }

    @Override
    public void addRecipeCategoryCraftingItem(ItemStack itemStack, String... strings) {

    }

    @Override
    public void addDescription(ItemStack itemStack, String... strings) {

    }

    @Override
    public void addDescription(List<ItemStack> list, String... strings) {

    }

    @Override
    public void addAnvilRecipe(ItemStack itemStack, List<ItemStack> list, List<ItemStack> list1) {

    }
}
