package kay.kayMoarPowa.common;

import kay.kayMoarPowa.Init.ModItems;
import kay.kayMoarPowa.kayMoarPowa;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class tabMoarPowa extends CreativeTabs
{
    public static tabMoarPowa tab = new tabMoarPowa();
    public tabMoarPowa()
    {
        super("tabMoarPowa");
    }
    public Item getTabIconItem ()
    {
        return new ItemStack(ModItems.itemBattery, 1, 0).getItem();
    }
}
