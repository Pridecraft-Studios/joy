package gay.pridecraft.joy;

import net.minecraft.component.ComponentType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.text.TextCodecs;

import java.util.function.UnaryOperator;

public final class BlahajDataComponentTypes {
    public static final ComponentType<Text> OWNER = register(
        "owner",
        builder -> builder
            .codec(TextCodecs.STRINGIFIED_CODEC)
            .packetCodec(TextCodecs.REGISTRY_PACKET_CODEC)
            .cache()
    );

    private static <T> ComponentType<T> register(String id, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Pivot.INSTANCE.register(RegistryKeys.DATA_COMPONENT_TYPE, id, builderOperator.apply(ComponentType.builder()).build());
    }

    public static void init() {

    }
}
