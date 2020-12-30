package noobanidus.mods.mysticalpowers.init;

import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import epicsquid.mysticalworld.MWTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.Tags;
import noobanidus.mods.mysticalpowers.MysticalPowers;
import noobanidus.mods.mysticalpowers.blocks.*;
import noobanidus.mods.mysticalpowers.config.ConfigManager;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static noobanidus.mods.mysticalpowers.MysticalPowers.REGISTRATE;

public class ModBlocks {
  private static NonNullUnaryOperator<Block.Properties> FABRICATOR_PROPS = (o) -> o.hardnessAndResistance(4.5f).sound(SoundType.METAL).notSolid();

  public static RegistryEntry<CookieGeneratorBlock> COOKIE_GENERATOR = REGISTRATE.block("cookie_generator", Material.IRON, CookieGeneratorBlock::new)
      .properties(o -> o.hardnessAndResistance(2.5f).sound(SoundType.METAL))
      .item()
      .model((ctx, p) -> p.blockItem(() -> ctx.getEntry().getBlock()))
      .build()
      .recipe((ctx, p) ->
          ShapedRecipeBuilder.shapedRecipe(ModBlocks.COOKIE_GENERATOR.get(), 1)
              .patternLine("TCT")
              .patternLine("CMC")
              .patternLine("TCT")
              .key('T', MWTags.Items.TIN_INGOT)
              .key('C', Items.COOKIE)
              .key('M', ModBlocks.MACHINE_FRAMES.get(MachineFrame.LAPIS).get())
              .addCriterion("has_cookie", p.hasItem(Items.COOKIE))
              .build(p)
      )
      .blockstate((ctx, p) ->
          p.horizontalBlock(ctx.getEntry(), p.models().getExistingFile(p.blockTexture(ctx.getEntry())))
      ).register();

  public static RegistryEntry<InfiniteWaterFabricatorBlock> WATER_FABRICATOR = REGISTRATE.block("water_fabricator", Material.IRON, InfiniteWaterFabricatorBlock::new)
      .properties(o -> o.hardnessAndResistance(4f).sound(SoundType.METAL).notSolid())
      .item()
      .model((ctx, p) -> p.blockItem(() -> ctx.getEntry().getBlock()))
      .build()
      .blockstate((ctx, p) ->
          p.simpleBlock(ctx.getEntry(), p.models().getExistingFile(p.blockTexture(ctx.getEntry())))
      )
      .register();

  public static RegistryEntry<EndStoneFabricatorBlock> END_STONE_FABRICATOR = REGISTRATE.block("end_stone_fabricator", Material.IRON, EndStoneFabricatorBlock::new)
      .properties(o -> o.hardnessAndResistance(4.5f).sound(SoundType.METAL).notSolid())
      .blockstate((ctx, p) -> p.getVariantBuilder(ctx.getEntry()).forAllStates((state) -> ConfiguredModel.builder()
          .modelFile(p.models().getExistingFile(new ResourceLocation(MysticalPowers.MODID, "block/end_stone_fabricator")))
          .build()))
      .item()
      .model((ctx, p) -> p.blockItem(() -> ctx.getEntry().getBlock()))
      .build()
      .register();

  private static NonNullFunction<Block.Properties, FabricatorBlock> fabricatorBlock(Supplier<? extends
      IItemProvider> block, String config) {
    return (b) -> new FabricatorBlock(b, block, ConfigManager.get(config).values());
  }

  private static NonNullFunction<Block.Properties, FabricatorBlock> fabricatorBlock(IItemProvider block, String config) {
    return fabricatorBlock(() -> block, config);
  }

