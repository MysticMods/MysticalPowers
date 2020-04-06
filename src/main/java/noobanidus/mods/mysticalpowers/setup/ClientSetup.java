package noobanidus.mods.mysticalpowers.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.fluid.Fluids;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import noobanidus.mods.mysticalpowers.init.ModBlocks;

@OnlyIn(Dist.CLIENT)
public class ClientSetup {
  public static void init(FMLClientSetupEvent event) {
    Minecraft mc = Minecraft.getInstance();

    mc.getBlockColors().register((state, world, pos, index) -> Fluids.WATER.getAttributes().getColor(world, pos), ModBlocks.WATER_FABRICATOR.get());
    mc.getItemColors().register((p1, index) -> Fluids.WATER.getAttributes().getColor(), ModBlocks.WATER_FABRICATOR.get());
  }
}
