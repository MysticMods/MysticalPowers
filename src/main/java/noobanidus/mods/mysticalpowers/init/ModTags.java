package noobanidus.mods.mysticalpowers.init;

import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import mysticmods.mysticalworld.MWTags;
import mysticmods.mysticalworld.init.ModBlocks;
import mysticmods.mysticalworld.init.ModMaterials;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.Tags;
import noobanidus.mods.mysticalpowers.MPTags;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static noobanidus.mods.mysticalpowers.MysticalPowers.REGISTRATE;

public class ModTags {
  @FunctionalInterface
  private interface Additionals<T> {
    void add(Tags.IOptionalNamedTag<T>... tags);
  }

  private static class ItemBuilder {
    private RegistrateTagsProvider<Item> provider;

    private ItemBuilder(RegistrateTagsProvider<Item> provider) {
      this.provider = provider;
    }

    private void add(Tags.IOptionalNamedTag<Item> tag, Supplier<? extends IItemProvider>... items) {
      provider.getOrCreateBuilder(tag).add(Stream.of(items).map(Supplier::get).map(IItemProvider::asItem).toArray(Item[]::new));
    }

    private void add(Tags.IOptionalNamedTag<Item> tag, IItemProvider... items) {
      provider.getOrCreateBuilder(tag).add(Stream.of(items).map(IItemProvider::asItem).toArray(Item[]::new));
    }

    private void add(Tags.IOptionalNamedTag<Item> tag, Tags.IOptionalNamedTag<Item> tag2) {
      provider.getOrCreateBuilder(tag).addTags(tag2);
    }

    private Additionals<Item> additional(Tags.IOptionalNamedTag<Item> tag) {
      return (o) -> provider.getOrCreateBuilder(tag).addTags(o);
    }
  }

  static {
    REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, (p) -> {
      ItemBuilder b = new ItemBuilder(p);
      p.getOrCreateBuilder(MPTags.Items.COOKIES).add(Items.COOKIE);
      p.getOrCreateBuilder(MPTags.Items.GENERATOR_COOKIES).addTag(MPTags.Items.COOKIES);
      p.getOrCreateBuilder(MPTags.Items.BASE_POWERCELL).add(ModItems.POWERCELL_LEAD.get(), ModItems.POWERCELL_TIN.get());
      p.getOrCreateBuilder(MPTags.Items.COPPER_BLOCK).add(ModMaterials.COPPER.getBlock().get().asItem());
      p.getOrCreateBuilder(MPTags.Items.COPPER_INGOT).add(ModMaterials.COPPER.getItem().get().asItem());
      p.getOrCreateBuilder(MPTags.Items.LEAD_INGOT).add(ModMaterials.LEAD.getItem().get().asItem());
      p.getOrCreateBuilder(MPTags.Items.QUICKSILVER_INGOT).add(ModMaterials.QUICKSILVER.getItem().get().asItem());
      p.getOrCreateBuilder(MPTags.Items.SILVER_INGOT).add(ModMaterials.SILVER.getItem().get().asItem());
      p.getOrCreateBuilder(MPTags.Items.TIN_INGOT).add(ModMaterials.TIN.getItem().get().asItem());

      b.add(MWTags.Items.SLIME, Items.SLIME_BALL);
      b.add(MWTags.Items.PURPUR, Blocks.PURPUR_BLOCK, Blocks.PURPUR_PILLAR);
      b.add(MWTags.Items.NETHER_BRICKS, Blocks.NETHER_BRICKS);
      b.add(MWTags.Items.RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);
      b.add(MWTags.Items.TERRACOTTA, Blocks.WHITE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.PINK_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.BLACK_TERRACOTTA, Blocks.TERRACOTTA, ModBlocks.TERRACOTTA_BRICK.get());
    });
  }

  public static void load() {
  }
}
