package noobanidus.mods.mysticalpowers.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import noobanidus.libs.noobutil.util.VoxelUtil;
import noobanidus.mods.mysticalpowers.capability.SettableEnergyStorage;
import noobanidus.mods.mysticalpowers.tiles.EndStoneFabricatorTile;

import javax.annotation.Nullable;
import java.util.Random;

@SuppressWarnings("deprecation")
public class EndStoneFabricatorBlock extends Block {
  public static VoxelShape SHAPE = VoxelUtil.multiOr(Block.makeCuboidShape(0, 0, 13, 16, 3, 16), Block.makeCuboidShape(0, 0, 0, 16, 3, 3), Block.makeCuboidShape(0, 13, 13, 16, 16, 16), Block.makeCuboidShape(0, 13, 0, 16, 16, 3), Block.makeCuboidShape(13, 0, 3, 16, 3, 13), Block.makeCuboidShape(0, 0, 3, 3, 3, 13), Block.makeCuboidShape(0, 13, 3, 3, 16, 13), Block.makeCuboidShape(13, 13, 3, 16, 16, 13), Block.makeCuboidShape(0, 3, 0, 3, 13, 3), Block.makeCuboidShape(0, 3, 13, 3, 13, 16), Block.makeCuboidShape(13, 3, 13, 16, 13, 16), Block.makeCuboidShape(13, 3, 0, 16, 13, 3), Block.makeCuboidShape(1, 3, 3, 1, 13, 13), Block.makeCuboidShape(15, 3, 3, 15, 13, 13), Block.makeCuboidShape(3, 3, 15, 13, 13, 15), Block.makeCuboidShape(3, 3, 1, 13, 13, 1), Block.makeCuboidShape(3, 15, 3, 13, 15, 13), Block.makeCuboidShape(3, 1, 3, 13, 1, 13), Block.makeCuboidShape(5, 4, 5, 11, 5, 11), Block.makeCuboidShape(11, 5, 5, 12, 11, 11), Block.makeCuboidShape(5, 5, 4, 11, 11, 5), Block.makeCuboidShape(4, 5, 5, 5, 11, 11), Block.makeCuboidShape(5, 11, 5, 11, 12, 11), Block.makeCuboidShape(5, 5, 11, 11, 11, 12));

  public EndStoneFabricatorBlock(Properties properties) {
    super(properties);
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new EndStoneFabricatorTile();
  }

  @Override
  public boolean isTransparent(BlockState p_220074_1_) {
    return true;
  }

  public static long lastSentMessage = 0;

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    TileEntity te = worldIn.getTileEntity(pos);
    if (te instanceof EndStoneFabricatorTile) {
      if (!worldIn.isRemote) {
        if (System.currentTimeMillis() - lastSentMessage > 10) {
          SettableEnergyStorage energy = ((EndStoneFabricatorTile) te).getEnergyStorage();
          int amount = ((EndStoneFabricatorTile) te).getAmount();
          player.sendMessage(new TranslationTextComponent("mysticalpowers.tile.end_stone_generator.contains", amount, energy.getEnergyStored(), energy.getMaxEnergyStored()));
          lastSentMessage = System.currentTimeMillis();
        }
      }
      return ActionResultType.SUCCESS;
    } else {
      return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
  }

  @Override
  @OnlyIn(Dist.CLIENT)
  public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
    if (!worldIn.isBlockPowered(pos)) {
      worldIn.addParticle(ParticleTypes.PORTAL, pos.getX() + 0.5 + (rand.nextDouble() - 0.5D), pos.getY() + 0.5 + (rand.nextDouble() - 0.5D), pos.getZ() + 0.5 + (rand.nextDouble() - 0.5D), (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D);
    }
  }

  @Override
  public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    return SHAPE;
  }
}
