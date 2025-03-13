package gay.pridecraft.joy.fabric;

import gay.pridecraft.joy.Pivot;
import gay.pridecraft.joy.config.Config;
import gay.pridecraft.joy.fabric.entity.SpawnModifier;
import gay.pridecraft.joy.registry.JoyAxolotlVariants;
import gay.pridecraft.joy.registry.JoyEntities;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.passive.SnifferEntity;

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
        FabricDefaultAttributeRegistry.register(JoyEntities.SOCK_FOX, FoxEntity.createFoxAttributes());

        FabricDefaultAttributeRegistry.register(JoyEntities.BII, BeeEntity.createBeeAttributes());
        FabricDefaultAttributeRegistry.register(JoyEntities.ENBEE, BeeEntity.createBeeAttributes());
        FabricDefaultAttributeRegistry.register(JoyEntities.TRANS_BEE, BeeEntity.createBeeAttributes());
        FabricDefaultAttributeRegistry.register(JoyEntities.TREE, BeeEntity.createBeeAttributes());

        FabricDefaultAttributeRegistry.register(JoyEntities.FROG, FrogEntity.createFrogAttributes());

        FabricDefaultAttributeRegistry.register(JoyEntities.SNIFFER, SnifferEntity.createSnifferAttributes());
    }
}
