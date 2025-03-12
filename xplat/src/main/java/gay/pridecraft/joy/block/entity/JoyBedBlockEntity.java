package gay.pridecraft.joy.block.entity;

import gay.pridecraft.joy.registry.JoyBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;

public class JoyBedBlockEntity extends BlockEntity {
    public DyeColor color;

    public JoyBedBlockEntity(BlockPos pos, BlockState state) {
        super(JoyBlockEntityTypes.JOY_BED_BLOCK_ENTITY, pos, state);
        this.color = DyeColor.WHITE;
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }
}