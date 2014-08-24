package kay.kayMoarPowa.TileEnts;
import cofh.api.energy.*;
import kay.kayMoarPowa.common.Config;
import net.minecraft.tileentity.TileEntity;

public class TileBasicStorageUnit extends TileEntity implements IEnergyStorage{
    public TileBasicStorageUnit()
    {
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return Config.T1StorageUnitIN;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return Config.T1StorageUnitEX;
    }

    @Override
    public int getEnergyStored() {
        return 0;
    }

    @Override
    public int getMaxEnergyStored() {
        return Config.T1StorageUnitStorage;
    }
}