package gay.pridecraft.joy.particle;

import gay.pridecraft.joy.Joy;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType TOTEM_OF_PRIDE_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Joy.MOD_ID, "totem_of_pride_particle"),
                TOTEM_OF_PRIDE_PARTICLE);
    }
}