package net.pridestudios.pridemod.forge;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.pridestudios.pridemod.PrideMod;
import net.pridestudios.pridemod.registry.PrideModBlockEntities;
import net.pridestudios.pridemod.registry.PrideModBlocks;
import net.pridestudios.pridemod.registry.PrideModEntities;
import net.pridestudios.pridemod.registry.PrideModItems;

@Mod(PrideMod.MOD_ID)
public class PrideModForge {
    public PrideModForge() {
        ForgePlatform.init();
        PrideMod.registerCreativeModeTabContainers();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::register);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::buildContents);
    }

    @SubscribeEvent
    public void buildContents(CreativeModeTabEvent.Register event) {
        PrideMod.PLATFORM.TABS.forEach((resourceLocation, creativeTabContainer) -> {
            event.registerCreativeModeTab(resourceLocation, builder -> {
               creativeTabContainer.tab = builder.icon(() -> new ItemStack(creativeTabContainer.itemSupplier.get()))
                       .title(Component.translatable("itemGroup.%s.%s".formatted(resourceLocation.getNamespace(), resourceLocation.getPath())))
                       .displayItems((enabledFeatures, stacks, operatorEnabled) -> {
                        creativeTabContainer.itemList.forEach(stacks::accept);
                }).build();
            });
        });
    }

    @SubscribeEvent
    public void register(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.BLOCKS,
                helper -> {
            PrideModBlocks.registerBlocks();
            ForgePlatform.resourceLocationBlockMap.forEach(helper::register);
        });
        event.register(ForgeRegistries.Keys.ITEMS,
                helper -> {
            PrideModItems.registerItems();
            ForgePlatform.resourceLocationItemMap.forEach(helper::register);
            ForgePlatform.blockMapForBlockItems.forEach((resourceLocation, block) -> helper.register(resourceLocation, new BlockItem(block, new Item.Properties())));
        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES,
                helper -> {
            PrideModEntities.registerEntities();
            ForgePlatform.resourceLocationEntityTypeMap.forEach(helper::register);
        });
        event.register(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES,
                helper -> {
            PrideModBlockEntities.registerBlockEntities();
            ForgePlatform.resourceLocationBlockEntityTypeMap.forEach(helper::register);
        });
    }
}
