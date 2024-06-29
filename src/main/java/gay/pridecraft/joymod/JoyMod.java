package gay.pridecraft.joymod;

import eu.midnightdust.lib.config.MidnightConfig;
import gay.pridecraft.joymod.block.ModBlocks;
import gay.pridecraft.joymod.config.Config;
import gay.pridecraft.joymod.entity.ModEntities;
import gay.pridecraft.joymod.entity.spawn.SpawnModifier;
import gay.pridecraft.joymod.item.ModItemGroups;
import gay.pridecraft.joymod.item.ModItems;
import gay.pridecraft.joymod.particle.ModParticles;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class JoyMod implements ModInitializer {
    public static final String MOD_ID = "joymod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Identifier MUSIC_GAME = Identifier.of(MOD_ID, "music.ambient");
    public static SoundEvent MUSIC_GAME_EVENT = SoundEvent.of(MUSIC_GAME);
    private int tickCounter = 0;
    private final Random random = new Random();

    @Override
    public void onInitialize() {
        ModParticles.registerParticles();
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEntities.registerBlockEntities();

        // this is now has to be done in a mixin.
        // ModPaintings.registerPaintings();

        if (Config.mobSpawning) {
            SpawnModifier.modifySpawning();
        }

        MidnightConfig.init(JoyMod.MOD_ID, Config.class);

        Registry.register(Registries.SOUND_EVENT, MUSIC_GAME, MUSIC_GAME_EVENT);
        SoundInstance music = PositionedSoundInstance.music(MUSIC_GAME_EVENT);


        /*ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (!(client.currentScreen instanceof TitleScreen)) return;
            if (client.getSoundManager().isPlaying(music)) return;
            client.getSoundManager().play(music);
        });*/

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.world != null && !client.isPaused() && client.player != null) {
                tickCounter++;
                if (tickCounter >= getRandomInterval()) {
                    client.getSoundManager().play(music);
                    tickCounter = 0;
                }
            }
        });

        registerEntityAttributes();
    }

    private int getRandomInterval() {
        return 12000 + random.nextInt(24000);
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