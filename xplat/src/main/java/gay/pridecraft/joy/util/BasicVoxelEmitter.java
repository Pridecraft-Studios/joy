package gay.pridecraft.joy.util;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

/**
 * VoxelShape emitter that rotates as needed.
 *
 * @author Ampflower
 * @since 1.0.0
 **/
record BasicVoxelEmitter(
    double ax, double ay, double az,
    double bx, double by, double bz
) implements VoxelEmitter {

    BasicVoxelEmitter {
        if (ax > bx) {
            throw new IllegalArgumentException("x min > x max");
        }
        if (ay > by) {
            throw new IllegalArgumentException("y min > y max");
        }
        if (az > bz) {
            throw new IllegalArgumentException("z min > z max");
        }
    }

    /**
     * Identity of the emitter
     */
    public VoxelShape floorNorth() {
        return VoxelShapes.cuboid(ax, ay, az, bx, by, bz);
    }

    public VoxelShape floorSouth() {
        return VoxelShapes.cuboid(1 - bx, ay, 1 - bz, 1 - ax, by, 1 - az);
    }

    public VoxelShape floorEast() {
        return VoxelShapes.cuboid(1 - bz, ay, ax, 1 - az, by, bx);
    }

    public VoxelShape floorWest() {
        return VoxelShapes.cuboid(az, ay, 1 - bx, bz, by, 1 - ax);
    }

    public VoxelShape ceilingNorth() {
        return VoxelShapes.cuboid(ax, 1 - by, az, bx, 1 - ay, bz);
    }

    public VoxelShape ceilingSouth() {
        return VoxelShapes.cuboid(1 - bx, 1 - by, 1 - bz, 1 - ax, 1 - ay, 1 - az);
    }

    public VoxelShape ceilingEast() {
        return VoxelShapes.cuboid(1 - bz, 1 - by, ax, 1 - az, 1 - ay, bx);
    }

    public VoxelShape ceilingWest() {
        return VoxelShapes.cuboid(az, 1 - by, 1 - bx, bz, 1 - ay, 1 - ax);
    }

    public VoxelShape north() {
        return VoxelShapes.cuboid(ax, az, 1 - by, bx, bz, 1 - ay);
    }

    public VoxelShape south() {
        return VoxelShapes.cuboid(1 - bx, az, ay, 1 - ax, bz, by);
    }

    public VoxelShape east() {
        return VoxelShapes.cuboid(ay, az, ax, by, bz, bx);
    }

    public VoxelShape west() {
        return VoxelShapes.cuboid(1 - by, az, 1 - bx, 1 - ay, bz, 1 - ax);
    }
}
