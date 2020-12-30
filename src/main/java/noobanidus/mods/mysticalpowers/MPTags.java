package noobanidus.mods.mysticalpowers;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeTagHandler;
import net.minecraftforge.registries.ForgeRegistries;

public class MPTags {
  public static class Items extends MPTags {
    public static ITag.INamedTag<Item> COOKIES = compatTag("cookie");
    public static ITag.INamedTag<Item> GENERATOR_COOKIES = modTag("generator_cookies");
    public static ITag.INamedTag<Item> BASE_POWERCELL = modTag("base_powercells");

    static ITag.INamedTag<Item> modTag(String name) {
      return ForgeTagHandler.makeWrapperTag(ForgeRegistries.ITEMS, new ResourceLocation(MysticalPowers.MODID, name));
    }

    static ITag.INamedTag<Item> compatTag(String name) {
      return ForgeTagHandler.makeWrapperTag(ForgeRegistries.ITEMS, new ResourceLocation("forge", name));
    }
  }
}
