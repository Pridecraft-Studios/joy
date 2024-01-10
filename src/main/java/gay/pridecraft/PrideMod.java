package gay.pridecraft;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrideMod implements ModInitializer {
	
    public static final Logger LOGGER = LoggerFactory.getLogger("pridemod");

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Gay world!");
	}
}