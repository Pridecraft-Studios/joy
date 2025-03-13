package gay.pridecraft.joy.registry;

import gay.pridecraft.joy.JoyUtil;
import gay.pridecraft.joy.mixin.minecraft.AccessorPoi;
import net.minecraft.block.BedBlock;
import net.minecraft.block.enums.BedPart;
import net.minecraft.world.poi.PointOfInterestTypes;

import java.util.stream.Collectors;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public final class JoyPoi {

    public static void init() {
        AccessorPoi.invokeRegisterStates(
            JoyUtil.getEntry(PointOfInterestTypes.HOME),
            JoyBlocks.BEDS.stream()
                .flatMap(JoyUtil::streamBlockStates)
                .filter(state -> state.get(BedBlock.PART) == BedPart.HEAD)
                .collect(Collectors.toSet())
        );
    }
}
