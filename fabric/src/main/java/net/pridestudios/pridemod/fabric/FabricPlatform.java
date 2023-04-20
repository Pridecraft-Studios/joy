package net.pridestudios.pridemod.fabric;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.pridestudios.pridemod.Platform;
import net.pridestudios.pridemod.PrideMod;

import java.nio.file.Path;
import java.util.function.Supplier;

public class FabricPlatform implements Platform {
    static final Platform PLATFORM = new FabricPlatform();
    public static void init() {
        Platform.init(PLATFORM);
    }
    @Override
    public <T extends Block> T registerBlock(ResourceLocation resourceLocation, T block, boolean registerBlockItem) {
        if (registerBlockItem) {
            registerItem(resourceLocation, new BlockItem(block, new FabricItemSettings()), PrideMod.EXAMPLE_TAB_CONTAINER);
        }
        return Registry.register(BuiltInRegistries.BLOCK, resourceLocation, block);
    }

    @Override
    public <T extends Item> T registerItem(ResourceLocation resourceLocation, T item, CreativeTabContainer tabContainer) {
        tabContainer.itemList.add(item);
        return Registry.register(BuiltInRegistries.ITEM, resourceLocation, item);
    }

    @Override
    public CreativeTabContainer registerCreativeTabContainer(ResourceLocation resourceLocation, Supplier<Item> itemIcon) {
        CreativeTabContainer tabContainer = new CreativeTabContainer(resourceLocation, itemIcon);
        TABS.put(resourceLocation, tabContainer);
        return tabContainer;
    }

    @Override
    public <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(ResourceLocation resourceLocation, BlockEntityType.BlockEntitySupplier<T> factory, Block[] blocks) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, resourceLocation, BlockEntityType.Builder.of(factory, blocks).build(null));
    }

    @Override
    public <T extends Entity> EntityType<T> registerEntityType(ResourceLocation resourceLocation, EntityType<T> entityType) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, resourceLocation, entityType);
    }

    @Override
    public boolean isModLoaded(String id) {
        return FabricLoader.getInstance().isModLoaded(id);
    }

    @Override
    public Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
