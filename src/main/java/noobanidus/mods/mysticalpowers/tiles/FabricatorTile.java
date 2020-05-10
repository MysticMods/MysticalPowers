package noobanidus.mods.mysticalpowers.tiles;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import noobanidus.mods.mysticalpowers.capability.SettableEnergyStorage;
import noobanidus.mods.mysticalpowers.init.ModTiles;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.Supplier;

public class FabricatorTile extends EnergyTileEntity implements ITickableTileEntity {
  private int FE_OPERATION = 50;
  private int FREQUENCY = 250;
  private Supplier<? extends IItemProvider> block;
  private int MAX_FE = 1000000;
  private int MAX_FE_TRANSFER = 200;

  private int stoneAmount;
  private StoneHandler stoneHandler;
  private LazyOptional<IItemHandler> stoneCapability;

  public FabricatorTile() {
    super(ModTiles.BLOCK_FABRICATOR.get());
  }

  public FabricatorTile(Supplier<? extends IItemProvider> block, int MAX_FE, int MAX_FE_TRANSFER, int FE_OPERATION, int FREQUENCY) {
    this();
    this.energyStorage = new SettableEnergyStorage(MAX_FE, MAX_FE_TRANSFER);
    this.energyHandler = LazyOptional.of(() -> this.energyStorage);
    this.stoneHandler = new StoneHandler(block);
    this.stoneCapability = LazyOptional.of(() -> this.stoneHandler);
    this.FE_OPERATION = FE_OPERATION;
    this.FREQUENCY = FREQUENCY;
    this.MAX_FE = MAX_FE;
    this.MAX_FE_TRANSFER = MAX_FE_TRANSFER;
    this.block = block;
  }

  @Nonnull
  @Override
  public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
    if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
      return stoneCapability.cast();
    }

    return super.getCapability(cap, side);
  }

  @Override
  public void read(CompoundNBT compound) {
    this.stoneAmount = compound.getInt("StoneAmount");
    this.FE_OPERATION = compound.getInt("FE_OPERATION");
    this.FREQUENCY = compound.getInt("FREQUENCY");
    this.MAX_FE = compound.getInt("MAX_FE");
    this.MAX_FE_TRANSFER = compound.getInt("MAX_FE_TRANSFER");
    this.block = () -> ItemStack.read(compound.getCompound("itemstack")).getItem();
    if (this.energyStorage == null) {
      this.energyStorage = new SettableEnergyStorage(MAX_FE, MAX_FE_TRANSFER);
      this.energyHandler = LazyOptional.of(() -> this.energyStorage);
    }
    if (this.stoneHandler == null) {
      this.stoneHandler = new StoneHandler(block);
      this.stoneCapability = LazyOptional.of(() -> this.stoneHandler);
    }
    super.read(compound);
  }

  @Override
  public CompoundNBT write(CompoundNBT compound) {
    CompoundNBT tag = super.write(compound);
    tag.putInt("StoneAmount", this.stoneAmount);
    tag.putInt("MAX_FE", this.MAX_FE);
    tag.putInt("MAX_FE_TRANSFER", this.MAX_FE_TRANSFER);
    tag.putInt("FREQUENCY", this.FREQUENCY);
    tag.putInt("FE_OPERATION", this.FE_OPERATION);
    tag.put("itemstack", new ItemStack(block.get()).write(new CompoundNBT()));
    return tag;
  }

  public int getAmount() {
    return stoneAmount;
  }

  public ItemStack getItemType() {
    return stoneHandler.getReference();
  }

  @Override
  public void tick() {
    if (world == null || world.isBlockPowered(pos) || world.isRemote) {
      return;
    }

    MinecraftServer server = world.getServer();
    if (server == null) {
      return;
    }

    if (server.getTickCounter() % FREQUENCY == 0) {
      if (energyStorage.extractEnergy(FE_OPERATION, true) == FE_OPERATION) {
        stoneAmount++;
        energyStorage.extractEnergy(FE_OPERATION, false);
      }
    }
  }

  public class StoneHandler implements IItemHandler {
    private Item item;
    private ItemStack reference;

    public StoneHandler(Supplier<? extends IItemProvider> supplier) {
      this.item = supplier.get().asItem();
      this.reference = new ItemStack(item);
    }

    public ItemStack getReference() {
      return reference;
    }

    @Override
    public int getSlots() {
      return 1;
    }

    @Nonnull
    @Override
    public ItemStack getStackInSlot(int slot) {
      return new ItemStack(item, stoneAmount);
    }

    @Nonnull
    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
      return stack;
    }

    @Nonnull
    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
      if (amount <= stoneAmount) {
        if (!simulate) {
          stoneAmount -= amount;
        }
        return new ItemStack(item, amount);
      } else {
        return ItemStack.EMPTY;
      }
    }

    @Override
    public int getSlotLimit(int slot) {
      return Integer.MAX_VALUE;
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
      return false;
    }
  }
}
