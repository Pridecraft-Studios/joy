package gay.pridecraft.joy.util;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
record UnionVoxelEmitter(List<VoxelEmitter> emitters) implements VoxelEmitter {
    UnionVoxelEmitter(VoxelEmitter... emitters) {
        this(toBasic(Arrays.asList(emitters)));
    }

    UnionVoxelEmitter(Iterable<VoxelEmitter> emitters) {
        this(toBasic(emitters));
    }

    static List<VoxelEmitter> toBasic(Iterable<VoxelEmitter> emitters) {
        final var set = new HashSet<VoxelEmitter>();
        for (final var emitter : emitters) {
            if (emitter instanceof UnionVoxelEmitter union) {
                set.addAll(union.emitters());
            } else {
                set.add(emitter);
            }
        }
        return List.copyOf(set);
    }

    static VoxelShape union(Stream<VoxelShape> shapes) {
        final var list = shapes.toList();
        if (list.isEmpty()) {
            return VoxelShapes.empty();
        }
        final var init = list.get(0);
        if (list.size() == 1) {
            return init;
        }
        return VoxelShapes.union(init, list.subList(1, list.size()).toArray(VoxelShape[]::new));
    }

    private Stream<VoxelShape> stream(Function<VoxelEmitter, VoxelShape> map) {
        return emitters.stream().map(map);
    }

    public VoxelShape floorNorth() {
        return union(stream(VoxelEmitter::floorNorth));
    }

    public VoxelShape floorSouth() {
        return union(stream(VoxelEmitter::floorSouth));
    }

    public VoxelShape floorEast() {
        return union(stream(VoxelEmitter::floorEast));
    }

    public VoxelShape floorWest() {
        return union(stream(VoxelEmitter::floorWest));
    }

    public VoxelShape ceilingNorth() {
        return union(stream(VoxelEmitter::ceilingNorth));
    }

    public VoxelShape ceilingSouth() {
        return union(stream(VoxelEmitter::ceilingSouth));
    }

    public VoxelShape ceilingEast() {
        return union(stream(VoxelEmitter::ceilingEast));
    }

    public VoxelShape ceilingWest() {
        return union(stream(VoxelEmitter::ceilingWest));
    }

    public VoxelShape north() {
        return union(stream(VoxelEmitter::north));
    }

    public VoxelShape south() {
        return union(stream(VoxelEmitter::south));
    }

    public VoxelShape east() {
        return union(stream(VoxelEmitter::east));
    }

    public VoxelShape west() {
        return union(stream(VoxelEmitter::west));
    }
}
