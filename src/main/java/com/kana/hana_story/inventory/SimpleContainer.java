package com.kana.hana_story.inventory;

import com.kana.hana_story.item.ItemLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/22 22:13
 */
public class SimpleContainer extends Container {

    private ItemStackHandler items = new ItemStackHandler(4);

    public SimpleContainer(EntityPlayer player)
    {
        super();
        for (int i = 0; i < 4; ++i)
        {
            this.addSlotToContainer(new SlotItemHandler(items, i, 38 + i * 32, 20));
        }

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 51 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 109));
        }
    }
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return new ItemStack(ItemLoader.kanaEgg).isItemEqual(playerIn.getHeldItemMainhand());
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        return null;
    }
}
