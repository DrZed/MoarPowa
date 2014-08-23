package kay.kayMoarPowa.Init;

import cpw.mods.fml.common.registry.GameRegistry;
import kay.kayMoarPowa.Items.Battery;
import kay.kayMoarPowa.kayMoarPowa;
import net.minecraft.item.Item;

public class ModItems {
    public static Item itemBattery = new Battery(kayMoarPowa.tabMoarPowa);

    public static void init(){
        GameRegistry.registerItem(itemBattery, "ItemBattery");
    }
}
