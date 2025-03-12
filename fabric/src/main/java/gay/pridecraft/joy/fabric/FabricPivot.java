package gay.pridecraft.joy.fabric;

import com.mojang.logging.LogUtils;
import gay.pridecraft.joy.JoyUtil;
import gay.pridecraft.joy.Pivot;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.loader.api.metadata.Person;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import org.slf4j.Logger;

import java.util.stream.Stream;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public class FabricPivot implements Pivot {
    private static final Logger logger = LogUtils.getLogger();

    @Override
    public <V, T extends V> T register(final RegistryKey<Registry<V>> key, final String id, final T t) {
        return Registry.register(Pivot.getRegistry(key), JoyUtil.id(id), t);
    }

    @Override
    public <T> RegistryEntry.Reference<T> registerReference(final RegistryKey<Registry<T>> key, final String id, final T t) {
        return Registry.registerReference(Pivot.getRegistry(key), JoyUtil.id(id), t);
    }

    @Override
    public ItemGroup.Builder createItemGroupBuilder() {
        return FabricItemGroup.builder();
    }

    @Override
    public SimpleParticleType createSimpleParticle() {
        return FabricParticleTypes.simple();
    }

    @Override
    public Stream<String> authors() {
        return FabricUtil.joyContainer.getMetadata().getAuthors().stream().map(Person::getName);
    }

    @Override
    public Stream<String> contributors() {
        return FabricUtil.joyContainer.getMetadata().getContributors().stream().map(Person::getName);
    }
}
