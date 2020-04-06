package noobanidus.mods.mysticalpowers.tiles;

import epicsquid.mysticallib.util.ItemUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import noobanidus.mods.mysticalpowers.capability.SettableEnergyStorage;
import noobanidus.mods.mysticalpowers.init.ModTiles;

import javax.annotation.Nonnull;

public class StoredHeatGeneratorTile extends EnergyTileEntity implements ITickableTileEntity, ITickingEnergyTileEntity {
  private static final int MAX_FE = 10000000;
  private static final int MAX_FE_XFER = 1000;

  private static final int MAX_HEAT = 6656;
  private int currentHeat = 0;

  private ItemStackHandler itemStackHandler;
  private LazyOptional<IItemHandler> itemHandler;

  protected final IIntArray furnaceData = new IIntArray() {
    @Override
    public int get(int index) {
      switch (index) {
        case 0:
          return getEnergyStorage().getEnergyStored();
        case 1:
          return getEnergyStorage().getMaxEnergyStored();
        case 2:
          return MAX_HEAT;
        case 3:
          return currentHeat;
        default:
          return -1;
      }
    }

    @Override
    public void set(int index, int value) {
      switch (index) {
        case 0:
          getEnergyStorage().setEnergy(value);
        case 1:
        case 2:
          break;
        case 3:
          StoredHeatGeneratorTile.this.currentHeat = value;
      }
    }

    @Override
    public int size() {
      return 4;
    }
  };

  @SuppressWarnings("ConstantConditions")
  public StoredHeatGeneratorTile() {
    super(ModTiles.COOKIE_GENERATOR.get());
    this.energyStorage = new SettableEnergyStorage(MAX_FE, MAX_FE_XFER);
    this.energyHandler = LazyOptional.of(() -> this.energyStorage);
    this.itemStackHandler = new ItemStackHandler(1);
    this.itemHandler = LazyOptional.of(() -> this.itemStackHandler);
  }

  @Override
  public void read(CompoundNBT compound) {
    super.read(compound);
    this.currentHeat = compound.getInt("CurrentHeat");
  }

  @Override
  public CompoundNBT write(CompoundNBT compound) {
    CompoundNBT result = super.write(compound);
    result.putInt("CurrentHeat", this.currentHeat);
    return result;
  }

  @Override
  public void tick() {
    if (world == null) {
      return;
    }

    energyTick(MAX_FE_XFER, this.pos, this.world);
    if (!world.isBlockPowered(this.pos)) {
      TileEntity te = world.getTileEntity(this.pos.up());
      if (te != null) {
        ItemStack inSlot = itemStackHandler.getStackInSlot(0);
        if (inSlot.isEmpty() || inSlot.getMaxStackSize() > inSlot.getCount()) {
          te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.DOWN).ifPresent(invCap -> {
            for (int i = 0; i < invCap.getSlots(); i++) {
              ItemStack stack = invCap.getStackInSlot(i);
              if (stack.isEmpty()) {
                continue;
              }
              if (!inSlot.isEmpty() && ItemUtil.equalWithoutSize(inSlot, stack)) {
                int size = stack.getCount() - inSlot.getCount();
                ItemStack pulled = invCap.extractItem(i, size, true);
                if (pulled.isEmpty()) {
                  continue;
                }

                ItemStack result = itemStackHandler.insertItem(0, pulled, true);
                if (result.isEmpty()) {
                  pulled = invCap.extractItem(i, size, false);
                  itemStackHandler.insertItem(0, pulled, false);
                  break;
                }
              } else if (inSlot.isEmpty()) {
                int burnTime = ForgeHooks.getBurnTime(stack);
                if (burnTime > 0) {
                  ItemStack pulled = invCap.extractItem(i, stack.getCount(), true);
                  if (pulled.isEmpty()) {
                    continue;
                  }

                  ItemStack result = invCap.insertItem(i, pulled, true);
                  if (result.isEmpty()) {
                    pulled = invCap.extractItem(i, stack.getCount(), false);
                    itemStackHandler.insertItem(0, pulled, false);
                    break;
                  }
                }
              }
            }
          });
        }
      }
    }
  }

  @Override
  public int getMaxFE() {
    return MAX_FE;
  }

  public static class HeatItemStackHandler extends ItemStackHandler {
    public HeatItemStackHandler() {
      super(1);
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
      return ForgeHooks.getBurnTime(stack) > 0;
    }
  }
}
