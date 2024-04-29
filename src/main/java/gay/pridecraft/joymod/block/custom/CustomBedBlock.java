package gay.pridecraft.joymod.block.custom;

import gay.pridecraft.joymod.entity.custom.CustomBedBlockEntity;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;

public class CustomBedBlock extends BedBlock {
    public CustomBedBlock(DyeColor color, Settings settings) {
        super(color, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CustomBedBlockEntity(pos, state);
    }
}
