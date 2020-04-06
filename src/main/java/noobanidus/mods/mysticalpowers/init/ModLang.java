package noobanidus.mods.mysticalpowers.init;

import static noobanidus.mods.mysticalpowers.MysticalPowers.REGISTRATE;

public class ModLang {
  static {
    REGISTRATE.addRawLang("mysticalpowers.tile.cookie_generator.contains", "Contains %s/%sFCE (Forge Cookie Energy)");
    REGISTRATE.addRawLang("mysticalpowers.tile.end_stone_generator.contains", "Contains %s End Stone (%s/%s FE)");
    REGISTRATE.addRawLang("mysticalpowers.tile.block_generator.contains", "Contains %s %s (%s/%s FE)");
    REGISTRATE.addRawLang("mysticalpowers.subtitles.block.charcoal_kiln.fire_crackle", "Charcoal Kiln crackles");
    REGISTRATE.addRawLang("mysticalpowers.subtitles.block.kiln.fire_crackle", "Kiln crackles");
    REGISTRATE.addRawLang("mysticalpowers.subtitles.block.cookie_generator.munch", "Generator munches");
    REGISTRATE.addRawLang("mysticalpowers.subtitles.block.end_stone_generator.generate", "End Stone Generator operates");
    REGISTRATE.addRawLang("mysticalpowers.energy_item.tooltip", "Energy: %s/%s FE");
    REGISTRATE.addRawLang("mysticalpowers.water_fabricator.tooltip", "Acts as an infinite water source. Does not require power.");
  }

  public static void load() {
  }
}
