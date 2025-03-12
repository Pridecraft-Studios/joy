package gay.pridecraft.joy.fabric;

import gay.pridecraft.joy.Pivot;
import gay.pridecraft.joy.config.Config;
import gay.pridecraft.joy.fabric.entity.SpawnModifier;
import gay.pridecraft.joy.registry.JoyAxolotlVariants;
import gay.pridecraft.joy.registry.JoyEntities;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;

public class Joy implements ModInitializer {
    public static final String MOD_ID = "joy";

    @Override
    public void onInitialize() {
        Pivot.init();
        JoyAxolotlVariants.init();

        if (Config.mobSpawning) SpawnModifier.modifySpawning();

        // MidnightConfig.init(Joy.MOD_ID, Config.class);
        registerEntityAttributes();
    }

    private void registerEntityAttributes() {
        // TODO: move to common
        FabricDefaultAttributeRegistry.register(JoyEntities.SOCK_FOX, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3));

        FabricDefaultAttributeRegistry.register(JoyEntities.BII, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0));

        FabricDefaultAttributeRegistry.register(JoyEntities.ENBEE, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0));

        //Tree == Trans Bee :moyai:
        FabricDefaultAttributeRegistry.register(JoyEntities.TRANS_BEE, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0));

        FabricDefaultAttributeRegistry.register(JoyEntities.TREE, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0));


        FabricDefaultAttributeRegistry.register(JoyEntities.FROG, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0));

        FabricDefaultAttributeRegistry.register(JoyEntities.SNIFFER, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1));
    }
}
