package noobanidus.mods.mysticalpowers;

import epicsquid.mysticalworld.init.ModEntities;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import noobanidus.mods.mysticalpowers.config.ConfigManager;
import noobanidus.mods.mysticalpowers.init.*;
import noobanidus.mods.mysticalpowers.registrate.CustomRegistrate;
import noobanidus.mods.mysticalpowers.setup.ClientSetup;
import noobanidus.mods.mysticalpowers.setup.ModSetup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mysticalpowers")
public class MysticalPowers {
  public static final Logger LOG = LogManager.getLogger();
  public static final String MODID = "mysticalpowers";

  public static final ItemGroup ITEM_GROUP = new ItemGroup("mysticalpowers") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(ModBlocks.COOKIE_GENERATOR.get());
    }
  };

  public static CustomRegistrate REGISTRATE;

  public static ModSetup setup = new ModSetup();

  public MysticalPowers() {
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigManager.COMMON_CONFIG);
    IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

    REGISTRATE = CustomRegistrate.create(MODID);
    REGISTRATE.itemGroup(() -> ITEM_GROUP);

    modBus.addListener(setup::init);
    DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> modBus.addListener(ClientSetup::init));

    ModItems.load();
    ModBlocks.load();
    ModEntities.load();
    ModTiles.load();
    ModRecipes.load();
    ModSounds.load();
    ModLang.load();
    ModTags.load();

    ConfigManager.loadConfig(ConfigManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + "-common.toml"));
  }
}
