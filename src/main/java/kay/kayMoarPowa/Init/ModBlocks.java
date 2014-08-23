package kay.kayMoarPowa.Init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {
    public static Block ECraftingTable;

    public static void init(){
        GameRegistry.registerBlock(ECraftingTable, "ECraftingTable");
    }
}
