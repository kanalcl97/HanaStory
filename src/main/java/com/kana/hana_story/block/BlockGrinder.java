package com.kana.hana_story.block;

import com.kana.hana_story.hana_story;
import com.kana.hana_story.inventory.GuiElementLoader;
import com.kana.hana_story.tileentity.TileEntityGrinder;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/25 22:28
 */
public class BlockGrinder extends BlockWithTileEntity<TileEntityGrinder> {
    public BlockGrinder() {
        super(Material.ROCK, "block_grinder");
        this.setHardness(0.5F);
    }
    public static final AxisAlignedBB ActAABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.8125D, 0.9375D);
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return ActAABB;
    }

    @Override
    public Class getTileEntityClass() {
        return TileEntityGrinder.class;
    }

    @Nullable
    @Override
    public TileEntityGrinder createTileEntity(World world, IBlockState state) {
        return new TileEntityGrinder();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote)
        {
            TileEntityGrinder tile = getTileEntity(worldIn, pos);
            //IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing);
            if (!playerIn.isSneaking())
            {
                playerIn.openGui(hana_story.instance, GuiElementLoader.GUI_GRINDER, worldIn, pos.getX(), pos.getY(), pos.getZ());
            }
        }

        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
        TileEntityGrinder tile = getTileEntity(worldIn, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack = itemHandler.getStackInSlot(0);
        if (!stack.isEmpty()) {
            EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
            worldIn.spawnEntity(item);
        }
        super.breakBlock(worldIn, pos, state);
    }
    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }
}
