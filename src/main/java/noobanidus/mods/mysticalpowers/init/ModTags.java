package noobanidus.mods.mysticalpowers.init;

import com.tterrag.registrate.providers.ProviderType;
import net.minecraft.item.Items;
import noobanidus.mods.mysticalpowers.MPTags;

import static noobanidus.mods.mysticalpowers.MysticalPowers.REGISTRATE;

public class ModTags {
  static {
    REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, (p) -> {
      p.getBuilder(MPTags.Items.COOKIES).add(Items.COOKIE).build(MPTags.Items.COOKIES.getId());
      p.getBuilder(MPTags.Items.GENERATOR_COOKIES).add(MPTags.Items.COOKIES).build(MPTags.Items.GENERATOR_COOKIES.getId());
      p.getBuilder(MPTags.Items.BASE_POWERCELL).add(ModItems.POWERCELL_LEAD.get(), ModItems.POWERCELL_TIN.get()).build(MPTags.Items.BASE_POWERCELL.getId());
    });
  }

  public static void load () {
  }
}
