package noobanidus.mods.mysticalpowers.init;

import com.tterrag.registrate.util.RegistryEntry;
import net.minecraft.tileentity.TileEntityType;
import noobanidus.mods.mysticalpowers.tiles.CookieGeneratorTile;
import noobanidus.mods.mysticalpowers.tiles.EndStoneFabricatorTile;
import noobanidus.mods.mysticalpowers.tiles.FabricatorTile;
import noobanidus.mods.mysticalpowers.tiles.WaterFabricatorTile;

import static noobanidus.mods.mysticalpowers.MysticalPowers.REGISTRATE;

public class ModTiles {
  public static final RegistryEntry<TileEntityType<EndStoneFabricatorTile>> END_STONE_FABRICATOR = REGISTRATE.tileEntity("end_stone_generator", EndStoneFabricatorTile::new)
      .validBlock(ModBlocks.END_STONE_FABRICATOR)
      .register();

  public static final RegistryEntry<TileEntityType<FabricatorTile>> BLOCK_FABRICATOR = REGISTRATE.tileEntity("block_generator", FabricatorTile::new)
      .validBlock(ModBlocks.SAND_FABRICATOR)
      .validBlock(ModBlocks.RED_SAND_FABRICATOR)
      .validBlock(ModBlocks.CLAY_FABRICATOR)
      .validBlock(ModBlocks.NETHERRACK_FABRICATOR)
      .validBlock(ModBlocks.SOUL_SAND_FABRICATOR)
      .validBlock(ModBlocks.SLIME_FABRICATOR)
      .validBlock(ModBlocks.ICE_FABRICATOR)
      .validBlock(ModBlocks.SNOW_FABRICATOR)
      .validBlock(ModBlocks.DIRT_FABRICATOR)
      .validBlock(ModBlocks.GRAVEL_FABRICATOR)
      .register();

  public static final RegistryEntry<TileEntityType<WaterFabricatorTile>> WATER_FABRICATOR = REGISTRATE.tileEntity("water_fabricator", WaterFabricatorTile::new)
      .validBlock(ModBlocks.WATER_FABRICATOR)
      .register();

  public static final RegistryEntry<TileEntityType<CookieGeneratorTile>> COOKIE_GENERATOR = REGISTRATE.tileEntity("cookie_generator", CookieGeneratorTile::new)
      .validBlock(ModBlocks.COOKIE_GENERATOR)
      .register();

  public static void load() {

  }
}
