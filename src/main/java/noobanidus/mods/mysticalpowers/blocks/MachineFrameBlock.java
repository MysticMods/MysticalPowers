package noobanidus.mods.mysticalpowers.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;

public class MachineFrameBlock extends Block {
  private MachineFrame type;

  public MachineFrameBlock(Properties properties, MachineFrame type) {
    super(properties);
  }

  public MachineFrame getType() {
    return type;
  }

  @Override
  public BlockRenderType getRenderType(BlockState state) {
    return BlockRenderType.MODEL;
  }

  // TODO
/*  @Override
  public BlockRenderLayer getRenderLayer() {
    return BlockRenderLayer.CUTOUT;
  }*/
}
