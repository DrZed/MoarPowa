package kay.kayMoarPowa.Containers;

import kay.kayMoarPowa.common.Config;
import kay.kayMoarPowa.common.PCraftingManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerECrafting extends Container
{

    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;

    public ContainerECrafting(InventoryPlayer inventoryplayer, World world, int i, int j, int k)
    {
        craftMatrix = new InventoryCrafting(this, 5, 5);
        craftResult = new InventoryCraftResult();
        worldObj = world;
        posX = i;
        posY = j;
        posZ = k;
        this.addSlotToContainer(new SlotCrafting(inventoryplayer.player, craftMatrix, craftResult, 0, 131, 36));
        for(int l = 0; l < 5; l++)
        {
            for(int k1 = 0; k1 < 5; k1++)
            {
                this.addSlotToContainer(new Slot(craftMatrix, k1 + l * 5, 4 + k1 * 18, 3 + l * 18));
            }

        }

        for(int i1 = 0; i1 < 3; i1++)
        {
            for(int l1 = 0; l1 < 9; l1++)
            {
                this.addSlotToContainer(new Slot(inventoryplayer, l1 + i1 * 9 + 9, 8 + l1 * 18, 94 + i1 * 18));
            }

        }

        for(int j1 = 0; j1 < 9; j1++)
        {
            this.addSlotToContainer(new Slot(inventoryplayer, j1, 8 + j1 * 18, 148));
        }

        onCraftMatrixChanged(craftMatrix);
    }

    public void onCraftMatrixChanged(IInventory iinventory)
    {
        craftResult.setInventorySlotContents(0, PCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
    }

    public void onContainerClosed(EntityPlayer entityplayer)
    {
        super.onContainerClosed(entityplayer);
        if(worldObj.isRemote)
        {
            return;
        }
        for(int i = 0; i < 25; i++)
        {
            ItemStack itemstack = craftMatrix.getStackInSlot(i);
            if(itemstack != null)
            {
                entityplayer.entityDropItem(itemstack, 1);
            }
        }

    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return Config.AllowBetterCrafting;
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(par2);
        if(slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if(par2 == 0)
            {
                if(!mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }
            } else
            if(par2 >= 10 && par2 < 37)
            {
                if(!mergeItemStack(itemstack1, 37, 46, false))
                {
                    return null;
                }
            } else
            if(par2 >= 37 && par2 < 46)
            {
                if(!mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            } else
            if(!mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }
            if(itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            } else
            {
                slot.onSlotChanged();
            }
            if(itemstack1.stackSize != itemstack.stackSize)
            {
                slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
            } else
            {
                return null;
            }
        }
        return itemstack;
    }
}