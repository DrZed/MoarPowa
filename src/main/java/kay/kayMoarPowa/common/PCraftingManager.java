package kay.kayMoarPowa.common;

import cpw.mods.fml.common.registry.GameRegistry;
import kay.kayMoarPowa.Init.ModItems;
import kay.kayMoarPowa.Items.Battery;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

import java.util.*;

public class PCraftingManager
{
    public static final int WILDCARD_VALUE = Short.MAX_VALUE;
    private static final PCraftingManager instance = new PCraftingManager();
    private List recipes = new ArrayList();

    public static final PCraftingManager getInstance()
    {
        return instance;
    }

    private PCraftingManager()
    {
        recipes = new ArrayList();

        //This is where your recipes will go

        Collections.sort(this.recipes, new PCraftingSorter(this));
        System.out.println(this.recipes.size() + " recipes");
    }

    public PShapedRecipe createRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        String var3 = "";
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;

        if (par2ArrayOfObj[var4] instanceof String[])
        {
            String[] var7 = (String[])((String[])par2ArrayOfObj[var4++]);

            for (int var8 = 0; var8 < var7.length; ++var8)
            {
                String var9 = var7[var8];
                ++var6;
                var5 = var9.length();
                var3 = var3 + var9;
            }
        }
        else
        {
            while (par2ArrayOfObj[var4] instanceof String)
            {
                String var11 = (String)par2ArrayOfObj[var4++];
                ++var6;
                var5 = var11.length();
                var3 = var3 + var11;
            }
        }

        HashMap var12;

        for (var12 = new HashMap(); var4 < par2ArrayOfObj.length; var4 += 2)
        {
            Character var13 = (Character)par2ArrayOfObj[var4];
            ItemStack var14 = null;

            if (par2ArrayOfObj[var4 + 1] instanceof Item)
            {
                var14 = new ItemStack((Item)par2ArrayOfObj[var4 + 1]);
            }
            else if (par2ArrayOfObj[var4 + 1] instanceof Block)
            {
                var14 = new ItemStack((Block)par2ArrayOfObj[var4 + 1], 1, -1);
            }
            else if (par2ArrayOfObj[var4 + 1] instanceof ItemStack)
            {
                var14 = (ItemStack)par2ArrayOfObj[var4 + 1];
            }

            var12.put(var13, var14);
        }

        ItemStack[] var15 = new ItemStack[var5 * var6];

        for (int var16 = 0; var16 < var5 * var6; ++var16)
        {
            char var10 = var3.charAt(var16);

            if (var12.containsKey(Character.valueOf(var10)))
            {
                var15[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).copy();
            }
            else
            {
                var15[var16] = null;
            }
        }

        PShapedRecipe var17 = new PShapedRecipe(var5, var6, var15, par1ItemStack);
        this.recipes.add(var17);
        return var17;
    }

    public void addBuilderShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        ArrayList var3 = new ArrayList();
        Object[] var4 = par2ArrayOfObj;
        int var5 = par2ArrayOfObj.length;

        for (int var6 = 0; var6 < var5; ++var6)
        {
            Object var7 = var4[var6];

            if (var7 instanceof ItemStack)
            {
                var3.add(((ItemStack)var7).copy());
            }
            else if (var7 instanceof Item)
            {
                var3.add(new ItemStack((Item)var7));
            }
            else
            {
                if (!(var7 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipe!");
                }

                var3.add(new ItemStack((Block)var7));
            }
        }

        this.recipes.add(new PShapelessRecipe(par1ItemStack, var3));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
    {
        int var3 = 0;
        ItemStack var4 = null;
        ItemStack var5 = null;
        int var6;

        for (var6 = 0; var6 < par1InventoryCrafting.getSizeInventory(); ++var6)
        {
            ItemStack var7 = par1InventoryCrafting.getStackInSlot(var6);

            if (var7 != null)
            {
                if (var3 == 0)
                {
                    var4 = var7;
                }

                if (var3 == 1)
                {
                    var5 = var7;
                }

                ++var3;
            }
        }

        if (var3 == 2 && var4.getItem() == var5.getItem() && var4.stackSize == 1 && var5.stackSize == 1)
        {
            return null;
        }
        else
        {
            for (var6 = 0; var6 < this.recipes.size(); ++var6)
            {
                IRecipe var12 = (IRecipe)this.recipes.get(var6);

                if (var12.matches(par1InventoryCrafting, par2World))
                {
                    return var12.getCraftingResult(par1InventoryCrafting);
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList()
    {
        return this.recipes;
    }
}