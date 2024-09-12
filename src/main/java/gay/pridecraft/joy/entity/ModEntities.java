package gay.pridecraft.joy.entity;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.entity.custom.CustomBedBlockEntity;
import gay.pridecraft.joy.block.ModBlocks;
import gay.pridecraft.joy.entity.custom.living.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final BlockEntityType<CustomBedBlockEntity> CUSTOM_BED_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(Joy.MOD_ID, "pride_blocks"),
            BlockEntityType.Builder.create(CustomBedBlockEntity::new,
                    ModBlocks.ACE_BED,
                    ModBlocks.AGENDER_BED,
                    ModBlocks.APLATONIC_BED,
                    ModBlocks.BISEXUAL_BED,
                    ModBlocks.ARO_BED,
                    ModBlocks.BIGENDER_BED,
                    ModBlocks.ENBY_BED,
                    ModBlocks.PAN_BED,
                    ModBlocks.MLM_BED,
                    ModBlocks.TRANS_BED,
                    ModBlocks.PROGRESS_BED,
                    ModBlocks.LESBIAN_BED,
                    ModBlocks.GENDER_FLUID_BED,
                    ModBlocks.GAY_BED,
                    ModBlocks.INTERSEX_BED,
                    ModBlocks.AROACE_BED
            ).build()
    );

    public static final EntityType<CustomFoxEntity.ThighHighFoxEntity> THIGH_HIGH_FOX = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(Joy.MOD_ID, "thigh_high_fox"),
        EntityType.Builder.create(CustomFoxEntity.ThighHighFoxEntity::new, EntityType.FOX.getSpawnGroup())
            .dimensions(0.6f, 0.7f)
            .maxTrackingRange(8)
            .build()
    );

    public static final EntityType<CustomBeeEntity.BiiEntity> BII = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(Joy.MOD_ID, "bii"),
        EntityType.Builder.create(CustomBeeEntity.BiiEntity::new, EntityType.BEE.getSpawnGroup())
            .dimensions(0.7f, 0.6f)
            .maxTrackingRange(8)
            .build()
    );

    public static final EntityType<CustomBeeEntity.EnbeeEntity> ENBEE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Joy.MOD_ID, "enbee"),
            EntityType.Builder.create(CustomBeeEntity.EnbeeEntity::new, EntityType.BEE.getSpawnGroup())
                    .dimensions(0.7f, 0.6f)
                    .maxTrackingRange(8)
                    .build()
    );

    public static final EntityType<CustomAxolotlEntity.PrideAxolotlEntity> PRIDE_AXOLOTL = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(Joy.MOD_ID, "pride_axolotl"),
        EntityType.Builder.create(CustomAxolotlEntity.PrideAxolotlEntity::new, EntityType.AXOLOTL.getSpawnGroup())
            .dimensions(0.75F, 0.42F)
            .maxTrackingRange(10)
            .build()
    );

    public static final EntityType<CustomFrogEntity.PrideFrogEntity> PRIDE_FROG = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(Joy.MOD_ID, "pride_frog"),
        EntityType.Builder.create(CustomFrogEntity.PrideFrogEntity::new, EntityType.FROG.getSpawnGroup())
            .dimensions(0.5F, 0.5f)
            .maxTrackingRange(10)
            .build()
    );

    public static final EntityType<CustomSlimeEntity.PrideSlimeEntity> PRIDE_SLIME = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(Joy.MOD_ID, "pride_slime"),
        EntityType.Builder.create(CustomSlimeEntity.PrideSlimeEntity::new, EntityType.SLIME.getSpawnGroup())
            .dimensions(0.5f, 0.5f)
            .maxTrackingRange(10)
            .build()
    );

    public static final EntityType<CustomSnifferEntity.PrideSnifferEntity> PRIDE_SNIFFER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(Joy.MOD_ID, "pride_sniffer"),
        EntityType.Builder.create(CustomSnifferEntity.PrideSnifferEntity::new, EntityType.SNIFFER.getSpawnGroup())
            .dimensions(1.9F, 1.75F)
            .maxTrackingRange(10)
            .build()
    );

    public static void registerBlockEntities() {
        Joy.LOGGER.info("Registering Entities for " + Joy.MOD_ID);
    }
}