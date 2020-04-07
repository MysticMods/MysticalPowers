package noobanidus.mods.mysticalpowers.events;

import com.google.common.collect.ImmutableList;
import com.tterrag.registrate.util.RegistryEntry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import noobanidus.mods.mysticalpowers.MysticalPowers;
import noobanidus.mods.mysticalpowers.init.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber(modid = MysticalPowers.MODID)
public class Mappings {
  @SubscribeEvent
  public static void onBlockMappings(RegistryEvent.MissingMappings<Block> event) {
    remap(event.getRegistry(), event.getAllMappings());
  }

  @SubscribeEvent
  public static void onTileMappings(RegistryEvent.MissingMappings<TileEntityType<?>> event) {
    remap(event.getRegistry(), event.getAllMappings());
  }

  @SubscribeEvent
  public static void onItemMappings(RegistryEvent.MissingMappings<Item> event) {
    remap(event.getRegistry(), event.getAllMappings());
  }

  @SubscribeEvent
  public static void onSoundMappings(RegistryEvent.MissingMappings<SoundEvent> event) {
    remap(event.getRegistry(), event.getAllMappings());
  }

  @SubscribeEvent
  public static void onRecipeMappings(RegistryEvent.MissingMappings<IRecipeSerializer<?>> event) {
    remap(event.getRegistry(), event.getAllMappings());
  }

  private final static Map<IForgeRegistry<?>, HashMap<String, RegistryEntry<?>>> mappings = new HashMap<>();

  @SuppressWarnings("unchecked")
  private static <T extends IForgeRegistryEntry<T>> void remap(IForgeRegistry<T> registry, ImmutableList<RegistryEvent.MissingMappings.Mapping<T>> maps) {
    Map<String, RegistryEntry<?>> remaps = mappings.get(registry);
    if (maps != null) {
      for (RegistryEvent.MissingMappings.Mapping<T> mapping : maps) {
        if (mapping.key.getNamespace().equals("mysticalworld")) {
          String path = mapping.key.getPath();
          if (remaps.containsKey(path)) {
            mapping.remap((T) remaps.get(path).get());
          }
        }
      }
    }
  }

  private static HashMap<String, RegistryEntry<?>> makeMappings(RegistryEntry<?>... entries) {
    HashMap<String, RegistryEntry<?>> result = new HashMap<>();
    for (RegistryEntry<?> entry : entries) {
      String key = entry.getId().getPath();
      result.put(key, entry);
    }
    return result;
  }

  public static void load () {
    // This is so ugly
    List<RegistryEntry<?>> blocks = Arrays.asList(ModBlocks.COOKIE_GENERATOR, ModBlocks.WATER_FABRICATOR, ModBlocks.END_STONE_FABRICATOR, ModBlocks.SAND_FABRICATOR, ModBlocks.RED_SAND_FABRICATOR, ModBlocks.CLAY_FABRICATOR, ModBlocks.NETHERRACK_FABRICATOR, ModBlocks.SOUL_SAND_FABRICATOR, ModBlocks.SLIME_FABRICATOR, ModBlocks.ICE_FABRICATOR, ModBlocks.SNOW_FABRICATOR, ModBlocks.DIRT_FABRICATOR, ModBlocks.GRAVEL_FABRICATOR);
    blocks.addAll(ModBlocks.MACHINE_FRAMES.values());

    mappings.put(ForgeRegistries.BLOCKS,
        makeMappings(blocks.toArray(new RegistryEntry[0])));

    mappings.put(ForgeRegistries.ITEMS,
        makeMappings(ModItems.POWERCELL_TIN,
            ModItems.POWERCELL_LEAD,
            ModItems.POWERCELL_COPPER,
            ModItems.POWERCELL_SILVER,
            ModItems.POWERCELL_QUICKSILVER));

    mappings.put(ForgeRegistries.RECIPE_SERIALIZERS,
        makeMappings(ModRecipes.BATTERY_SERIALIZER));

    mappings.put(ForgeRegistries.SOUND_EVENTS,
        makeMappings(ModSounds.COOKIE_MUNCH, ModSounds.END_STONE_GENERATE));

    mappings.put(ForgeRegistries.TILE_ENTITIES,
        makeMappings(ModTiles.END_STONE_FABRICATOR, ModTiles.BLOCK_FABRICATOR, ModTiles.WATER_FABRICATOR, ModTiles.COOKIE_GENERATOR));
  }
}
