package gay.pridecraft.joy.item;

import gay.pridecraft.joy.misc.ParticleEmitter;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public class ParticleEmittingItem extends Item implements ParticleEmitter {
    private final ParticleEffect effect;

    public ParticleEmittingItem(final Settings settings, final ParticleEffect effect) {
        super(settings);
        this.effect = effect;
    }

    @Override
    public ParticleEffect joy$getEffect() {
        return effect;
    }
}
