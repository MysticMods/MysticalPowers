package noobanidus.mods.mysticalpowers.init;

import com.tterrag.registrate.util.entry.RegistryEntry;
import epicsquid.mysticalworld.MWTags;
import net.minecraftforge.common.Tags;
import noobanidus.mods.mysticalpowers.MPTags;
import noobanidus.mods.mysticalpowers.items.EnergyItem;
import noobanidus.mods.mysticalpowers.recipes.BatteryRecipeBuilder;

import static noobanidus.mods.mysticalpowers.MysticalPowers.REGISTRATE;

public class ModItems {
  public static final RegistryEntry<EnergyItem> POWERCELL_TIN = REGISTRATE.item("tin_power_cell", (b) -> new EnergyItem(b, 250000, 5000, 5000))
      .recipe((ctx, p) ->
          BatteryRecipeBuilder.shapedRecipe(ModItems.POWERCELL_TIN.get(), 1)
              .patternLine("LRL")
              .patternLine("RBR")
              .patternLine("LRL")
              .key('L', MWTags.Items.TIN_INGOT)
              .key('R', Tags.Items.DUSTS_REDSTONE)
              .key('B', Tags.Items.STORAGE_BLOCKS_REDSTONE)
              .addCriterion("has_tin", p.hasItem(MWTags.Items.TIN_INGOT))
              .addCriterion("has_redstone", p.hasItem(Tags.Items.DUSTS_REDSTONE))
              .build(p)
      )
      .register();

  public static final RegistryEntry<EnergyItem> POWERCELL_LEAD = REGISTRATE.item("lead_power_cell", (b) -> new EnergyItem(b, 250000, 5000, 5000))
      .recipe((ctx, p) ->
          BatteryRecipeBuilder.shapedRecipe(ModItems.POWERCELL_LEAD.get(), 1)
              .patternLine("LRL")
              .patternLine("RBR")
              .patternLine("LRL")
              .key('L', MWTags.Items.LEAD_INGOT)
              .key('B', Tags.Items.STORAGE_BLOCKS_REDSTONE)
              .key('R', Tags.Items.DUSTS_REDSTONE)
              .addCriterion("has_lead", p.hasItem(MWTags.Items.LEAD_INGOT))
              .addCriterion("has_redstone", p.hasItem(Tags.Items.DUSTS_REDSTONE))
              .build(p)
      )
      .register();

  public static final RegistryEntry<EnergyItem> POWERCELL_COPPER = REGISTRATE.item("copper_power_cell", (b) -> new EnergyItem(b, 750000, 8000, 8000))
      .recipe((ctx, p) ->
          BatteryRecipeBuilder.shapedRecipe(ModItems.POWERCELL_COPPER.get(), 1)
              .patternLine("CPC")
              .patternLine("RPR")
              .patternLine("CPC")
              .key('C', MWTags.Items.COPPER_INGOT)
              .key('P', MPTags.Items.BASE_POWERCELL)
              .key('R', Tags.Items.DUSTS_REDSTONE)
              .addCriterion("has_lead", p.hasItem(ModItems.POWERCELL_LEAD.get()))
              .build(p)
      ).register();

  public static final RegistryEntry<EnergyItem> POWERCELL_SILVER = REGISTRATE.item("silver_power_cell", (b) -> new EnergyItem(b, 2250000, 10000, 10000))
      .recipe((ctx, p) ->
          BatteryRecipeBuilder.shapedRecipe(ModItems.POWERCELL_SILVER.get(), 1)
              .patternLine("CPC")
              .patternLine("RPR")
              .patternLine("CPC")
              .key('C', MWTags.Items.SILVER_INGOT)
              .key('P', ModItems.POWERCELL_COPPER.get())
              .key('R', Tags.Items.DUSTS_REDSTONE)
              .addCriterion("has_copper", p.hasItem(ModItems.POWERCELL_COPPER.get()))
              .build(p)
      )
      .register();

  public static final RegistryEntry<EnergyItem> POWERCELL_QUICKSILVER = REGISTRATE.item("quicksilver_power_cell", (b) -> new EnergyItem(b, 6750000, 25000, 25000))
      .recipe((ctx, p) ->
          BatteryRecipeBuilder.shapedRecipe(ModItems.POWERCELL_QUICKSILVER.get(), 1)
              .patternLine("CCC")
              .patternLine("LBL")
              .patternLine("CLC")
              .key('C', MWTags.Items.QUICKSILVER_INGOT)
              .key('L', ModItems.POWERCELL_SILVER.get())
              .key('B', Tags.Items.STORAGE_BLOCKS_REDSTONE)
              .addCriterion("has_silver", p.hasItem(ModItems.POWERCELL_COPPER.get()))
              .build(p)
      )
      .register();

  public static void load() {

  }
}
