/*package noobanidus.mods.mysticalpowers.tiles;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import noobanidus.mods.mysticalpowers.capability.SettableEnergyStorage;
import noobanidus.mods.mysticalpowers.init.ModSounds;
import noobanidus.mods.mysticalpowers.init.ModTiles;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DragonfireForgeTile extends EnergyTileEntity implements ITickableTileEntity {
  public static final int MAX_FE = 1000000;
  public static final int MAX_FE_XFER = 200;

  public DragonfireForgeTile() {
    super(null); // ModTiles.DRAGONFIRE_FORGE.get());
    this.energyStorage = new SettableEnergyStorage(MAX_FE, MAX_FE_XFER);
    this.energyHandler = LazyOptional.of(() -> this.energyStorage);
  }

  @Nonnull
  @Override
  public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
    return super.getCapability(cap, side);
  }

  @Override
  public void read(CompoundNBT compound) {
    super.read(compound);
  }

  @Override
  public CompoundNBT write(CompoundNBT compound) {
    CompoundNBT tag = super.write(compound);
    return tag;
  }

  @Override
  public void tick() {
  }
}*/
