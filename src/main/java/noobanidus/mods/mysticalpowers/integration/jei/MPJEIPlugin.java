package noobanidus.mods.mysticalpowers.integration.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.*;
import net.minecraft.util.ResourceLocation;
import noobanidus.mods.mysticalpowers.MysticalPowers;

@SuppressWarnings("unchecked")
@JeiPlugin
public class MPJEIPlugin implements IModPlugin {
  private static final ResourceLocation UID = new ResourceLocation(MysticalPowers.MODID, MysticalPowers.MODID);

  @Override
  public ResourceLocation getPluginUid() {
    return UID;
  }

  @Override
  public void registerCategories(IRecipeCategoryRegistration registration) {
    IJeiHelpers jeiHelpers = registration.getJeiHelpers();
    IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
  }

  @Override
  public void registerRecipes(IRecipeRegistration registration) {
  }

  @Override
  public void registerGuiHandlers(IGuiHandlerRegistration registration) {
  }

  @Override
  public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
  }

  @Override
  public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
  }
}
