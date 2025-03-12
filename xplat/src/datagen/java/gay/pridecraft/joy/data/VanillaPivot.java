package gay.pridecraft.joy.data;

import com.mojang.logging.LogUtils;
import gay.pridecraft.joy.JoyUtil;
import gay.pridecraft.joy.Pivot;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
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
public class VanillaPivot implements Pivot {
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
        logger.error("Stray call to VanillaPivot#createItemGroupBuilder(), providing dummy.", new Throwable());
        return ItemGroup.create(null, -1);
    }

    @Override
    public SimpleParticleType createSimpleParticle() {
        return FabricParticleTypes.simple();
    }

    @Override
    public Stream<String> authors() {
        return Stream.empty();
    }

    @Override
    public Stream<String> contributors() {
        return Stream.empty();
    }
}
