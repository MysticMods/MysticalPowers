package noobanidus.mods.mysticalpowers.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import noobanidus.mods.mysticalpowers.MPTags;
import noobanidus.mods.mysticalpowers.init.ModSounds;
import noobanidus.mods.mysticalpowers.tiles.CookieGeneratorTile;

import javax.annotation.Nullable;

@SuppressWarnings({"deprecation", "NullableProblems"})
public class CookieGeneratorBlock extends Block {
  private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
  private static final VoxelShape NORTH = Block.makeCuboidShape(0, 0, 2, 16, 16, 16);
  private static final VoxelShape SOUTH = Block.makeCuboidShape(0, 0, 0, 16, 16, 14);
  private static final VoxelShape EAST = Block.makeCuboidShape(0, 0, 0, 14, 16, 16);
  private static final VoxelShape WEST = Block.makeCuboidShape(2, 0, 0, 16, 16, 16);

  public CookieGeneratorBlock(Properties properties) {
    super(properties);
    this.setDefaultState(this.getStateContainer().getBaseState().with(FACING, Direction.NORTH));
  }

  @Override
  public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    switch (state.get(FACING)) {
      case NORTH:
        return NORTH;
      case EAST:
        return EAST;
      case SOUTH:
        return SOUTH;
      case WEST:
        return WEST;
    }
    return super.getShape(state, worldIn, pos, context);
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
  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new CookieGeneratorTile();
  }

  public static long lastSentMessage = 0;

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    TileEntity te = worldIn.getTileEntity(pos);
    if (te != null) {
      te.getCapability(CapabilityEnergy.ENERGY).ifPresent((energy) -> {
        if (!worldIn.isRemote) {
          if (System.currentTimeMillis() - lastSentMessage > 10) {
            player.sendMessage(new TranslationTextComponent("mysticalpowers.tile.cookie_generator.contains", energy.getEnergyStored(), energy.getMaxEnergyStored()));
            lastSentMessage = System.currentTimeMillis();
          }
        }
      });
      return ActionResultType.SUCCESS;
    } else {
      return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
  }

  @Override
  public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
    if (worldIn.isRemote()) return;

    if (!(entityIn instanceof ItemEntity)) return;

    ItemStack itemstack = ((ItemEntity) entityIn).getItem();
    Item item = itemstack.getItem();
    if (MPTags.Items.GENERATOR_COOKIES.contains(item) || itemstack.hasDisplayName() && itemstack.getDisplayName().getString().toLowerCase().contains("cookie")) {
      TileEntity te = worldIn.getTileEntity(pos);
      if (te instanceof CookieGeneratorTile) {
        for (int i = 0; i < itemstack.getCount(); i++) {
          ((CookieGeneratorTile) te).acceptCookie();
        }
        worldIn.playSound(null, pos, ModSounds.COOKIE_MUNCH.get(), SoundCategory.BLOCKS, 0.1f, 0.9f);
        entityIn.remove();
      }
    }
  }
}
