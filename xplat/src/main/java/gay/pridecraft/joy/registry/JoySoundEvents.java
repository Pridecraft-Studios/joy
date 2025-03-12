package gay.pridecraft.joy.registry;

import gay.pridecraft.joy.JoyUtil;
import gay.pridecraft.joy.Pivot;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public final class JoySoundEvents {
    public static final RegistryEntry.Reference<SoundEvent> DOUGLAS = registerReference("music_disc.douglas");

    public static final RegistryEntry.Reference<SoundEvent> MELANCOLIE = registerReference("music_disc.melancolie");

    private static SoundEvent registerSound(String id) {
        Identifier identifier = JoyUtil.id(id);
        return Pivot.INSTANCE.register(RegistryKeys.SOUND_EVENT, id, SoundEvent.of(identifier));
    }

    private static RegistryEntry.Reference<SoundEvent> registerReference(String id) {
        Identifier identifier = JoyUtil.id(id);
        return Pivot.INSTANCE.registerReference(RegistryKeys.SOUND_EVENT, id, SoundEvent.of(identifier));
    }

    /**
     * Workaround to force classloading
     */
    public static void init() {
        // NO-OP
    }
}
