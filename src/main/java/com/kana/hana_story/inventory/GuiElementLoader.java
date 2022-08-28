package com.kana.hana_story.inventory;

import com.kana.hana_story.client.SimpleGuiContainer;
import com.kana.hana_story.gui.ContainerGrinder;
import com.kana.hana_story.gui.GuiGrinder;
import com.kana.hana_story.hana_story;
import com.kana.hana_story.tileentity.TileEntityGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
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
    public static final int GUI_GRINDER = 2;

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
            case GUI_GRINDER:
                return new ContainerGrinder(player.inventory, (TileEntityGrinder) world.getTileEntity(new BlockPos(x, y, z)));
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
            case GUI_GRINDER:
                return new GuiGrinder((Container) getServerGuiElement(ID, player, world, x, y, z),player.inventory, (TileEntityGrinder) world.getTileEntity(new BlockPos(x, y, z)));
            default:
                return null;
        }
    }
}
