package net.pridestudios.pridemod.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.pridestudios.pridemod.PrideMod;
import net.pridestudios.pridemod.registry.PrideModBlockEntities;
import net.pridestudios.pridemod.registry.PrideModBlocks;
import net.pridestudios.pridemod.registry.PrideModEntities;
import net.pridestudios.pridemod.registry.PrideModItems;

public class PrideModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        FabricPlatform.init();
        PrideMod.registerCreativeModeTabContainers();
        PrideModBlocks.registerBlocks();
        PrideModItems.registerItems();
        PrideModBlockEntities.registerBlockEntities();
        PrideModEntities.registerEntities();
        registerCreativeTabs();
    }

    private static void registerCreativeTabs() {
        PrideMod.PLATFORM.TABS.forEach((resourceLocation, creativeTabContainer) -> {
            creativeTabContainer.tab = FabricItemGroup.builder(resourceLocation).icon(() -> new ItemStack(creativeTabContainer.itemSupplier.get())).displayItems((featureFlagSet, stacks, bl) -> creativeTabContainer.itemList.forEach(stacks::accept)).build();
        });
    }
}
