package kay.kayMoarPowa.common;

import kay.kayMoarPowa.lib.Reference;
import net.minecraft.util.ResourceLocation;

public class Textures {
    public static final class Gui
    {
        private static final String GUI_SHEET_LOCATION = Reference.MOD_ID + ":textures/gui/";
        public static final ResourceLocation CraftingGUI = ResourceLocationHelper.getResourceLocation(GUI_SHEET_LOCATION + "craftingT.png");
    }
}
