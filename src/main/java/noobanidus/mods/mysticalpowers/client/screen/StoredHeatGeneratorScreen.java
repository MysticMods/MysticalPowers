package noobanidus.mods.mysticalpowers.client.screen;

import com.mojang.blaze3d.platform.GlStateManager;
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
  public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
    this.renderHoveredToolTip(p_render_1_, p_render_2_);
  }

  /**
   * Draw the foreground layer for the GuiContainer (everything in front of the items)
   */
  @Override
  protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
    String s = this.title.getFormattedText();
    this.font.drawString(s, (float) (this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 4210752);
    this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 96 + 2), 4210752);
  }

  /**
   * Draws the background layer of this container (behind the items).
   */
  @Override
  protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.minecraft.getTextureManager().bindTexture(guiTexture);
    int i = this.guiLeft;
    int j = this.guiTop;
    this.blit(i, j, 0, 0, this.xSize, this.ySize);
    /*
    if (((AbstractFurnaceContainer)this.container).func_217061_l()) {
      int k = ((AbstractFurnaceContainer)this.container).getBurnLeftScaled();
      this.blit(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
    }

    int l = ((AbstractFurnaceContainer)this.container).getCookProgressionScaled();
    this.blit(i + 79, j + 34, 176, 14, l + 1, 16);*/
  }
}

