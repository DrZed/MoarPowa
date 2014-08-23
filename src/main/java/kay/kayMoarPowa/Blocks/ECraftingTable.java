package kay.kayMoarPowa.Blocks;

import kay.kayMoarPowa.kayMoarPowa;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ECraftingTable extends Block
{
    public ECraftingTable()
    {
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.blockResistance = 30f;
        this.blockHardness = 4;
        this.setStepSound(soundTypeWood);
        this.blockMaterial.equals(Material.wood);
        this.setBlockTextureName("CTable");
    }
    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9)
    {
        if (!player.isSneaking())
        {
            player.openGui(kayMoarPowa.instance , 0, var1, var2, var3, var4);
            return true;
        }
        else
        {
            return false;
        }
    }
}