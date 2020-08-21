/*package noobanidus.mods.mysticalpowers.blocks;

import epicsquid.mysticallib.util.VoxelUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import noobanidus.mods.mysticalpowers.tiles.StoredHeatGeneratorTile;

import javax.annotation.Nullable;
import java.util.List;

public class StoredHeatGeneratorBlock extends Block {
  public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
  public static final BooleanProperty HEATED = BooleanProperty.create("heated");
  public static final BooleanProperty POWERED = BooleanProperty.create("powered");

  public static final VoxelShape SHAPE = VoxelUtil.multiOr(Block.makeCuboidShape(0, 0, 0,16, 8, 16), Block.makeCuboidShape(3, 8, 3,13, 13, 13), Block.makeCuboidShape(11, 8, 1,12, 10, 2), Block.makeCuboidShape(14, 8, 4,15, 10, 5), Block.makeCuboidShape(14, 8, 11,15, 10, 12), Block.makeCuboidShape(4, 8, 1,5, 10, 2),  Block.makeCuboidShape(1, 8, 4,2, 10, 5), Block.makeCuboidShape(1, 8, 11,2, 10, 12), Block.makeCuboidShape(4, 8, 14,5, 10, 15), Block.makeCuboidShape(11, 8, 14,12, 10, 15), Block.makeCuboidShape(1, 10, 11,3, 11, 12), Block.makeCuboidShape(4, 10, 13,5, 11, 15), Block.makeCuboidShape(4, 10, 1,5, 11, 3), Block.makeCuboidShape(11, 10, 13,12, 11, 15), Block.makeCuboidShape(11, 10, 1,12, 11, 3), Block.makeCuboidShape(1, 10, 4,3, 11, 5), Block.makeCuboidShape(13, 10, 4,15, 11, 5), Block.makeCuboidShape(13, 10, 11,15, 11, 12), Block.makeCuboidShape(7, 13, 7,9, 14, 9), Block.makeCuboidShape(5, 15, 5,11, 16, 11), Block.makeCuboidShape(6, 14, 6,10, 15, 10));

  public StoredHeatGeneratorBlock(Properties properties) {
    super(properties);
    this.setDefaultState(this.getStateContainer().getBaseState().with(FACING, Direction.NORTH).with(HEATED, false).with(POWERED, false));
  }

  @Override
  public BlockState getStateForPlacement(BlockItemUseContext context) {
    return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
  }

  @Override
  public BlockRenderType getRenderType(BlockState state) {
    return BlockRenderType.MODEL;
  }

  @Override
  public BlockState rotate(BlockState state, Rotation rot) {
    return state.with(FACING, rot.rotate(state.get(FACING)));
  }

  @Override
  public BlockState mirror(BlockState state, Mirror mirrorIn) {
    return state.rotate(mirrorIn.toRotation(state.get(FACING)));
  }

  @Override
  public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    return SHAPE;
  }

  @Override
  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(FACING, HEATED, POWERED);
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new StoredHeatGeneratorTile();
  }

  @OnlyIn(Dist.CLIENT)
  @Override
  public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
    tooltip.add(new StringTextComponent(""));
    tooltip.add(new StringTextComponent("DOES NOTHING RIGHT NOW").setStyle(new Style().setColor(TextFormatting.RED).setBold(true)));
  }
}*/
