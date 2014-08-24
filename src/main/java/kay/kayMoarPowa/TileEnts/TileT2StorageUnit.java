package kay.kayMoarPowa.TileEnts;

import cofh.api.energy.IEnergyStorage;
import kay.kayMoarPowa.common.Config;
import net.minecraft.tileentity.TileEntity;

public class TileT2StorageUnit extends TileEntity implements IEnergyStorage{
    public TileT2StorageUnit()
    {
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return Config.T2StorageUnitIN;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return Config.T2StorageUnitEX;
    }

    @Override
    public int getEnergyStored() {
        return 0;
    }

    @Override
    public int getMaxEnergyStored() {
        return Config.T2StorageUnitStorage;
    }
}