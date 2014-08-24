package kay.kayMoarPowa.Gui;

import kay.kayMoarPowa.Containers.ContainerECrafting;
import kay.kayMoarPowa.common.Textures;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class ECraftingGUI extends GuiContainer
{
    public ECraftingGUI(EntityPlayer player, World world, int i, int j, int k)
    {
        super(new ContainerECrafting(player, world, i, j, k));
    }

    public void onGuiClosed()
    {
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
//        this.fontRenderer.drawString(StatCollector.translateToLocal("\u00a76Better"), 120, 5, 0x404040);
//        this.fontRenderer.drawString(StatCollector.translateToLocal("\u00a76Crafting"), 116, 20, 0x404040);
//        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 - 14, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(Textures.Gui.CraftingGUI);

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }
}