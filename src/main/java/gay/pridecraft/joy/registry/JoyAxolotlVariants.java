package gay.pridecraft.joy.registry;

import gay.pridecraft.joy.Joy;
import io.github.akashiikun.mavapi.v1.api.ModdedAxolotlVariant;
import net.minecraft.util.Identifier;

public class JoyAxolotlVariants {
	public static void registerAxolotlVariants() {
		Joy.LOGGER.info("Registering Axolotl Variants for {} via MoreAxolotlVariantsAPI", Joy.MOD_ID);

		register("bi");
		register("ace");
		register("aro");
		register("lesbian");
		register("mlm");
		register("progress");
		register("trans");
		register("aroace");
		register("pan");
	}

	private static void register(String name) {
		register(name, true);
	}

	private static void register(String name, boolean natural) {
		ModdedAxolotlVariant.Builder builder = ModdedAxolotlVariant.register(Identifier.of(Joy.MOD_ID, name));
		if (natural) {
			builder.natural();
		}
		builder.build();
	}
}
