package kay.kayMoarPowa.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kay.kayMoarPowa.TileEnts.ECraftingTile;
import kay.kayMoarPowa.common.tabMoarPowa;
import kay.kayMoarPowa.kayMoarPowa;
import kay.kayMoarPowa.lib.Reference;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ECraftingTable extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    private IIcon[] blockIcons;
    public ECraftingTable()
    {
        super(Material.wood);
        this.setCreativeTab(tabMoarPowa.tab);
        this.blockResistance = 30f;
        this.blockHardness = 4;
        this.setStepSound(soundTypeWood);
        this.setBlockName("ECraftingTable");
        this.setBlockTextureName("CT");

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
    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new ECraftingTile();
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        blockIcons = new IIcon[256];

        blockIcons[0] = iconRegister.registerIcon(Reference.MOD_ID + ":textures/blocks/CT_bottom");
        blockIcons[1] = iconRegister.registerIcon(Reference.MOD_ID + ":textures/blocks/CT_top");
        blockIcons[2] = iconRegister.registerIcon(Reference.MOD_ID + ":textures/blocks/CT_side");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int Side, int Metadata){
        if(Side == 0){
            return blockIcons[0];
        }else if(Side == 1){
            return blockIcons[1];
        }else{
            return blockIcons[2];
        }
    }
}