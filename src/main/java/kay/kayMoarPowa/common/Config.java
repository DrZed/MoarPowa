package kay.kayMoarPowa.common;

import net.minecraftforge.common.config.Configuration;

public class Config
{
    public static boolean AllowBetterCrafting;

    public Config(Configuration config)
    {
        config.load();

        AllowBetterCrafting = config.get("Features", "Allow Better Crafting(Possibly Buggy)", true).getBoolean(true);


        if(config.hasChanged())
        {
            config.save();
        }
    }
}