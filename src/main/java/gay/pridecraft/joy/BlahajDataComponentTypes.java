package gay.pridecraft.joy;

import net.minecraft.component.*;
import net.minecraft.registry.*;
import net.minecraft.text.*;
import net.minecraft.util.*;

import java.util.function.*;

public class BlahajDataComponentTypes {

	public static final ComponentType<Text> OWNER = register("owner", (builder) -> builder.codec(TextCodecs.STRINGIFIED_CODEC).packetCodec(TextCodecs.REGISTRY_PACKET_CODEC).cache());

	private static <T> ComponentType<T> register(String id, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
		return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Blahaj.MOD_ID, id), builderOperator.apply(ComponentType.builder()).build());
	}

	public static void register() {

	}

}
