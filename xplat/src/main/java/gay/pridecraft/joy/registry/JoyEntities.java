package gay.pridecraft.joy.registry;

import gay.pridecraft.joy.JoyUtil;
import gay.pridecraft.joy.Pivot;
import gay.pridecraft.joy.entity.CustomBeeEntity;
import gay.pridecraft.joy.entity.CustomFoxEntity;
import gay.pridecraft.joy.entity.CustomFrogEntity;
import gay.pridecraft.joy.entity.CustomSnifferEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;

public final class JoyEntities {
    public static final EntityType<CustomFoxEntity.SockFoxEntity> SOCK_FOX = register("sock_fox",
        EntityType.Builder.create(CustomFoxEntity.SockFoxEntity::new, EntityType.FOX.getSpawnGroup())
            .dimensions(0.6f, 0.7f)
            .maxTrackingRange(8)
    );

    public static final EntityType<CustomBeeEntity.BiiEntity> BII = register("bii",
        EntityType.Builder.create(CustomBeeEntity.BiiEntity::new, EntityType.BEE.getSpawnGroup())
            .dimensions(0.7f, 0.6f)
            .maxTrackingRange(8)
    );

    public static final EntityType<CustomBeeEntity.EnbeeEntity> ENBEE = register("enbee",
        EntityType.Builder.create(CustomBeeEntity.EnbeeEntity::new, EntityType.BEE.getSpawnGroup())
            .dimensions(0.7f, 0.6f)
            .maxTrackingRange(8)
    );

    public static final EntityType<CustomBeeEntity.TransBeeEntity> TRANS_BEE = register("trans_bee",
        EntityType.Builder.create(CustomBeeEntity.TransBeeEntity::new, EntityType.BEE.getSpawnGroup())
            .dimensions(0.7f, 0.6f)
            .maxTrackingRange(8)
    );

    public static final EntityType<CustomBeeEntity.TreeEntity> TREE = register("tree",
        EntityType.Builder.create(CustomBeeEntity.TreeEntity::new, EntityType.BEE.getSpawnGroup())
            .dimensions(0.7f, 0.6f)
            .maxTrackingRange(8)
    );

    public static final EntityType<CustomFrogEntity.FrogEntity> FROG = register("frog",
        EntityType.Builder.create(CustomFrogEntity.FrogEntity::new, EntityType.FROG.getSpawnGroup())
            .dimensions(0.5F, 0.5f)
            .maxTrackingRange(10)
    );


    public static final EntityType<CustomSnifferEntity.SnifferEntity> SNIFFER = register("sniffer",
        EntityType.Builder.create(CustomSnifferEntity.SnifferEntity::new, EntityType.SNIFFER.getSpawnGroup())
            .dimensions(1.9F, 1.75F)
            .maxTrackingRange(10)
    );

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder) {
        return Pivot.INSTANCE.register(RegistryKeys.ENTITY_TYPE, id, builder.build(JoyUtil.id + ':' + id));
    }

    public static void init() {

    }
}
