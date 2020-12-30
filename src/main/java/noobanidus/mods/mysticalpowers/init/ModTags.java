package noobanidus.mods.mysticalpowers.init;

import com.tterrag.registrate.providers.ProviderType;
import net.minecraft.item.Items;
import noobanidus.mods.mysticalpowers.MPTags;

import static noobanidus.mods.mysticalpowers.MysticalPowers.REGISTRATE;

public class ModTags {
  static {
    REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, (p) -> {
      p.getOrCreateBuilder(MPTags.Items.COOKIES).add(Items.COOKIE);
      p.getOrCreateBuilder(MPTags.Items.GENERATOR_COOKIES).addTag(MPTags.Items.COOKIES);
      p.getOrCreateBuilder(MPTags.Items.BASE_POWERCELL).add(ModItems.POWERCELL_LEAD.get(), ModItems.POWERCELL_TIN.get());
    });
  }

  public static void load () {
  }
}
