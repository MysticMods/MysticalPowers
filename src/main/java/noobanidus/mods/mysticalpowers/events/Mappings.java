package noobanidus.mods.mysticalpowers.events;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;

public class Mappings {
  public static void onBlockMappings (RegistryEvent.MissingMappings<Block> event) {
/*    for (RegistryEvent.MissingMappings.Mapping<Block> e: event.getAllMappings()) {
      switch (
    }*/
  }

  public static void onTileMappings (RegistryEvent.MissingMappings<TileEntityType<?>> event) {

  }

  public static void onItemMappings (RegistryEvent.MissingMappings<Item> event) {

  }

  public static void onSoundMappings (RegistryEvent.MissingMappings<SoundEvent> event) {

  }

  public static void onRecipeMappings (RegistryEvent.MissingMappings<IRecipeSerializer<?>> event) {

  }
}
