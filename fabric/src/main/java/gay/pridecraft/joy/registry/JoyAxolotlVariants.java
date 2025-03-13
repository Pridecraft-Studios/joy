package gay.pridecraft.joy.registry;

import com.mojang.logging.LogUtils;
import gay.pridecraft.joy.JoyUtil;
import io.github.akashiikun.mavapi.v1.api.ModdedAxolotlVariant;
import org.slf4j.Logger;

public final class JoyAxolotlVariants {
    private static final Logger logger = LogUtils.getLogger();

    public static void init() {
        // Joy.LOGGER.info("Registering Axolotl Variants for {} via MoreAxolotlVariantsAPI", Joy.MOD_ID);

        try {
            register("bi");
            register("ace");
            register("aro");
            register("lesbian");
            register("mlm");
            register("progress");
            register("trans");
            register("aroace");
            register("pan");
        } catch (LinkageError yKnowItIsCursed) {
            logger.error("[Joy] Unable to gay our axolotls, :(", yKnowItIsCursed);
        }
    }

	private static void register(String name) {
		register(name, true);
	}

	private static void register(String name, boolean natural) {
        ModdedAxolotlVariant.Builder builder = ModdedAxolotlVariant.register(JoyUtil.id(name));
		if (natural) {
			builder.natural();
		}
		builder.build();
	}
}
