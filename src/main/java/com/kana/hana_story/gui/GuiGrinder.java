package com.kana.hana_story.gui;

import com.kana.hana_story.block.BlockLoader;
import com.kana.hana_story.hana_story;
import com.kana.hana_story.tileentity.TileEntityGrinder;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/26 21:32
 */
public class GuiGrinder extends GuiContainer {

    private static final ResourceLocation BG_TEXTURE = new ResourceLocation(hana_story.MODID, "textures/gui/grinder.png");

    private TileEntityGrinder tileEntityGrinder;

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1, 1, 1, 1);
        mc.getTextureManager().bindTexture(BG_TEXTURE);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        int progress = tileEntityGrinder.getWorkProgressScaled(23);
        drawTexturedModalRect(x + 95, y + 19, 1, 156, 15, 23 - progress);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String name = I18n.format(BlockLoader.bg.getUnlocalizedName() + ".name");
        fontRenderer.drawString(name, xSize / 2 - fontRenderer.getStringWidth(name) / 2, 6, 0x404040);
        //fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 94, 0x404040);
    }
    private InventoryPlayer playerInv;

    public GuiGrinder(Container container, InventoryPlayer playerInv, TileEntityGrinder teg) {
        super(container);
        tileEntityGrinder = teg;
        this.playerInv = playerInv;
        this.xSize = 204;
        this.ySize = 155;

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }
}
