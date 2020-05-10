package noobanidus.mods.mysticalpowers.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import noobanidus.mods.mysticalpowers.capability.SettableEnergyStorage;
import noobanidus.mods.mysticalpowers.tiles.FabricatorTile;

import javax.annotation.Nullable;
import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class FabricatorBlock extends Block {
  private final Supplier<? extends IItemProvider> block;
  private final int MAX_FE;
  private final int MAX_FE_TRANSFER;
  private final int FE_OPERATION;
  private final int FREQUENCY;

  public FabricatorBlock(Properties properties, Supplier<? extends IItemProvider> block, int ... values) {
    super(properties);
    this.block = block;
    if (values.length != 4) {
      throw new IllegalArgumentException("Required 4 integer values for FabricatorBlock, got " + values.length);
    }
    this.MAX_FE = values[0];
    this.MAX_FE_TRANSFER = values[1];
    this.FE_OPERATION = values[2];
    this.FREQUENCY = values[3];
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return new FabricatorTile(block, MAX_FE, MAX_FE_TRANSFER, FE_OPERATION, FREQUENCY);
  }

  @Override
  public BlockRenderLayer getRenderLayer() {
    return BlockRenderLayer.CUTOUT;
  }

  public static long lastSentMessage = 0;

  @Override
  public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    TileEntity te = worldIn.getTileEntity(pos);
    if (te instanceof FabricatorTile) {
      if (!worldIn.isRemote) {
        if (System.currentTimeMillis() - lastSentMessage > 10) {
          SettableEnergyStorage energy = ((FabricatorTile) te).getEnergyStorage();
          ItemStack type = ((FabricatorTile) te).getItemType();
          int amount = ((FabricatorTile) te).getAmount();
          player.sendMessage(new TranslationTextComponent("mysticalpowers.tile.block_generator.contains", amount, type.getDisplayName(), energy.getEnergyStored(), energy.getMaxEnergyStored()));
          lastSentMessage = System.currentTimeMillis();
        }
      }
      return true;
    } else {
      return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
  }
}
