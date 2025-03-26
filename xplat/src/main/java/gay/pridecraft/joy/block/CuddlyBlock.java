package gay.pridecraft.joy.block;

import com.mojang.serialization.MapCodec;
import gay.pridecraft.joy.util.VoxelEmitter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.Map;

public class CuddlyBlock extends HorizontalFacingBlock {

    public static final Map<Direction, VoxelShape>
        SHARK_SHAPES = VoxelEmitter.union(
        // BASE
        VoxelEmitter.ofBlock(
            8 - 2, 0, 1,
            8 + 2, 4, 9
        ),
        // FACE
        VoxelEmitter.ofBlock(
            8 - 2, 1, 0,
            8 + 2, 4, 1
        ),
        // MID
        VoxelEmitter.ofBlock(
            8 - 1.5, 0.5, 9,
            8 + 1.5, 3.5, 11
        ),
        // FIN_RIGHT
        VoxelEmitter.ofBlock(
            8 - 3, -1.5, 5.5,
            8 - 2, 1, 9.5
        ),
        // FIN_LEFT
        VoxelEmitter.ofBlock(
            8 + 2, -1.5, 5.5,
            8 + 3, 1, 9.5
        ),
        // FIN_BACK
        VoxelEmitter.ofBlock(
            8 - 1, 4, 5.5,
            8 + 1, 7, 8.5
        ),
        // TAIL
        VoxelEmitter.ofBlock(
            8 - 1, 1, 11,
            8 + 1, 3, 16
        ),
        // TAIL_DETAIL
        VoxelEmitter.ofBlock(
            8 - .5, 3, 12,
            8 + .5, 3.5, 13
        ),
        // TAIL_FIN
        VoxelEmitter.ofBlock(
            8 - .5, -.5, 14.5,
            8 + .5, 5.5, 17
        )
    ).toFloorMap(FACING),

    WHALE_SHAPES = VoxelEmitter.union(
        // BASE
        VoxelEmitter.ofBlock(
            8 - 3, 0, 0,
            8 + 3, 4, 8
        ),
        // MID
        VoxelEmitter.ofBlock(
            8 - 2, 0.5, 8,
            8 + 2, 3.5, 11
        ),
        // FIN_RIGHT
        VoxelEmitter.ofBlock(
            8 - 6.5, 1, 3.5,
            8 - 3, 2, 6
        ),
        // FIN_LEFT
        VoxelEmitter.ofBlock(
            8 + 3, 1, 3.5,
            8 + 6.5, 2, 6
        ),
        // FIN_BACK
        VoxelEmitter.ofBlock(
            8 - .5, 4, 5.5,
            8 + .5, 6.5, 8
        ),
        // TAIL
        VoxelEmitter.ofBlock(
            8 - 1.5, 1, 11,
            8 + 1.5, 3, 14
        ),
        // TAIL_FIN
        VoxelEmitter.ofBlock(
            8 - 4, 1, 14,
            8 + 4, 3, 16
        )
    ).toFloorMap(FACING),

    BREAD_SHAPES = VoxelEmitter.ofBlock(
        8 - 3, 0, -1,
        8 + 3, 6, 16
    ).toFloorMap(FACING),

    BEAR_SHAPES = VoxelEmitter.union(
        // BODY
        VoxelEmitter.ofBlock(
            8 - 6, 0, 4,
            8 + 6, 10, 15
        ),
        // HEAD
        VoxelEmitter.ofBlock(
            8 - 4, 10, 7,
            8 + 4, 16, 14
        ),
        // SNOUT
        VoxelEmitter.ofBlock(
            8 - 2, 10.5, 5,
            8 + 2, 13.5, 7
        )
    ).toFloorMap(FACING);

    private static final MapCodec<CuddlyBlock> CODEC = createCodec(CuddlyBlock::new);

    private final Map<Direction, VoxelShape> shapes;

    public CuddlyBlock(Settings settings, Map<Direction, VoxelShape> shapes) {
        super(settings);
        this.shapes = shapes;
        this.setDefaultState(this.getStateManager().getDefaultState()
            .with(FACING, Direction.NORTH));
    }

    public CuddlyBlock(Settings settings) {
        this(settings, SHARK_SHAPES);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shapes.get(state.get(FACING));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
            .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
