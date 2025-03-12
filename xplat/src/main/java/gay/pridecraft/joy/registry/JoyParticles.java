package gay.pridecraft.joy.registry;

import gay.pridecraft.joy.Pivot;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.RegistryKeys;

public final class JoyParticles {
    public static final SimpleParticleType TOTEM_OF_PRIDE_PARTICLE =
        register("totem_of_pride_particle", Pivot.simpleParticle());

    private static <T extends ParticleType<?>> T register(String id, T t) {
        return Pivot.INSTANCE.register(RegistryKeys.PARTICLE_TYPE, id, t);
    }

    public static void init() {
    }
}
