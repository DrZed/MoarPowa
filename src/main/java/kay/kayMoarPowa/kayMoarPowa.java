package kay.kayMoarPowa;

import cpw.mods.fml.common.registry.GameRegistry;
import kay.kayMoarPowa.Blocks.ECraftingTable;
import kay.kayMoarPowa.Init.ModItems;
import kay.kayMoarPowa.Items.CompactBattery;
import kay.kayMoarPowa.Items.DenseBattery;
import kay.kayMoarPowa.Items.MajorBattery;
import kay.kayMoarPowa.Items.MassiveBattery;
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

    public static Block ECraftingTable;

    public static Item BasicBattery;
    public static Item MinorBattery;
    public static Item SecondaryBattery;
    public static Item TertiaryBattery;
    public static Item CompactBattery;
    public static Item MajorBattery;
    public static Item DenseBattery;
    public static Item MassiveBattery;

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

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        event.getModState();
        System.out.println("Initialized");
        BasicBattery = new Item().setCreativeTab(kayMoarPowa.tabMoarPowa);
        MinorBattery = new Item();
        SecondaryBattery = new Item();
        TertiaryBattery = new Item();
        CompactBattery = new Item();
        MajorBattery = new Item();
        DenseBattery = new Item();
        MassiveBattery = new Item();
        ECraftingTable = new ECraftingTable();
        GameRegistry.registerBlock(ECraftingTable, "ECraftingTable");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        event.getModState();
    }
}