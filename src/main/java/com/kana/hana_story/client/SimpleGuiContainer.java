package com.kana.hana_story.client;

import com.kana.hana_story.hana_story;
import com.kana.hana_story.item.ItemLoader;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/22 22:15
 */
@SideOnly(Side.CLIENT)
public class SimpleGuiContainer extends GuiContainer {

    private static final String TEXTURE_PATH = hana_story.MODID + ":" + "textures/gui/simpleguitest.png";
    private static final ResourceLocation TEXTURE = new ResourceLocation(TEXTURE_PATH);

    public SimpleGuiContainer(Container inventorySlotsIn) {
        super(inventorySlotsIn);
        this.xSize = 176;
        this.ySize = 133;
    }


    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        //this.drawVerticalLine(30, 19, 36, 0xFF000000);
        //this.drawHorizontalLine(8, 167, 43, 0xFF000000);

        String title = I18n.format("container.hana_story.simpletitle");
        this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0x404040);

        ItemStack item = new ItemStack(ItemLoader.kanaEgg);
        this.itemRender.renderItemAndEffectIntoGUI(item, 8, 20);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(TEXTURE);
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;

        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
    }
}
