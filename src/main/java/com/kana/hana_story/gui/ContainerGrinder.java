package com.kana.hana_story.gui;

import com.kana.hana_story.tileentity.TileEntityGrinder;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/26 21:27
 */
public class ContainerGrinder extends Container {

    public int lastWorkTime = 0;
    public int totalWorkTime = 0;
    public TileEntityGrinder teg;

    public ContainerGrinder(InventoryPlayer playerInv, final TileEntityGrinder tegrinder) {
        teg = tegrinder;
        IItemHandler inventory = tegrinder.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        addSlotToContainer(new SlotItemHandler(inventory, 0, 69, 23) {
            @Override
            public void onSlotChanged() {
                tegrinder.markDirty();
            }
        });

        addSlotToContainer(new SlotItemHandler(inventory, 1, 122, 23) {
            @Override
            public void onSlotChanged() {
                tegrinder.markDirty();
            }
        });

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 19 + j * 19, 62 + i * 19));
            }
        }

        for (int k = 0; k < 9; k++) {
            addSlotToContainer(new Slot(playerInv, k, 19 + k * 19, 123));
        }
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (IContainerListener crafting : listeners) {
            if (lastWorkTime != teg.workTime){
                crafting.sendWindowProperty(this, 0, teg.workTime);
            }

            if (totalWorkTime != teg.totalWorkTime)
            {
                crafting.sendWindowProperty(this, 1, teg.totalWorkTime);
            }
        }
        lastWorkTime = teg.workTime;
        totalWorkTime = teg.totalWorkTime;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int data) {
        if (id == 0) {
            teg.workTime = data;
        }
        else if (id == 1)
        {
            teg.totalWorkTime = data;
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();

            if (index < containerSlots) {
                if (!this.mergeItemStack(itemstack1, containerSlots, inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, containerSlots, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }
}
