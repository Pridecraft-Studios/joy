package gay.pridecraft.pridemod;

import gay.pridecraft.pridemod.block.ModBlocks;
import gay.pridecraft.pridemod.item.ModItemGroups;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import gay.pridecraft.pridemod.item.ModItems;

public class PrideMod implements ModInitializer {

	public static final String MOD_ID = "pridemod";
    public static final Logger LOGGER = LoggerFactory.getLogger("MOD_ID");

	@Override
	public void onInitialize() {
		LOGGER.info("Thanks for using PrideMod! Gaying your minecraft...");
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}