package noobanidus.mods.mysticalpowers.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.*;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidUtil;
import noobanidus.mods.mysticalpowers.tiles.WaterFabricatorTile;

import javax.annotation.Nullable;
import java.util.List;

@SuppressWarnings("deprecation")
public class InfiniteWaterFabricatorBlock extends Block {
  public InfiniteWaterFabricatorBlock(Properties properties) {
    super(properties);
  }

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if (!worldIn.isRemote) {
      if (FluidUtil.interactWithFluidHandler(player, handIn, WaterFabricatorTile.WATER)) {
        return ActionResultType.SUCCESS;
      } else {
        return ActionResultType.FAIL;
      }
    }

    return ActionResultType.SUCCESS;
  }

  @Override
  public BlockRenderType getRenderType(BlockState state) {
    return BlockRenderType.MODEL;
  }

  @Override
  public boolean isTransparent(BlockState p_220074_1_) {
    return true;
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new WaterFabricatorTile();
  }

  @Override
  public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);

    tooltip.add(new StringTextComponent(""));
    tooltip.add(new TranslationTextComponent("mysticalpowers.water_fabricator.tooltip").setStyle(Style.EMPTY.setColor(Color.fromTextFormatting(TextFormatting.AQUA)).setBold(true)));
  }
}
