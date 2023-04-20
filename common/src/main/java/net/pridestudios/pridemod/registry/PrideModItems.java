package net.pridestudios.pridemod.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.pridestudios.pridemod.PrideMod;

public class PrideModItems {
    public static Item EXAMPLE_ITEM = new Item(new Item.Properties());
    public static void registerItems() {
        EXAMPLE_ITEM = PrideMod.PLATFORM.registerItem(new ResourceLocation(PrideMod.MOD_ID, "example_item"), EXAMPLE_ITEM, PrideMod.EXAMPLE_TAB_CONTAINER);
    }
}
