package noobanidus.mods.mysticalpowers.data;

import epicsquid.mysticallib.data.DeferredItemTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Items;
import noobanidus.mods.mysticalpowers.init.ModItems;

import static noobanidus.mods.mysticalpowers.MPTags.Items.*;

public class MMItemTagsProvider extends DeferredItemTagsProvider {
  public MMItemTagsProvider(DataGenerator generatorIn) {
    super(generatorIn, "Mystical Machinery Item Tags Provider");
  }

  @Override
  protected void registerTags() {
    addItemsToTag(COOKIES, () -> Items.COOKIE);
    appendToTag(GENERATOR_COOKIES, COOKIES);
    addItemsToTag(BASE_POWERCELL, ModItems.POWERCELL_LEAD, ModItems.POWERCELL_TIN);
  }
}
