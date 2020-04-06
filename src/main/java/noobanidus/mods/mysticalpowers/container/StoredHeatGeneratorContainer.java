package noobanidus.mods.mysticalpowers.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.IIntArray;
import noobanidus.mods.mysticalpowers.tiles.StoredHeatGeneratorTile;

import javax.annotation.Nullable;

public class StoredHeatGeneratorContainer extends Container {
  protected final StoredHeatGeneratorTile tile;
  protected final IIntArray furnaceData;


  protected StoredHeatGeneratorContainer(@Nullable ContainerType<?> type, int id, StoredHeatGeneratorTile tile, IIntArray furnaceData) {
    super(type, id);
    this.tile = tile;
    this.furnaceData = furnaceData;

  }

  @Override
  public boolean canInteractWith(PlayerEntity playerIn) {
    return true;
  }

  public StoredHeatGeneratorTile getTile() {
    return tile;
  }

  public IIntArray getFurnaceData() {
    return furnaceData;
  }
}
