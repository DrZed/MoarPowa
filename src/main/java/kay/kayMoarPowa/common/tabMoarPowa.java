package kay.kayMoarPowa.common;

import kay.kayMoarPowa.kayMoarPowa;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class tabMoarPowa extends CreativeTabs
{
    public static tabMoarPowa tab = new tabMoarPowa();
    static Item icon;

    public tabMoarPowa()
    {
        super("tabMoarPowa");
    }

    public Item getTabIconItem ()
    {
        return kayMoarPowa.BasicBattery;
    }
}
