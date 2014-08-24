package kay.kayMoarPowa;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import kay.kayMoarPowa.Gui.GuiHandler;
import kay.kayMoarPowa.Init.ModBlocks;
import kay.kayMoarPowa.Init.ModItems;
import kay.kayMoarPowa.Init.Registry;
import kay.kayMoarPowa.common.Config;
import kay.kayMoarPowa.common.Crafting;
import kay.kayMoarPowa.lib.Reference;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class kayMoarPowa
{
    @Instance(Reference.MOD_ID)
    public static kayMoarPowa instance;
    public static Config Config;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        System.out.println("Initializing");
        event.getModState();
        Config = new Config(new Configuration(event.getSuggestedConfigurationFile()));
        ModItems.init();
        ModBlocks.init();
        Registry.registry();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        event.getModState();
        System.out.println("Initialized");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        event.getModState();
    }
}