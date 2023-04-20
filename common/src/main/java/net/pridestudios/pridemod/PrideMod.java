package net.pridestudios.pridemod;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.pridestudios.pridemod.registry.PrideModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrideMod {
    public static final String MOD_ID = "pridemod";
    public static final Logger PRIDE_MOD_LOGGER = LogManager.getLogger();
    public static Platform PLATFORM = null;
    public static Platform.CreativeTabContainer EXAMPLE_TAB_CONTAINER;

    public static void registerCreativeModeTabContainers() {
        EXAMPLE_TAB_CONTAINER = PrideMod.PLATFORM.registerCreativeTabContainer(new ResourceLocation(MOD_ID, "example_tab"), () -> PrideModItems.EXAMPLE_ITEM);
    }

    public static void init() {
        PRIDE_MOD_LOGGER.info("hello world");
    }
}
