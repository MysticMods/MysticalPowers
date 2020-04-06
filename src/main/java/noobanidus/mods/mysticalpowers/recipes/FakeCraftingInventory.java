package noobanidus.mods.mysticalpowers.recipes;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipeItemHelper;

public class FakeCraftingInventory extends CraftingInventory {
  private ItemStack stack;

  public FakeCraftingInventory() {
    super(null, 1, 1);
  }

  @Override
  public int getSizeInventory() {
    return 1;
  }

  @Override
  public boolean isEmpty() {
    return stack.isEmpty();
  }

  @Override
  public ItemStack getStackInSlot(int index) {
    return stack;
  }

  @Override
  public ItemStack removeStackFromSlot(int index) {
    ItemStack orig = this.stack;
    this.stack = ItemStack.EMPTY;
    return orig;
  }

  @Override
  public ItemStack decrStackSize(int index, int count) {
    return removeStackFromSlot(0);
  }

  @Override
  public void setInventorySlotContents(int index, ItemStack stack) {
    this.stack = stack;
  }

  @Override
  public void markDirty() {
  }

  @Override
  public boolean isUsableByPlayer(PlayerEntity player) {
    return true;
  }

  @Override
  public void clear() {
    this.stack = ItemStack.EMPTY;
  }

  @Override
  public int getHeight() {
    return 1;
  }

  @Override
  public int getWidth() {
    return 1;
  }

  @Override
  public void fillStackedContents(RecipeItemHelper helper) {
    helper.accountPlainStack(stack);
  }
}
