package gay.pridecraft.joymod.particle;

import gay.pridecraft.joymod.JoyMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final DefaultParticleType TOTEM_OF_PRIDE_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(JoyMod.MOD_ID, "totem_of_pride_particle"),
                TOTEM_OF_PRIDE_PARTICLE);
    }
}