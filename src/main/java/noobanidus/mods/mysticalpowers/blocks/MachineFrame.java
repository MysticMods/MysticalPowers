package noobanidus.mods.mysticalpowers.blocks;

import epicsquid.mysticalworld.MWTags;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import noobanidus.mods.mysticalpowers.MysticalPowers;

import javax.annotation.Nullable;

public enum MachineFrame {
/*  AMETHYST("amethyst", MWTags.Items.AMETHYST_GEM),*/
  CHORUS("chorus", MWTags.Items.PURPUR),
/*  COPPER("copper", MWTags.Items.COPPER_INGOT),
  DIAMOND("diamond", Tags.Items.GEMS_DIAMOND),
  EMERALD("emerald", Tags.Items.GEMS_EMERALD),
  GOLD("gold", Tags.Items.INGOTS_GOLD),
  IRON("iron", Tags.Items.INGOTS_IRON),*/
  LAPIS("lapis", Tags.Items.GEMS_LAPIS),
/*  LEAD("lead", MWTags.Items.LEAD_INGOT),*/
  NETHER("nether", MWTags.Items.NETHER_BRICKS),
/*  PRISMARINE("prismarine", Tags.Items.GEMS_PRISMARINE),*/
  QUICKSILVER("quicksilver", MWTags.Items.QUICKSILVER_INGOT),
/*  REDSTONE("redstone", Tags.Items.DUSTS_REDSTONE),*/
  RED_NETHER("red_nether", MWTags.Items.RED_NETHER_BRICKS),
  REINFORCED("reinforced", Tags.Items.STORAGE_BLOCKS_IRON),
/*  SILVER("silver", MWTags.Items.SILVER_INGOT),*/
  SLIME("slime", MWTags.Items.SLIME),
  STONE("stone", Tags.Items.STONE),
  TERRACOTTA("terracotta", MWTags.Items.TERRACOTTA),
/*  TIN("tin", MWTags.Items.TIN_INGOT),*/
  WOOD("wood", ItemTags.PLANKS)
  ;

  private String name;
  private ITag.INamedTag<Item> tag;

  MachineFrame(String name, ITag .INamedTag<Item> tag) {
    this.name = name;
    this.tag = tag;
  }

  public ITag.INamedTag<Item> getTag() {
    return tag;
  }

  public String getName() {
    return name;
  }

  public ResourceLocation model () {
    return new ResourceLocation(MysticalPowers.MODID, "block/" + name + "_machine_frame");
  }

  @Nullable
  public static MachineFrame getByName (String name) {
    for (MachineFrame t : values()) {
      if (t.getName().equals(name)) {
        return t;
      }
    }

    return null;
  }

  @Nullable
  public static MachineFrame getByOrdinal (int ord) {
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
