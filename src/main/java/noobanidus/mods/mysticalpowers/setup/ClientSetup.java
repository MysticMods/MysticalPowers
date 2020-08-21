package noobanidus.mods.mysticalpowers.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.fluid.Fluids;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import noobanidus.mods.mysticalpowers.init.ModBlocks;

@OnlyIn(Dist.CLIENT)
public class ClientSetup {
  @SuppressWarnings("deprecation")
  public static void init(FMLClientSetupEvent event) {
    DeferredWorkQueue.runLater(() -> {
      RenderType cutout = RenderType.getCutoutMipped();
      RenderTypeLookup.setRenderLayer(ModBlocks.WATER_FABRICATOR.get(), cutout);
      RenderTypeLookup.setRenderLayer(ModBlocks.END_STONE_FABRICATOR.get(), cutout);
      RenderTypeLookup.setRenderLayer(ModBlocks.SAND_FABRICATOR.get(), cutout);
      RenderTypeLookup.setRenderLayer(ModBlocks.RED_SAND_FABRICATOR.get(), cutout);
      RenderTypeLookup.setRenderLayer(ModBlocks.CLAY_FABRICATOR.get(), cutout);
      RenderTypeLookup.setRenderLayer(ModBlocks.NETHERRACK_FABRICATOR.get(), cutout);
      RenderTypeLookup.setRenderLayer(ModBlocks.SOUL_SAND_FABRICATOR.get(), cutout);
      RenderTypeLookup.setRenderLayer(ModBlocks.SLIME_FABRICATOR.get(), cutout);
      RenderTypeLookup.setRenderLayer(ModBlocks.ICE_FABRICATOR.get(), cutout);
      RenderTypeLookup.setRenderLayer(ModBlocks.SNOW_FABRICATOR.get(), cutout);
      RenderTypeLookup.setRenderLayer(ModBlocks.DIRT_FABRICATOR.get(), cutout);
      RenderTypeLookup.setRenderLayer(ModBlocks.GRAVEL_FABRICATOR.get(), cutout);
      ModBlocks.MACHINE_FRAMES.values().forEach(o -> RenderTypeLookup.setRenderLayer(o.get(), cutout));
      Minecraft mc = Minecraft.getInstance();

      mc.getBlockColors().register((state, world, pos, index) -> Fluids.WATER.getAttributes().getColor(world, pos), ModBlocks.WATER_FABRICATOR.get());
      mc.getItemColors().register((p1, index) -> Fluids.WATER.getAttributes().getColor(), ModBlocks.WATER_FABRICATOR.get());
    });
  }
}
