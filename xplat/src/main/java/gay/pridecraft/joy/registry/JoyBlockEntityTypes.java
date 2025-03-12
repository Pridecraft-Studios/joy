package gay.pridecraft.joy.registry;

import gay.pridecraft.joy.Pivot;
import gay.pridecraft.joy.block.entity.JoyBedBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.RegistryKeys;

public final class JoyBlockEntityTypes {
    public static final BlockEntityType<JoyBedBlockEntity> JOY_BED_BLOCK_ENTITY = register("bed",
        JoyBedBlockEntity::new,
        JoyBlocks.ACE_BED,
        JoyBlocks.AGENDER_BED,
        JoyBlocks.APLATONIC_BED,
        JoyBlocks.BISEXUAL_BED,
        JoyBlocks.ARO_BED,
        JoyBlocks.BIGENDER_BED,
        JoyBlocks.ENBY_BED,
        JoyBlocks.PAN_BED,
        JoyBlocks.MLM_BED,
        JoyBlocks.TRANS_BED,
        JoyBlocks.PROGRESS_BED,
        JoyBlocks.LESBIAN_BED,
        JoyBlocks.GENDER_FLUID_BED,
        JoyBlocks.GAY_BED,
        JoyBlocks.INTERSEX_BED,
        JoyBlocks.AROACE_BED
    );

    private static <T extends BlockEntity> BlockEntityType<T> register(
        String id, BlockEntityType.BlockEntityFactory<T> factory, Block... blocks) {
        return Pivot.INSTANCE.register(RegistryKeys.BLOCK_ENTITY_TYPE, id,
            BlockEntityType.Builder.create(factory, blocks).build(null));
    }

    /**
     * Workaround to force classloading
     */
    public static void init() {
        // NO-OP
    }
}
