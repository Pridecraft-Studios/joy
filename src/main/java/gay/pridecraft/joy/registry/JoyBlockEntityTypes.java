package gay.pridecraft.joy.registry;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.block.entity.JoyBedBlockEntity;
import net.minecraft.block.entity.BedBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class JoyBlockEntityTypes {
    public static final BlockEntityType<JoyBedBlockEntity> JOY_BED_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(Joy.MOD_ID, "bed"),
            BlockEntityType.Builder.create(JoyBedBlockEntity::new,
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
            ).build()
    );

    /**
     * Workaround to force classloading
     */
    public static void init() {
        // NO-OP
    }
}
