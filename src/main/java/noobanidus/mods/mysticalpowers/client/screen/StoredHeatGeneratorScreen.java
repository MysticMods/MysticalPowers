package noobanidus.mods.mysticalpowers.client.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import noobanidus.mods.mysticalpowers.MysticalPowers;
import noobanidus.mods.mysticalpowers.container.StoredHeatGeneratorContainer;

@OnlyIn(Dist.CLIENT)
public class StoredHeatGeneratorScreen extends ContainerScreen<StoredHeatGeneratorContainer> {
  private static final ResourceLocation guiTexture = new ResourceLocation(MysticalPowers.MODID, "textures/gui/stored_heat_generator.png");

  public StoredHeatGeneratorScreen(StoredHeatGeneratorContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
    super(screenContainer, inv, titleIn);
  }

  @Override
  public void render(MatrixStack stack, int p_render_1_, int p_render_2_, float p_render_3_) {
    this.renderHoveredTooltip(stack, p_render_1_, p_render_2_);
  }

  /**
   * Draws the background layer of this container (behind the items).
   */
  @Override
  protected void drawGuiContainerBackgroundLayer(MatrixStack stack, float partialTicks, int mouseX, int mouseY) {
    RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.minecraft.getTextureManager().bindTexture(guiTexture);
    int i = this.guiLeft;
    int j = this.guiTop;
    this.blit(stack, i, j, 0, 0, this.xSize, this.ySize);
    /*
    if (((AbstractFurnaceContainer)this.container).func_217061_l()) {
      int k = ((AbstractFurnaceContainer)this.container).getBurnLeftScaled();
      this.blit(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
    }

    int l = ((AbstractFurnaceContainer)this.container).getCookProgressionScaled();
    this.blit(i + 79, j + 34, 176, 14, l + 1, 16);*/
  }
}

