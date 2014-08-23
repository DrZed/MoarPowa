package kay.kayMoarPowa;

import cpw.mods.fml.common.registry.GameRegistry;
import kay.kayMoarPowa.Blocks.ECraftingTable;
import kay.kayMoarPowa.Init.ModBlocks;
import kay.kayMoarPowa.Init.ModItems;
import kay.kayMoarPowa.lib.Reference;
import kay.kayMoarPowa.common.Config;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.*;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class kayMoarPowa
{
    @Instance(Reference.MOD_ID)
    public static kayMoarPowa instance;
    public static GuiContainer ECraftingGUI;
    public static Config Config;




    public static CreativeTabs tabMoarPowa = new CreativeTabs("tabMoarPowa") {
        @Override
        public Item getTabIconItem() {
            return Items.apple;
        }
    };

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        System.out.println("Initializing");
        event.getModState();
        Config = new Config(new Configuration(event.getSuggestedConfigurationFile()));
        ModItems.init();
        ModBlocks.init();

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        event.getModState();
        System.out.println("Initialized");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        event.getModState();
    }
}