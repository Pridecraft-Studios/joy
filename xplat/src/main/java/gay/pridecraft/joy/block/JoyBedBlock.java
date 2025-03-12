package gay.pridecraft.joy.block;

import gay.pridecraft.joy.block.entity.JoyBedBlockEntity;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;

public class JoyBedBlock extends BedBlock {
    public JoyBedBlock(Settings settings) {
        super(DyeColor.WHITE, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new JoyBedBlockEntity(pos, state);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }
}
