package noobanidus.mods.mysticalpowers.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

  private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
  public static List<FabricatorConfig> FABRICATOR_CONFIGS = new ArrayList<>();

  public static ForgeConfigSpec COMMON_CONFIG;
  public static FabricatorConfig END_STONE;


  static {
    COMMON_BUILDER.push("Fabricators");
    registerFabricators();
    //COMMON_BUILDER.pop();
    COMMON_CONFIG = COMMON_BUILDER.build();
  }

  public static void loadConfig(ForgeConfigSpec spec, Path path) {
    CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
    configData.load();
    spec.setConfig(configData);
  }

  public static void registerFabricators() {
    FABRICATOR_CONFIGS.add(new FabricatorConfig("sand", 1000000, 5000, 50, 25));
    FABRICATOR_CONFIGS.add(new FabricatorConfig("red_sand", 1000000, 5000, 250, 45));
    FABRICATOR_CONFIGS.add(new FabricatorConfig("clay", 1000000, 5000, 400, 65));
    FABRICATOR_CONFIGS.add(new FabricatorConfig("netherrack", 1000000, 5000, 50, 25));
    FABRICATOR_CONFIGS.add(new FabricatorConfig("soul_sand", 1000000, 5000, 400, 120));
    FABRICATOR_CONFIGS.add(new FabricatorConfig("slime", 1000000, 5000, 500, 70));
    FABRICATOR_CONFIGS.add(new FabricatorConfig("ice", 1000000, 5000, 250, 95));
    FABRICATOR_CONFIGS.add(new FabricatorConfig("snow", 1000000, 5000, 250, 95));
    FABRICATOR_CONFIGS.add(new FabricatorConfig("dirt", 1000000, 5000, 50, 25));
    FABRICATOR_CONFIGS.add(new FabricatorConfig("gravel", 1000000, 5000, 50, 25));
    END_STONE = new FabricatorConfig("end_stone", 1000000, 5000, 100, 25);

    FABRICATOR_CONFIGS.forEach(o -> o.apply(COMMON_BUILDER));
    END_STONE.apply(COMMON_BUILDER);
  }

  public static FabricatorConfig get(String name) {
    if (name.equals("end_stone")) {
      return END_STONE;
    }

    for (FabricatorConfig conf : FABRICATOR_CONFIGS) {
      if (conf.getName().equalsIgnoreCase(name)) {
        return conf;
      }
    }

    throw new IllegalStateException("Invalid config: " + name);
  }
}
