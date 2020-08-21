package noobanidus.mods.mysticalpowers.init;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.util.SoundEvent;

import static noobanidus.mods.mysticalpowers.MysticalPowers.REGISTRATE;

public class ModSounds {
  public static final RegistryEntry<SoundEvent> COOKIE_MUNCH = REGISTRATE.soundEvent("cookie_munch", "block.cookie_generator.munch").register();

  public static final RegistryEntry<SoundEvent> END_STONE_GENERATE = REGISTRATE.soundEvent("end_stone_generate", "block.end_stone_generator.generate").register();

  public static void load() {

  }
}
