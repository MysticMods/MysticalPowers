package noobanidus.mods.mysticalpowers.tiles;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import noobanidus.mods.mysticalpowers.capability.SettableEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class EnergyTileEntity extends TileEntity implements IEnergyTileEntity {
  protected SettableEnergyStorage energyStorage;
  protected LazyOptional<IEnergyStorage> energyHandler;

  public EnergyTileEntity(TileEntityType<?> tileEntityTypeIn) {
    super(tileEntityTypeIn);
  }

  @Nonnull
  @Override
  public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
    if (cap == CapabilityEnergy.ENERGY) {
      return energyHandler.cast();
    }

    return super.getCapability(cap, side);
  }

  @Override
  public void read(BlockState state, CompoundNBT compound) {
    super.read(state, compound);
    this.energyStorage.setEnergy(compound.getInt("Energy"));
  }

  @Override
  public CompoundNBT write(CompoundNBT compound) {
    CompoundNBT tag = super.write(compound);
    tag.putInt("Energy", this.energyStorage.getEnergyStored());
    return tag;
  }

  @Nullable
  @Override
  public SUpdateTileEntityPacket getUpdatePacket() {
    return new SUpdateTileEntityPacket(this.pos, 9, getUpdateTag());
  }

  @Override
  public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
    read(Blocks.AIR.getDefaultState(), pkt.getNbtCompound());
  }

  @Override
  public CompoundNBT getUpdateTag() {
    return write(super.getUpdateTag());
  }

  @Override
  public void remove() {
    energyHandler.invalidate();
    super.remove();
  }

  @Override
  public SettableEnergyStorage getEnergyStorage() {
    return energyStorage;
  }

}
