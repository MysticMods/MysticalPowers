package noobanidus.mods.mysticalpowers.init;

import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.RegistryEntry;
import epicsquid.mysticalworld.MWTags;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import noobanidus.mods.mysticalpowers.blocks.MachineFrame;
import noobanidus.mods.mysticalpowers.recipes.BatteryRecipe;

import static noobanidus.mods.mysticalpowers.MysticalPowers.REGISTRATE;

public class ModRecipes {
  public static final RegistryEntry<BatteryRecipe.Serializer> BATTERY_SERIALIZER = REGISTRATE.recipeSerializer("battery", BatteryRecipe.Serializer::new).register();

  static {
    // TODO: Move these into the actual blocks
    REGISTRATE.addDataGenerator(ProviderType.RECIPE, (p) -> {
      ShapedRecipeBuilder.shapedRecipe(ModBlocks.WATER_FABRICATOR.get(), 1)
          .patternLine(" B ")
          .patternLine("BMB")
          .patternLine(" B ")
          .key('M', ModBlocks.MACHINE_FRAMES.get(MachineFrame.REINFORCED).get())
          .key('B', Items.WATER_BUCKET)
          .addCriterion("has_water_bucket", p.hasItem(Items.WATER_BUCKET))
          .build(p);

      ShapedRecipeBuilder.shapedRecipe(ModBlocks.END_STONE_FABRICATOR.get(), 1)
          .patternLine("ECE")
          .patternLine("EME")
          .patternLine("PPP")
          .key('M', ModBlocks.MACHINE_FRAMES.get(MachineFrame.CHORUS).get())
          .key('C', Items.CHORUS_FLOWER)
          .key('E', Tags.Items.END_STONES)
          .key('P', Items.PURPUR_PILLAR)
          .addCriterion("has_chorus_flower", p.hasItem(Items.CHORUS_FLOWER))
          .build(p);

      ShapedRecipeBuilder.shapedRecipe(ModBlocks.SAND_FABRICATOR.get(), 1)
          .patternLine("TST")
          .patternLine("TMT")
          .patternLine("CHC")
          .key('M', ModBlocks.MACHINE_FRAMES.get(MachineFrame.TERRACOTTA).get())
          .key('T', MWTags.Items.TIN_INGOT)
          .key('S', ItemTags.SAND)
          .key('C', Items.CUT_SANDSTONE)
          .key('H', Items.CHISELED_SANDSTONE)
          .addCriterion("has_sand", p.hasItem(Items.SAND))
          .build(p);

      ShapedRecipeBuilder.shapedRecipe(ModBlocks.RED_SAND_FABRICATOR.get(), 1)
          .patternLine("TST")
          .patternLine("TMT")
          .patternLine("CHC")
          .key('M', ModBlocks.MACHINE_FRAMES.get(MachineFrame.TERRACOTTA).get())
          .key('T', MWTags.Items.TIN_INGOT)
          .key('S', Tags.Items.STORAGE_BLOCKS_REDSTONE)
          .key('C', Items.CUT_SANDSTONE)
          .key('H', Items.CHISELED_SANDSTONE)
          .addCriterion("has_sand", p.hasItem(Items.SAND))
          .build(p);

      ShapedRecipeBuilder.shapedRecipe(ModBlocks.CLAY_FABRICATOR.get(), 1)
          .patternLine("BCB")
          .patternLine("BMB")
          .patternLine("YYY")
          .key('M', ModBlocks.MACHINE_FRAMES.get(MachineFrame.TERRACOTTA).get())
          .key('B', Tags.Items.INGOTS_BRICK)
          .key('C', Items.CLAY)
          .key('Y', Items.BRICKS)
          .addCriterion("has_clay", p.hasItem(Items.CLAY_BALL))
          .build(p);

      ShapedRecipeBuilder.shapedRecipe(ModBlocks.NETHERRACK_FABRICATOR.get(), 1)
          .patternLine("GNG")
          .patternLine("GMG")
          .patternLine("BBB")
          .key('M', ModBlocks.MACHINE_FRAMES.get(MachineFrame.NETHER).get())
          .key('G', Tags.Items.INGOTS_GOLD)
          .key('N', Tags.Items.NETHERRACK)
          .key('B', Items.NETHER_BRICKS)
          .addCriterion("has_netherrack", p.hasItem(Items.NETHERRACK))
          .build(p);

      ShapedRecipeBuilder.shapedRecipe(ModBlocks.SOUL_SAND_FABRICATOR.get(), 1)
          .patternLine("GNG")
          .patternLine("gMg")
          .patternLine("BBB")
          .key('M', ModBlocks.MACHINE_FRAMES.get(MachineFrame.RED_NETHER).get())
          .key('G', Tags.Items.INGOTS_GOLD)
          .key('g', Tags.Items.STORAGE_BLOCKS_GOLD)
          .key('N', Items.SOUL_SAND)
          .key('B', Items.RED_NETHER_BRICKS)
          .addCriterion("has_soul_sand", p.hasItem(Items.SOUL_SAND))
          .build(p);

      ShapedRecipeBuilder.shapedRecipe(ModBlocks.SLIME_FABRICATOR.get(), 1)
          .patternLine("SCS")
          .patternLine("SMS")
          .patternLine("GGG")
          .key('M', ModBlocks.MACHINE_FRAMES.get(MachineFrame.SLIME).get())
          .key('S', Items.SLIME_BALL)
          .key('C', MWTags.Items.COPPER_BLOCK)
          .key('G', Items.GREEN_GLAZED_TERRACOTTA)
          .addCriterion("has_slime", p.hasItem(Items.SLIME_BALL))
          .build(p);

      ShapedRecipeBuilder.shapedRecipe(ModBlocks.ICE_FABRICATOR.get(), 1)
          .patternLine("QWQ")
          .patternLine("QMQ")
          .patternLine("LLL")
          .key('M', ModBlocks.MACHINE_FRAMES.get(MachineFrame.QUICKSILVER).get())
          .key('Q', MWTags.Items.QUICKSILVER_INGOT)
          .key('W', Items.WATER_BUCKET)
          .key('L', Items.LIGHT_BLUE_WOOL)
          .addCriterion("has_quicksilver", p.hasItem(MWTags.Items.QUICKSILVER_INGOT))
          .build(p);

      ShapedRecipeBuilder.shapedRecipe(ModBlocks.SNOW_FABRICATOR.get(), 1)
          .patternLine("QWQ")
          .patternLine("QMQ")
          .patternLine("LLL")
          .key('M', ModBlocks.MACHINE_FRAMES.get(MachineFrame.QUICKSILVER).get())
          .key('Q', MWTags.Items.QUICKSILVER_INGOT)
          .key('W', Items.WATER_BUCKET)
          .key('L', Items.WHITE_WOOL)
          .addCriterion("has_quicksilver", p.hasItem(MWTags.Items.QUICKSILVER_INGOT))
          .build(p);

      ShapedRecipeBuilder.shapedRecipe(ModBlocks.DIRT_FABRICATOR.get(), 1)
          .patternLine("DDD")
          .patternLine("DMD")
          .patternLine("BBB")
          .key('M', ModBlocks.MACHINE_FRAMES.get(MachineFrame.STONE).get())
          .key('D', Items.DIRT)
          .key('B', ItemTags.STONE_BRICKS)
          .addCriterion("has_dirt", p.hasItem(Items.DIRT))
          .build(p);

      ShapedRecipeBuilder.shapedRecipe(ModBlocks.GRAVEL_FABRICATOR.get(), 1)
          .patternLine("DDD")
          .patternLine("DMD")
          .patternLine("BBB")
          .key('M', ModBlocks.MACHINE_FRAMES.get(MachineFrame.STONE).get())
          .key('D', Items.GRAVEL)
          .key('B', ItemTags.STONE_BRICKS)
          .addCriterion("has_gravel", p.hasItem(Items.GRAVEL))
          .build(p);
    });
  }

  public static void load() {

  }
}
