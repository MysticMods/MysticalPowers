package noobanidus.mods.mysticalpowers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class MPTags {
  public static class Items extends MPTags {
    public static Tags.IOptionalNamedTag<Item> COOKIES = compatTag("cookie");
    public static Tags.IOptionalNamedTag<Item> GENERATOR_COOKIES = modTag("generator_cookies");
    public static Tags.IOptionalNamedTag<Item> BASE_POWERCELL = modTag("base_powercells");

    public static Tags.IOptionalNamedTag<Item> COPPER_BLOCK = compatTag("storage_blocks/copper");
    public static Tags.IOptionalNamedTag<Item> COPPER_INGOT = compatTag("ingots/copper");
    public static Tags.IOptionalNamedTag<Item> LEAD_INGOT = compatTag("ingots/lead");
    public static Tags.IOptionalNamedTag<Item> QUICKSILVER_INGOT = compatTag("ingots/quicksilver");
    public static Tags.IOptionalNamedTag<Item> SILVER_INGOT = compatTag("ingots/silver");
    public static Tags.IOptionalNamedTag<Item> TIN_INGOT = compatTag("ingots/tin");

    public static Tags.IOptionalNamedTag<Item> SLIME = compatTag("slime");
    public static Tags.IOptionalNamedTag<Item> PURPUR = compatTag("purpur");
    public static Tags.IOptionalNamedTag<Item> NETHER_BRICKS = compatTag("nether_bricks");
    public static Tags.IOptionalNamedTag<Item> RED_NETHER_BRICKS = compatTag("red_nether_bricks");
    public static Tags.IOptionalNamedTag<Item> TERRACOTTA = compatTag("terracotta");

    static Tags.IOptionalNamedTag<Item> modTag(String name) {
      return ItemTags.createOptional(new ResourceLocation(MysticalPowers.MODID, name));
    }

    static Tags.IOptionalNamedTag<Item> compatTag(String name) {
      return ItemTags.createOptional(new ResourceLocation("forge", name));
    }
  }
}
