package gay.pridecraft.joymod;

import gay.pridecraft.joymod.entity.ModEntities;
import gay.pridecraft.joymod.block.ModBlocks;
import gay.pridecraft.joymod.item.ModItemGroups;
import gay.pridecraft.joymod.item.ModItems;
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
        // LOGGER.info("Thanks for using JoyMod! Gaying your minecraft...");
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEntities.registerBlockEntities();

        FabricDefaultAttributeRegistry.register(ModEntities.THIGH_HIGH_FOX, MobEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.PRIDE_BII, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0).add(EntityAttributes.GENERIC_FLYING_SPEED, 0.23F));
        FabricDefaultAttributeRegistry.register(ModEntities.PRIDE_AXOLOTL, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0));
        FabricDefaultAttributeRegistry.register(ModEntities.PRIDE_FROG, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0));
        FabricDefaultAttributeRegistry.register(ModEntities.PRIDE_SLIME, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0D));

        FabricDefaultAttributeRegistry.register(ModEntities.PRIDE_SNIFFER, MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0));
    }
}