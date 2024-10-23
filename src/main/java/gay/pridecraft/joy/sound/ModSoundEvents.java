package gay.pridecraft.joy.sound;

import gay.pridecraft.joy.Joy;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
    public static final RegistryEntry.Reference<SoundEvent> DOUGLAS = registerReference("music_disc.douglas");
    public static final RegistryEntry.Reference<SoundEvent> MELANCOLIE = registerReference("music_disc.melancolie");

    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(Joy.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(String id) {
        Identifier identifier = Identifier.of(Joy.MOD_ID, id);
        return Registry.registerReference(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerModSoundEvents() {
        // Joy.LOGGER.info("Making the gay sounds from" + Joy.MOD_ID);
    }
}
