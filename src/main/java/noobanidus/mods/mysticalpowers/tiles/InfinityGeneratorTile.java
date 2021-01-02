package noobanidus.mods.mysticalpowers.tiles;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraftforge.common.util.LazyOptional;
import noobanidus.mods.mysticalpowers.capability.SettableEnergyStorage;
import noobanidus.mods.mysticalpowers.init.ModTiles;

public class InfinityGeneratorTile extends EnergyTileEntity implements ITickableTileEntity, ITickingEnergyTileEntity {
  public static final int MAX_FE = Integer.MAX_VALUE;
  public static final int MAX_FE_XFER = Integer.MAX_VALUE;

  @SuppressWarnings("ConstantConditions")
  public InfinityGeneratorTile() {
    super(ModTiles.INFINITY_GENERATOR.get());
    this.energyStorage = new SettableEnergyStorage(MAX_FE, MAX_FE_XFER);
    this.energyHandler = LazyOptional.of(() -> this.energyStorage);
  }

  @Override
  public void tick() {
    getEnergyStorage().setEnergy(MAX_FE);
    energyTick(MAX_FE_XFER, this.pos, this.world);
  }

  @Override
  public int getMaxFE() {
    return MAX_FE;
  }
}
