package kay.kayMoarPowa.Init;

import cpw.mods.fml.common.registry.GameRegistry;
import kay.kayMoarPowa.TileEnts.ECraftingTile;

public class Registry {

    public static void registry(){

        GameRegistry.registerTileEntity(ECraftingTile.class, "ECraftingTile");

    }
}
