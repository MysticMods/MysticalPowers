package noobanidus.mods.mysticalpowers.tiles;

import epicsquid.mysticallib.util.MathUtil;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;

public interface ITickingEnergyTileEntity extends IEnergyTileEntity {

  int getMaxFE ();

  default int getFEStored () {
    return getEnergyStorage().getEnergyStored();
  }

  default int getFEHeight () {
    int max = getMaxFE();
    int stored = MathUtil.clamp(getFEStored(), 0, max);
    if (max == 0) {
      return 0;
    }

    return 50 * stored / max;
  }

  default void energyTick(int MAX_FE_XFER, BlockPos pos, World world) {
    EnergyStorage energyStorage = getEnergyStorage();
    for (Direction facing : Direction.values()) {
      BlockPos checking = pos.offset(facing);
      TileEntity checkingTile = world.getTileEntity(checking);
      if (checkingTile != null) {
        LazyOptional<IEnergyStorage> optional = checkingTile.getCapability(CapabilityEnergy.ENERGY, facing.getOpposite());
        optional.ifPresent(storage -> {
          int energy = storage.receiveEnergy(Math.min(energyStorage.getEnergyStored(), MAX_FE_XFER), false);
          if (energy > 0) {
            energyStorage.extractEnergy(energy, false);
          }
        });
      }
    }
  }
}
