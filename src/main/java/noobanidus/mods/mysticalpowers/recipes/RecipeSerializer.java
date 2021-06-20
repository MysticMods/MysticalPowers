package noobanidus.mods.mysticalpowers.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import mysticmods.mysticalworld.recipe.AbstractCookingRecipeSerializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeSerializer<T extends AbstractCookingRecipe> extends AbstractCookingRecipeSerializer<T> {
  protected RecipeSerializer(IFactory<T> serializer, int defaultCookTime) {
    super(serializer, defaultCookTime);
  }

  @Override
  public T read(ResourceLocation recipeId, JsonObject json) {
    String s = JSONUtils.getString(json, "group", "");
    JsonElement jsonelement = (JSONUtils.isJsonArray(json, "ingredient") ? JSONUtils.getJsonArray(json, "ingredient") : JSONUtils.getJsonObject(json, "ingredient"));
    Ingredient ingredient = Ingredient.deserialize(jsonelement);
    if (!json.has("result"))
      throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
    int count = JSONUtils.getInt(json, "itemcount", 1);
    ItemStack itemstack;
    if (json.get("result").isJsonObject())
      itemstack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
    else {
      String s1 = JSONUtils.getString(json, "result");
      ResourceLocation resourcelocation = new ResourceLocation(s1);
      Item item = ForgeRegistries.ITEMS.getValue(resourcelocation);
      if (item == null) {
        throw new IllegalStateException("Item: " + s1 + " does not exist");
      }
      itemstack = new ItemStack(item, count);
    }
    float f = JSONUtils.getFloat(json, "experience", 0.0F);
    int i = JSONUtils.getInt(json, "cookingtime", this.defaultCookTime);
    return this.serializer.create(recipeId, s, ingredient, itemstack, f, i);
  }
}
