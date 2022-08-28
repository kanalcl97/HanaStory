package com.kana.hana_story.tileentity;

import com.kana.hana_story.hana_story;
import com.kana.hana_story.recipe.RecipeType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/25 22:33
 */
public class TileEntityGrinder extends TileEntity implements ITickable {

    private final int INPUT_SLOT1 = 0;
    private final int OUTPUT_SLOT1 = 1;
    private ItemStackHandler inventory = new ItemStackHandler(2);

    public int workTime = 0;
    public int totalWorkTime = 0;//for client world use
    private RecipeType curRecipe;
    private boolean isWorking;

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        compound.setTag("inventory", inventory.serializeNBT());
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        inventory.deserializeNBT(compound.getCompoundTag("inventory"));
        super.readFromNBT(compound);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory : super.getCapability(capability, facing);
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        final NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);

        return new SPacketUpdateTileEntity(getPos(), 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, @Nonnull IBlockState oldState, @Nonnull IBlockState newState) {
        return oldState.getBlock() != newState.getBlock();
    }

    @SideOnly(value = Side.CLIENT)
    public int getWorkProgressScaled(int scale)
    {
        if (totalWorkTime == 0) return 0;
        return workTime * scale / totalWorkTime;
    }

    @Override
    public void update() {

        if(world.isRemote)
            return;

        if (CheckRunCond())
        {
            isWorking = true;
            workTime++;

            if (workTime >= curRecipe.makeTime)
            {
                workTime = 0;
                genResult();
            }
        }
        else
        {
            isWorking = false;
            workTime = 0;
        }
    }

    private boolean CheckRunCond()
    {
        List<ItemStack> inputs = new ArrayList<>();
        inputs.add(inventory.getStackInSlot(INPUT_SLOT1));
        RecipeType rt = hana_story.instance.extractorRecipe.getRecipeFromInput(inputs);
        if (rt == null)
        {
            curRecipe = null;
            return false;
        }
        //System.out.println("kana----------found recipe for grinder:" + rt.id);
        ItemStack curOutSlot = inventory.getStackInSlot(OUTPUT_SLOT1);

        if (!curOutSlot.isEmpty() && (!curOutSlot.isItemEqual(rt.result.get(0))
            || (curOutSlot.isItemEqual(rt.result.get(0)) && rt.result.get(0).getCount() + curOutSlot.getCount() >= curOutSlot.getMaxStackSize())
        ))
        {
            curRecipe = null;
            return false;
        }

        if (inventory.getStackInSlot(INPUT_SLOT1).getCount() < rt.ingredient.get(INPUT_SLOT1).getCount())
        {
            curRecipe = null;
            return false;
        }

        if (curRecipe == null)
        {
            curRecipe = rt;
            totalWorkTime = curRecipe.makeTime;
        }

        return true;
    }

    private void genResult()
    {
        if (curRecipe == null) return;
        //List<ItemStack> res = curRecipe.result;
        boolean opSuc = false;
        ItemStack curOutSlot = inventory.getStackInSlot(OUTPUT_SLOT1);
        if (curOutSlot.isEmpty())
        {
            inventory.setStackInSlot(OUTPUT_SLOT1, curRecipe.result.get(0));
            opSuc = true;
        }
        else if (curOutSlot.getCount() + curRecipe.result.get(0).getCount() <= curOutSlot.getMaxStackSize())
        {
            curOutSlot.setCount(curOutSlot.getCount() + curRecipe.result.get(0).getCount());
            opSuc = true;
        }
        if (opSuc)
        {
            inventory.getStackInSlot(INPUT_SLOT1).setCount(inventory.getStackInSlot(INPUT_SLOT1).getCount() - curRecipe.ingredient.get(INPUT_SLOT1).getCount());
            if (inventory.getStackInSlot(INPUT_SLOT1).getCount() <= 0)
            {
                inventory.setStackInSlot(INPUT_SLOT1, ItemStack.EMPTY);
            }
        }
    }
}