  public static RegistryEntry<FabricatorBlock> SAND_FABRICATOR = REGISTRATE.block("sand_fabricator", Material.IRON, fabricatorBlock(Blocks.SAND, "sand"))
      .properties(FABRICATOR_PROPS)
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().getExistingFile(p.blockTexture(ctx.getEntry()))))
      .item()
      .model((ctx, p) -> p.blockItem(() -> ctx.getEntry().getBlock()))
      .build()
      .register();

  public static RegistryEntry<FabricatorBlock> RED_SAND_FABRICATOR = REGISTRATE.block("red_sand_fabricator", Material.IRON, fabricatorBlock(Blocks.RED_SAND, "red_sand"))
      .properties(FABRICATOR_PROPS)
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().getExistingFile(p.blockTexture(ctx.getEntry()))))
      .item()
      .model((ctx, p) -> p.blockItem(() -> ctx.getEntry().getBlock()))
      .build()
      .register();

  public static RegistryEntry<FabricatorBlock> CLAY_FABRICATOR = REGISTRATE.block("clay_fabricator", Material.IRON, fabricatorBlock(Blocks.CLAY, "clay"))
      .properties(FABRICATOR_PROPS)
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().getExistingFile(p.blockTexture(ctx.getEntry()))))
      .item()
      .model((ctx, p) -> p.blockItem(() -> ctx.getEntry().getBlock()))
      .build()
      .register();

  public static RegistryEntry<FabricatorBlock> NETHERRACK_FABRICATOR = REGISTRATE.block("netherrack_fabricator", Material.IRON, fabricatorBlock(Blocks.NETHERRACK, "netherrack"))
      .properties(FABRICATOR_PROPS)
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().getExistingFile(p.blockTexture(ctx.getEntry()))))
      .item()
      .model((ctx, p) -> p.blockItem(() -> ctx.getEntry().getBlock()))
      .build()
      .register();

  public static RegistryEntry<FabricatorBlock> SOUL_SAND_FABRICATOR = REGISTRATE.block("soul_sand_fabricator", Material.IRON, fabricatorBlock(Blocks.SOUL_SAND, "soul_sand"))
      .properties(FABRICATOR_PROPS)
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().getExistingFile(p.blockTexture(ctx.getEntry()))))
      .item()
      .model((ctx, p) -> p.blockItem(() -> ctx.getEntry().getBlock()))
      .build()
      .register();

  public static RegistryEntry<FabricatorBlock> SLIME_FABRICATOR = REGISTRATE.block("slime_fabricator", Material.IRON, fabricatorBlock(Items.SLIME_BALL, "slime"))
      .properties(FABRICATOR_PROPS)
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().getExistingFile(p.blockTexture(ctx.getEntry()))))
      .item()
      .model((ctx, p) -> p.blockItem(() -> ctx.getEntry().getBlock()))
      .build()
      .register();

  public static RegistryEntry<FabricatorBlock> ICE_FABRICATOR = REGISTRATE.block("ice_fabricator", Material.IRON, fabricatorBlock(Blocks.ICE, "ice"))
      .properties(FABRICATOR_PROPS)
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().getExistingFile(p.blockTexture(ctx.getEntry()))))
      .item()
      .model((ctx, p) -> p.blockItem(() -> ctx.getEntry().getBlock()))
      .build()
      .register();

  public static RegistryEntry<FabricatorBlock> SNOW_FABRICATOR = REGISTRATE.block("snow_fabricator", Material.IRON, fabricatorBlock(Blocks.SNOW, "snow"))
      .properties(FABRICATOR_PROPS)
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().getExistingFile(p.blockTexture(ctx.getEntry()))))
      .item()
      .model((ctx, p) -> p.blockItem(() -> ctx.getEntry().getBlock()))
      .build()
      .register();

  public static RegistryEntry<FabricatorBlock> DIRT_FABRICATOR = REGISTRATE.block("dirt_fabricator", Material.IRON, fabricatorBlock(Blocks.DIRT, "dirt"))
      .properties(FABRICATOR_PROPS)
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().getExistingFile(p.blockTexture(ctx.getEntry()))))
      .item()
      .model((ctx, p) -> p.blockItem(() -> ctx.getEntry().getBlock()))
      .build()
      .register();

  public static RegistryEntry<FabricatorBlock> GRAVEL_FABRICATOR = REGISTRATE.block("gravel_fabricator", Material.IRON, fabricatorBlock(Blocks.GRAVEL, "gravel"))
      .properties(FABRICATOR_PROPS)
      .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().getExistingFile(p.blockTexture(ctx.getEntry()))))
      .item()
      .model((ctx, p) -> p.blockItem(() -> ctx.getEntry().getBlock()))
      .build()
      .register();

  public static Map<MachineFrame, RegistryEntry<MachineFrameBlock>> MACHINE_FRAMES = new HashMap<>();

  static {
    for (MachineFrame type : MachineFrame.values()) {
      String frameName = type.getName() + "_machine_frame";

      RegistryEntry<MachineFrameBlock> frameObject = REGISTRATE.block(frameName, Material.IRON, (b) -> new MachineFrameBlock(b, type))
          .properties(o -> o.hardnessAndResistance(2f).sound(SoundType.METAL))
          .blockstate((ctx, p) -> p.simpleBlock(ctx.getEntry(), p.models().getExistingFile(type.model())))
          .item()
          .model((ctx, p) -> p.blockItem(() -> ctx.getEntry().getBlock()))
          .build()
          .recipe((ctx, p) ->
              ShapedRecipeBuilder.shapedRecipe(ModBlocks.MACHINE_FRAMES.get(type).get(), 1)
                  .patternLine("IXI")
                  .patternLine("XGX")
                  .patternLine("IXI")
                  .key('X', type.getTag())
                  .key('G', Tags.Items.GLASS)
                  .key('I', Tags.Items.INGOTS_IRON)
                  .addCriterion("has_" + type.getTag().getName(), p.hasItem(type.getTag()))
                  .build(p)
          )
          .register();
      MACHINE_FRAMES.put(type, frameObject);
    }
  }

  public static void load() {
  }
}
