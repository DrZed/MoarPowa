package kay.kayMoarPowa.common;

import net.minecraftforge.common.config.Configuration;

public class Config
{
    public static boolean AllowBetterCrafting;

    // Power I/O Rates
    public static int T1StorageUnitEX;
    public static int T2StorageUnitEX;
    public static int T3StorageUnitEX;
    public static int T4StorageUnitEX;
    public static int T5StorageUnitEX;
    public static int T6StorageUnitEX;
    public static int T7StorageUnitEX;
    public static int T8StorageUnitEX;

    public static int T1StorageUnitIN;
    public static int T2StorageUnitIN;
    public static int T3StorageUnitIN;
    public static int T4StorageUnitIN;
    public static int T5StorageUnitIN;
    public static int T6StorageUnitIN;
    public static int T7StorageUnitIN;
    public static int T8StorageUnitIN;

    public static int T1StorageUnitStorage;
    public static int T2StorageUnitStorage;
    public static int T3StorageUnitStorage;
    public static int T4StorageUnitStorage;
    public static int T5StorageUnitStorage;
    public static int T6StorageUnitStorage;
    public static int T7StorageUnitStorage;
    public static int T8StorageUnitStorage;
    public Config(Configuration config)
    {
        config.load();
        //Feature Enable/Disable
        AllowBetterCrafting = config.get("Features", "Allow Better Crafting(Possibly Buggy)", true).getBoolean(true);

        // Power I/O
        T1StorageUnitEX = config.get("Power I/O Rates", "Max Extract Speed for Tier1 Storage", 50).getInt();
        T2StorageUnitEX = config.get("Power I/O Rates", "Max Extract Speed for Tier2 Storage", 150).getInt();
        T3StorageUnitEX = config.get("Power I/O Rates", "Max Extract Speed for Tier3 Storage", 350).getInt();
        T4StorageUnitEX = config.get("Power I/O Rates", "Max Extract Speed for Tier4 Storage", 650).getInt();
        T5StorageUnitEX = config.get("Power I/O Rates", "Max Extract Speed for Tier5 Storage", 950).getInt();
        T6StorageUnitEX = config.get("Power I/O Rates", "Max Extract Speed for Tier6 Storage", 1050).getInt();
        T7StorageUnitEX = config.get("Power I/O Rates", "Max Extract Speed for Tier7 Storage", 1250).getInt();
        T8StorageUnitEX = config.get("Power I/O Rates", "Max Extract Speed for Tier8 Storage", 1550).getInt();

        T1StorageUnitIN = config.get("Power I/O Rates", "Max Input Speed for Tier1 Storage", 50).getInt();
        T2StorageUnitIN = config.get("Power I/O Rates", "Max Input Speed for Tier2 Storage", 150).getInt();
        T3StorageUnitIN = config.get("Power I/O Rates", "Max Input Speed for Tier3 Storage", 350).getInt();
        T4StorageUnitIN = config.get("Power I/O Rates", "Max Input Speed for Tier4 Storage", 650).getInt();
        T5StorageUnitIN = config.get("Power I/O Rates", "Max Input Speed for Tier5 Storage", 950).getInt();
        T6StorageUnitIN = config.get("Power I/O Rates", "Max Input Speed for Tier6 Storage", 1050).getInt();
        T7StorageUnitIN = config.get("Power I/O Rates", "Max Input Speed for Tier7 Storage", 1250).getInt();
        T8StorageUnitIN = config.get("Power I/O Rates", "Max Input Speed for Tier8 Storage", 1550).getInt();

        // Power Storage
        T1StorageUnitStorage = config.get("Power Storage", "Max Power Storage for Tier1 Storage", 500000).getInt();
        T2StorageUnitStorage = config.get("Power Storage", "Max Power Storage for Tier2 Storage", 1000000).getInt();
        T3StorageUnitStorage = config.get("Power Storage", "Max Power Storage for Tier3 Storage", 5000000).getInt();
        T4StorageUnitStorage = config.get("Power Storage", "Max Power Storage for Tier4 Storage", 10000000).getInt();
        T5StorageUnitStorage = config.get("Power Storage", "Max Power Storage for Tier5 Storage", 50000000).getInt();
        T6StorageUnitStorage = config.get("Power Storage", "Max Power Storage for Tier6 Storage", 100000000).getInt();
        T7StorageUnitStorage = config.get("Power Storage", "Max Power Storage for Tier7 Storage", 500000000).getInt();
        T8StorageUnitStorage = config.get("Power Storage", "Max Power Storage for Tier8 Storage", 1000000000).getInt();

        if(config.hasChanged())
        {
            config.save();
        }
    }
}