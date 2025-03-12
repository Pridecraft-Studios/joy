package gay.pridecraft.joy;

import gay.pridecraft.joy.block.BlahajBlocks;
import gay.pridecraft.joy.item.JoyItemGroups;
import gay.pridecraft.joy.registry.JoyBlockEntityTypes;
import gay.pridecraft.joy.registry.JoyBlocks;
import gay.pridecraft.joy.registry.JoyEntities;
import gay.pridecraft.joy.registry.JoyItems;
import gay.pridecraft.joy.registry.JoyParticles;
import gay.pridecraft.joy.registry.JoySoundEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ServiceLoader;


/**
 * @author Ampflower
 * @since 1.0.0
 **/
public interface Pivot {
    Pivot INSTANCE = ServiceLoader.load(Pivot.class).findFirst().orElseThrow();

    <V, T extends V> T register(RegistryKey<Registry<V>> key, String id, T t);

    <T> RegistryEntry.Reference<T> registerReference(RegistryKey<Registry<T>> key, String id, T t);

    ItemGroup.Builder createItemGroupBuilder();

    static ItemGroup.Builder itemGroupBuilder() {
        return INSTANCE.createItemGroupBuilder();
    }

    SimpleParticleType createSimpleParticle();

    static SimpleParticleType simpleParticle() {
        return INSTANCE.createSimpleParticle();
    }

    @SuppressWarnings("unchecked")
    static <V> Registry<V> getRegistry(RegistryKey<Registry<V>> key) {
        return (Registry<V>) Registries.REGISTRIES.getOrEmpty(key.getValue()).orElseThrow();
    }

    static void init() {
        JoyBlockEntityTypes.init();
        JoyBlocks.init();
        JoyEntities.init();
        JoyItems.init();
        JoyParticles.init();
        JoySoundEvents.init();
        BlahajDataComponentTypes.init();
        BlahajBlocks.init();
        JoyItemGroups.init();
    }
}
