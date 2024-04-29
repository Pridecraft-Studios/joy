package gay.pridecraft.joymod.entity;

import gay.pridecraft.joymod.JoyMod;
import gay.pridecraft.joymod.entity.custom.CustomBedBlockEntity;
import gay.pridecraft.joymod.block.ModBlocks;
import gay.pridecraft.joymod.entity.custom.living.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final BlockEntityType<CustomBedBlockEntity> CUSTOM_BED_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(JoyMod.MOD_ID, "pride_blocks"),
            FabricBlockEntityTypeBuilder.create(CustomBedBlockEntity::new,
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
            new Identifier(JoyMod.MOD_ID, "thigh_high_fox"),
            FabricEntityTypeBuilder.create(EntityType.FOX.getSpawnGroup(), CustomFoxEntity.ThighHighFoxEntity::new).dimensions(EntityDimensions.fixed(0.6f, 0.7f)).build()
    );

    public static final EntityType<CustomBeeEntity.PrideBiiEntity> PRIDE_BII = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(JoyMod.MOD_ID, "pride_bii"),
            FabricEntityTypeBuilder.create(EntityType.BEE.getSpawnGroup(), CustomBeeEntity.PrideBiiEntity::new).dimensions(EntityDimensions.fixed(0.6f, 0.7f)).build()
    );

    public static final EntityType<CustomAxolotlEntity.PrideAxolotlEntity> PRIDE_AXOLOTL = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(JoyMod.MOD_ID, "pride_axolotl"),
            FabricEntityTypeBuilder.create(EntityType.AXOLOTL.getSpawnGroup(), CustomAxolotlEntity.PrideAxolotlEntity::new).dimensions(EntityDimensions.fixed(0.6f, 0.7f)).build()
    );

    public static final EntityType<CustomFrogEntity.PrideFrogEntity> PRIDE_FROG = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(JoyMod.MOD_ID, "pride_frog"),
            FabricEntityTypeBuilder.create(EntityType.FROG.getSpawnGroup(), CustomFrogEntity.PrideFrogEntity::new).dimensions(EntityDimensions.fixed(0.6f, 0.7f)).build()
    );

    public static final EntityType<CustomSlimeEntity.PrideSlimeEntity> PRIDE_SLIME = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(JoyMod.MOD_ID, "pride_slime"),
            FabricEntityTypeBuilder.create(EntityType.SLIME.getSpawnGroup(), CustomSlimeEntity.PrideSlimeEntity::new)
                    .dimensions(EntityDimensions.fixed(2.04F, 2.04F)).trackRangeBlocks(10).build()
    );

    public static final EntityType<CustomSnifferEntity.PrideSnifferEntity> PRIDE_SNIFFER = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(JoyMod.MOD_ID, "pride_sniffer"),
            FabricEntityTypeBuilder.create(EntityType.SNIFFER.getSpawnGroup(), CustomSnifferEntity.PrideSnifferEntity::new).dimensions(EntityDimensions.fixed(0.6f, 0.7f)).build()
    );

    public static void registerBlockEntities() {
        JoyMod.LOGGER.info("Registering Entities for " + JoyMod.MOD_ID);
    }
}