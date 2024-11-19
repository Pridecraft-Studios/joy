package gay.pridecraft.joy;

import gay.pridecraft.joy.block.BlahajBlocks;
import gay.pridecraft.joy.registry.*;
import gay.pridecraft.joy.config.Config;
import gay.pridecraft.joy.entity.SpawnModifier;
import gay.pridecraft.joy.item.ModItemGroups;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Joy implements ModInitializer {
    public static final String MOD_ID = "joy";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        JoyParticles.registerParticles();
        ModItemGroups.registerItemGroups();
        JoyItems.init();

        JoyBlocks.init();
        JoyBlockEntityTypes.init();

        BlahajDataComponentTypes.init();
        BlahajBlocks.register();
        JoyEntities.init();
        JoySoundEvents.init();

        // this is now has to be done in a mixin.
        // ModPaintings.registerPaintings();

        if (Config.mobSpawning) SpawnModifier.modifySpawning();

        // MidnightConfig.init(Joy.MOD_ID, Config.class);
        registerEntityAttributes();
    }

    private void registerEntityAttributes() {
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