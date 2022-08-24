package com.kana.hana_story.item;

import com.kana.hana_story.hana_story;
import com.kana.hana_story.inventory.GuiElementLoader;
import com.kana.hana_story.util.CommonUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.kana.hana_story.item.ItemLoader.HANA_STORY_ITEM_TAB;

/**
 * @author kana
 * @decription TODO
 * @date 2022-08-13 17:26
 */
public class ItemKanaEgg extends Item {

    public String ItemName = "kana_egg";
    public CommonUtils cu = new CommonUtils();
    public ItemKanaEgg()
    {
        super();
        setRegistryName(cu.getRegisteryName(ItemName));
        setCreativeTab(HANA_STORY_ITEM_TAB);
        setUnlocalizedName(cu.getRegisteryName(ItemName));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        System.out.println("kana----------right click");
        if (!worldIn.isRemote)
        {
            if (playerIn.isSneaking() && handIn == EnumHand.MAIN_HAND)
            {
                BlockPos pos = playerIn.getPosition();
                int id = GuiElementLoader.GUI_DEMO;
                playerIn.openGui(hana_story.instance, id, worldIn, pos.getX(), pos.getY(), pos.getZ());
            }
            //worldIn.spawnEntity(new EntityGoldenEgg(worldIn, playerIn));
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}
