package kay.kayMoarPowa.TileEnts;

import cofh.api.energy.IEnergyStorage;
import kay.kayMoarPowa.common.Config;
import net.minecraft.tileentity.TileEntity;

public class TileT5StorageUnit extends TileEntity implements IEnergyStorage{
    public TileT5StorageUnit()
    {
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return Config.T5StorageUnitIN;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return Config.T5StorageUnitEX;
    }

    @Override
    public int getEnergyStored() {
        return 0;
    }

    @Override
    public int getMaxEnergyStored() {
        return Config.T5StorageUnitStorage;
    }
}