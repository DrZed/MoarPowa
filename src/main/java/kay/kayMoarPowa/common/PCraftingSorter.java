package kay.kayMoarPowa.common;

import java.util.Comparator;
import net.minecraft.item.crafting.IRecipe;

public class PCraftingSorter implements Comparator
{
    final PCraftingManager PCraftingManager;

    public PCraftingSorter(PCraftingManager par1PCraftingManager)
    {
        this.PCraftingManager = par1PCraftingManager;
    }

    public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
    {
        return par1IRecipe instanceof PShapelessRecipe && par2IRecipe instanceof PShapedRecipe ? 1 : (par2IRecipe instanceof PShapelessRecipe && par1IRecipe instanceof PShapedRecipe ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object par1Obj, Object par2Obj)
    {
        return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
    }
}