package gay.pridecraft.joy;

import gay.pridecraft.joy.block.BlahajBlocks;
import gay.pridecraft.joy.block.ModBlocks;
import gay.pridecraft.joy.config.Config;
import gay.pridecraft.joy.entity.ModEntities;
import gay.pridecraft.joy.entity.spawn.SpawnModifier;
import gay.pridecraft.joy.item.ModItemGroups;
import gay.pridecraft.joy.item.ModItems;
import gay.pridecraft.joy.particle.ModParticles;
import gay.pridecraft.joy.sound.ModSoundEvents;
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
        ModParticles.registerParticles();
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        BlahajDataComponentTypes.register();
        BlahajBlocks.register();
        ModEntities.registerEntities();
        ModSoundEvents.registerModSoundEvents();

        // this is now has to be done in a mixin.
        // ModPaintings.registerPaintings();

        if (Config.mobSpawning) {
            SpawnModifier.modifySpawning();
        }
        // MidnightConfig.init(Joy.MOD_ID, Config.class);
        registerEntityAttributes();
    }

    private void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.SOCK_FOX, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3));

        FabricDefaultAttributeRegistry.register(ModEntities.BII, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0));

        FabricDefaultAttributeRegistry.register(ModEntities.ENBEE, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0));

        FabricDefaultAttributeRegistry.register(ModEntities.TRANS_BEE, MobEntity.createMobAttributes() //Tree == Trans Bee :moyai:
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0));

        FabricDefaultAttributeRegistry.register(ModEntities.TREE, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0));


        FabricDefaultAttributeRegistry.register(ModEntities.FROG, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0));

        FabricDefaultAttributeRegistry.register(ModEntities.SNIFFER, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1));
    }
}