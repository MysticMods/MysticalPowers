package noobanidus.mods.mysticalpowers.tiles;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraftforge.common.util.LazyOptional;
import noobanidus.mods.mysticalpowers.capability.SettableEnergyStorage;
import noobanidus.mods.mysticalpowers.init.ModTiles;

public class CookieGeneratorTile extends EnergyTileEntity implements ITickableTileEntity, ITickingEnergyTileEntity {
  public static final int MAX_FE = 1000000;
  public static final int MAX_FE_XFER = 300;
  public static final int RF_PER_COOKIE = 250;

  @SuppressWarnings("ConstantConditions")
  public CookieGeneratorTile() {
    super(ModTiles.COOKIE_GENERATOR.get());
    this.energyStorage = new SettableEnergyStorage(MAX_FE, MAX_FE_XFER);
    this.energyHandler = LazyOptional.of(() -> this.energyStorage);
  }

  public void acceptCookie() {
    this.energyStorage.receiveEnergy(RF_PER_COOKIE, false);
  }

  @Override
  public void tick() {
    energyTick(MAX_FE_XFER, this.pos, this.world);
  }

  @Override
  public int getMaxFE() {
    return MAX_FE;
  }
}
