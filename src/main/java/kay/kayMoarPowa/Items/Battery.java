package kay.kayMoarPowa.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kay.kayMoarPowa.lib.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class Battery extends Item {
    @SideOnly(Side.CLIENT)
    public IIcon[] icons;

    public Battery(CreativeTabs creativeTabs){
        setCreativeTab(creativeTabs);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        return "tier" + itemStack.getItemDamage() + "Battery";
    }

    @Override
    public int getMetadata(int metadata){
        return metadata;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        icons = new IIcon[256];
        icons[0] = iconRegister.registerIcon(Reference.MOD_ID + ":tier0Battery");
        for(int i = 0; i < 8; i++){
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID + ":tier" + i + "Battery");
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int metadata){
        return icons[metadata];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list){
        for(int i = 0; i < 8; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }
}
