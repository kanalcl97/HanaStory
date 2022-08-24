package com.kana.hana_story.inventory;

import com.kana.hana_story.client.SimpleGuiContainer;
import com.kana.hana_story.hana_story;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import javax.annotation.Nullable;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/22 22:03
 */
public class GuiElementLoader implements IGuiHandler {
    public static final int GUI_DEMO = 1;

    public GuiElementLoader()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(hana_story.instance, this);
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID)
        {
            case GUI_DEMO:
                return new SimpleContainer(player);
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID)
        {
            case GUI_DEMO:
                return new SimpleGuiContainer(new SimpleContainer(player));
            default:
                return null;
        }
    }
}
