package gay.pridecraft.joy.registry;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.entity.CustomBeeEntity;
import gay.pridecraft.joy.entity.CustomFoxEntity;
import gay.pridecraft.joy.entity.CustomFrogEntity;
import gay.pridecraft.joy.entity.CustomSnifferEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JoyEntities {
    public static final EntityType<CustomFoxEntity.SockFoxEntity> SOCK_FOX = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(Joy.MOD_ID, "sock_fox"),
        EntityType.Builder.create(CustomFoxEntity.SockFoxEntity::new, EntityType.FOX.getSpawnGroup())
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

    public static final EntityType<CustomBeeEntity.TransBeeEntity> TRANS_BEE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Joy.MOD_ID, "trans_bee"),
            EntityType.Builder.create(CustomBeeEntity.TransBeeEntity::new, EntityType.BEE.getSpawnGroup())
                    .dimensions(0.7f, 0.6f)
                    .maxTrackingRange(8)
                    .build()
    );

    public static final EntityType<CustomBeeEntity.TreeEntity> TREE = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Joy.MOD_ID, "tree"),
            EntityType.Builder.create(CustomBeeEntity.TreeEntity::new, EntityType.BEE.getSpawnGroup())
                    .dimensions(0.7f, 0.6f)
                    .maxTrackingRange(8)
                    .build()
    );

    public static final EntityType<CustomFrogEntity.FrogEntity> FROG = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(Joy.MOD_ID, "frog"),
        EntityType.Builder.create(CustomFrogEntity.FrogEntity::new, EntityType.FROG.getSpawnGroup())
            .dimensions(0.5F, 0.5f)
            .maxTrackingRange(10)
            .build()
    );


    public static final EntityType<CustomSnifferEntity.SnifferEntity> SNIFFER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(Joy.MOD_ID, "sniffer"),
        EntityType.Builder.create(CustomSnifferEntity.SnifferEntity::new, EntityType.SNIFFER.getSpawnGroup())
            .dimensions(1.9F, 1.75F)
            .maxTrackingRange(10)
            .build()
    );

    public static void init() {
        JoyAxolotlVariants.registerAxolotlVariants();
    }
}