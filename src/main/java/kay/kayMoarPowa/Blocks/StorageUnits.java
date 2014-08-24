package kay.kayMoarPowa.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kay.kayMoarPowa.TileEnts.*;
import kay.kayMoarPowa.lib.Reference;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;
public class StorageUnits extends BlockContainer {

    public StorageUnits(Material Par1Material, CreativeTabs Par2CreativeTab) {
        super(Par1Material);
        setCreativeTab(Par2CreativeTab);
        setBlockName("blockStorageUnit");
    }
    @Override
    public int damageDropped (int metadata){
        return metadata;
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list){
        for (int i = 0; i < 8; ++i){
            list.add(new ItemStack(item, 1, i));
        }
    }
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister) {
        icons = new IIcon[8];
        for (int i = 0; i < icons.length; i++) {
            icons[i] = iconregister.registerIcon(Reference.MOD_ID + ":blockStorageUnit"+(i+1));
        }
    }
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata){
        return icons[metadata];
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        if (damageDropped(metadata) == 0) {
            return new TileBasicStorageUnit();
        }
        else if (damageDropped(metadata) == 1){
            return new TileT2StorageUnit();
        }
        else if (damageDropped(metadata) == 2){
            return new TileT3StorageUnit();
        }
        else if (damageDropped(metadata) == 3){
            return new TileT4StorageUnit();
        }
        else if (damageDropped(metadata) == 4){
            return new TileT5StorageUnit();
        }
        else if (damageDropped(metadata) == 5){
            return new TileT6StorageUnit();
        }
        else if (damageDropped(metadata) == 6){
            return new TileT7StorageUnit();
        }
        else if (damageDropped(metadata) == 7){
            return new TileT8StorageUnit();
        }
        else
            return null;
    }
}