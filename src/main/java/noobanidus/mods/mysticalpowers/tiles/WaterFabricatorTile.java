package noobanidus.mods.mysticalpowers.tiles;

import net.minecraft.fluid.Fluids;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import noobanidus.mods.mysticalpowers.init.ModTiles;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class WaterFabricatorTile extends TileEntity {
  public static InfiniteWaterProvider WATER = new InfiniteWaterProvider();

  public WaterFabricatorTile() {
    super(ModTiles.WATER_FABRICATOR.get());
  }

  @Nonnull
  @Override
  public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
    if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
      return LazyOptional.of(() -> WATER).cast();
    } else {
      return LazyOptional.empty();
    }
  }

  public static class InfiniteWaterProvider implements IFluidHandler, IFluidTank {
    @Nonnull
    @Override
    public FluidStack getFluid() {
      return new FluidStack(Fluids.WATER, Integer.MAX_VALUE);
    }

    @Override
    public int getFluidAmount() {
      return Integer.MAX_VALUE / 2;
    }

    @Override
    public int getCapacity() {
      return Integer.MAX_VALUE;
    }

    @Override
    public boolean isFluidValid(FluidStack stack) {
      return stack.getFluid() == Fluids.WATER;
    }

    @Override
    public int getTanks() {
      return 1;
    }

    @Nonnull
    @Override
    public FluidStack getFluidInTank(int tank) {
      return new FluidStack(Fluids.WATER, Integer.MAX_VALUE);
    }

    @Override
    public int getTankCapacity(int tank) {
      return Integer.MAX_VALUE;
    }

    @Override
    public boolean isFluidValid(int tank, @Nonnull FluidStack stack) {
      return stack.getFluid() == (Fluids.WATER);
    }

    @Override
    public int fill(FluidStack resource, FluidAction action) {
      return resource.getAmount();
    }

    @Nonnull
    @Override
    public FluidStack drain(FluidStack resource, FluidAction action) {
      return new FluidStack(Fluids.WATER, resource.getAmount());
    }

    @Nonnull
    @Override
    public FluidStack drain(int maxDrain, FluidAction action) {
      return new FluidStack(Fluids.WATER, maxDrain);
    }
  }
}
