package gay.pridecraft.joy.mixin.minecraft;

import net.minecraft.block.BlockState;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;
import java.util.Set;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
@Mixin(PointOfInterestTypes.class)
public interface AccessorPoi {
    @Accessor("POI_STATES_TO_TYPE")
    static Map<BlockState, RegistryEntry<PointOfInterestType>> getPoiStatesToType() {
        throw new AssertionError();
    }

    @Invoker
    static void invokeRegisterStates(RegistryEntry<PointOfInterestType> poi, Set<BlockState> states) {
        throw new AssertionError();
    }
}
