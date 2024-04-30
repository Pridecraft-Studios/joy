package gay.pridecraft.joymod;

import eu.midnightdust.lib.config.MidnightConfig;
import gay.pridecraft.joymod.config.Config;
import gay.pridecraft.joymod.entity.ModEntities;
import gay.pridecraft.joymod.block.ModBlocks;
import gay.pridecraft.joymod.entity.spawn.SpawnModifier;
import gay.pridecraft.joymod.item.ModItemGroups;
import gay.pridecraft.joymod.item.ModItems;
import gay.pridecraft.joymod.painting.ModPaintings;
import gay.pridecraft.joymod.particle.ModParticles;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoyMod implements ModInitializer {
    public static final String MOD_ID = "joymod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModParticles.registerParticles();
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEntities.registerBlockEntities();
        ModPaintings.registerPaintings();

        if (Config.mobSpawning) {
            SpawnModifier.modifySpawning();
        }

        MidnightConfig.init(JoyMod.MOD_ID, Config.class);

        registerEntityAttributes();
    }

    private void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.THIGH_HIGH_FOX, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3));

        FabricDefaultAttributeRegistry.register(ModEntities.PRIDE_BII, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0));

        FabricDefaultAttributeRegistry.register(ModEntities.PRIDE_AXOLOTL, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0));

        FabricDefaultAttributeRegistry.register(ModEntities.PRIDE_FROG, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0));

        FabricDefaultAttributeRegistry.register(ModEntities.PRIDE_SLIME, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3));

        FabricDefaultAttributeRegistry.register(ModEntities.PRIDE_SNIFFER, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1));
    }
}