package noobanidus.mods.mysticalpowers.blocks;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import noobanidus.mods.mysticalpowers.MPTags;
import noobanidus.mods.mysticalpowers.MysticalPowers;

import javax.annotation.Nullable;

public enum MachineFrame {
  /*  AMETHYST("amethyst", MPTags.Items.AMETHYST_GEM),*/
  CHORUS("chorus", MPTags.Items.PURPUR),
  /*  COPPER("copper", MPTags.Items.COPPER_INGOT),
    DIAMOND("diamond", Tags.Items.GEMS_DIAMOND),
    EMERALD("emerald", Tags.Items.GEMS_EMERALD),
    GOLD("gold", Tags.Items.INGOTS_GOLD),
    IRON("iron", Tags.Items.INGOTS_IRON),*/
  LAPIS("lapis", Tags.Items.GEMS_LAPIS),
  /*  LEAD("lead", MPTags.Items.LEAD_INGOT),*/
  NETHER("nether", MPTags.Items.NETHER_BRICKS),
  /*  PRISMARINE("prismarine", Tags.Items.GEMS_PRISMARINE),*/
  QUICKSILVER("quicksilver", MPTags.Items.QUICKSILVER_INGOT),
  /*  REDSTONE("redstone", Tags.Items.DUSTS_REDSTONE),*/
  RED_NETHER("red_nether", MPTags.Items.RED_NETHER_BRICKS),
  REINFORCED("reinforced", Tags.Items.STORAGE_BLOCKS_IRON),
  /*  SILVER("silver", MPTags.Items.SILVER_INGOT),*/
  SLIME("slime", MPTags.Items.SLIME),
  STONE("stone", Tags.Items.STONE),
  TERRACOTTA("terracotta", MPTags.Items.TERRACOTTA),
  /*  TIN("tin", MPTags.Items.TIN_INGOT),*/
  WOOD("wood", ItemTags.PLANKS);

  private String name;
  private ITag.INamedTag<Item> tag;

  MachineFrame(String name, ITag.INamedTag<Item> tag) {
    this.name = name;
    this.tag = tag;
  }

  public ITag.INamedTag<Item> getTag() {
    return tag;
  }

  public String getName() {
    return name;
  }

  public ResourceLocation model() {
    return new ResourceLocation(MysticalPowers.MODID, "block/" + name + "_machine_frame");
  }

  @Nullable
  public static MachineFrame getByName(String name) {
    for (MachineFrame t : values()) {
      if (t.getName().equals(name)) {
        return t;
      }
    }

    return null;
  }

  @Nullable
  public static MachineFrame getByOrdinal(int ord) {
    int i = 0;
    for (MachineFrame t : values()) {
      if (i == ord) {
        return t;
      }
      i++;
    }

    return null;
  }
}
