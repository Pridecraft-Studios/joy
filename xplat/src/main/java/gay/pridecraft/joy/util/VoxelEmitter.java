package gay.pridecraft.joy.util;

import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

import java.util.EnumMap;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public sealed interface VoxelEmitter permits BasicVoxelEmitter, UnionVoxelEmitter {
    double BLOCK = 16;

    /**
     * Expected: Floor north box in 1x1x1 bound
     */
    static VoxelEmitter of(final double ax, final double ay, final double az,
                           final double bx, final double by, final double bz) {
        return new BasicVoxelEmitter(ax, ay, az, bx, by, bz);
    }

    /**
     * Expected: Floor north box in 16x16x16 bound
     */
    static VoxelEmitter ofBlock(final double ax, final double ay, final double az,
                                final double bx, final double by, final double bz) {
        return new BasicVoxelEmitter(
            ax / BLOCK, ay / BLOCK, az / BLOCK,
            bx / BLOCK, by / BLOCK, bz / BLOCK
        );
    }

    static VoxelEmitter union(VoxelEmitter... emitters) {
        if (emitters.length == 1) {
            return emitters[0];
        }

        return new UnionVoxelEmitter(emitters);
    }

    static VoxelEmitter union(Iterable<VoxelEmitter> emitters) {
        return new UnionVoxelEmitter(emitters);
    }

    VoxelShape floorNorth();

    VoxelShape floorSouth();

    VoxelShape floorEast();

    VoxelShape floorWest();

    VoxelShape ceilingNorth();

    VoxelShape ceilingSouth();

    VoxelShape ceilingEast();

    VoxelShape ceilingWest();

    VoxelShape north();

    VoxelShape south();

    VoxelShape east();

    VoxelShape west();

    default EnumMap<Direction, VoxelShape> toWallMap(Direction... directions) {
        final var ret = new EnumMap<Direction, VoxelShape>(Direction.class);
        for (final Direction direction : directions) {
            ret.put(direction, ofWall(direction));
        }
        return ret;
    }


    default EnumMap<Direction, VoxelShape> toFloorMap(Direction... directions) {
        final var ret = new EnumMap<Direction, VoxelShape>(Direction.class);
        for (final Direction direction : directions) {
            ret.put(direction, ofFloor(direction));
        }
        return ret;
    }

    default EnumMap<Direction, VoxelShape> toCeilingMap(Direction... directions) {
        final var ret = new EnumMap<Direction, VoxelShape>(Direction.class);
        for (final Direction direction : directions) {
            ret.put(direction, ofCeiling(direction));
        }
        return ret;
    }

    default EnumMap<Direction, VoxelShape> toWallMap(DirectionProperty property) {
        return toWallMap(property.getValues().toArray(Direction[]::new));
    }

    default EnumMap<Direction, VoxelShape> toFloorMap(DirectionProperty property) {
        return toFloorMap(property.getValues().toArray(Direction[]::new));
    }

    default EnumMap<Direction, VoxelShape> toCeilingMap(DirectionProperty property) {
        return toCeilingMap(property.getValues().toArray(Direction[]::new));
    }

    default VoxelShape ofWall(Direction direction) {
        return switch (direction) {
            case DOWN -> floorNorth();
            case UP -> ceilingNorth();
            case NORTH -> north();
            case SOUTH -> south();
            case WEST -> west();
            case EAST -> east();
        };
    }

    default VoxelShape ofFloor(Direction direction) {
        return switch (direction) {
            case UP -> ceilingNorth();
            case DOWN, NORTH -> floorNorth();
            case SOUTH -> floorSouth();
            case WEST -> floorWest();
            case EAST -> floorEast();
        };
    }

    default VoxelShape ofCeiling(Direction direction) {
        return switch (direction) {
            case DOWN -> floorNorth();
            case UP, NORTH -> ceilingNorth();
            case SOUTH -> ceilingSouth();
            case WEST -> ceilingWest();
            case EAST -> ceilingEast();
        };
    }
}
