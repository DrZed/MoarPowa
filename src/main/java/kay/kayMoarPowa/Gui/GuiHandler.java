package kay.kayMoarPowa.Gui;

import cpw.mods.fml.common.network.IGuiHandler;
import kay.kayMoarPowa.Containers.ContainerECrafting;
import kay.kayMoarPowa.TileEnts.ECraftingTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity instanceof ECraftingTile){
            return new ContainerECrafting(player, world, x, y, z);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity instanceof ECraftingTile){
            return new ECraftingGUI(player, world, x, y, z);
        }
        return null;
    }
}
