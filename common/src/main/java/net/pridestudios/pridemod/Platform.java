package net.pridestudios.pridemod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public interface Platform {
    static void init(Platform platform) {
        PrideMod.PLATFORM = platform;
    }
    Map<ResourceLocation, CreativeTabContainer> TABS = new HashMap<>();

    <T extends Block> T registerBlock(ResourceLocation resourceLocation, T block, boolean registerBlockItem);

    <T extends Item> T registerItem(ResourceLocation resourceLocation, T item, CreativeTabContainer tabContainer);

    CreativeTabContainer registerCreativeTabContainer(ResourceLocation resourceLocation, Supplier<Item> itemIcon);

    <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(ResourceLocation resourceLocation, BlockEntityType.BlockEntitySupplier<T> factory, Block[] blocks);
    <T extends Entity> EntityType<T> registerEntityType(ResourceLocation resourceLocation, EntityType<T> entityType);
    boolean isModLoaded(String id);

    Path getConfigDirectory();

    class CreativeTabContainer {
        public final ResourceLocation resourceLocation;
        public final Supplier<Item> itemSupplier;
        public List<Item> itemList = new ArrayList<>();

        public CreativeModeTab tab = null;
        public CreativeTabContainer(ResourceLocation resourceLocation, Supplier<Item> itemSupplier) {
            this.resourceLocation = resourceLocation;
            this.itemSupplier = itemSupplier;
        }

        public CreativeModeTab getTab() {
            if (tab == null)
                PrideMod.PRIDE_MOD_LOGGER.error("Creative tab %s is not registered yet!".formatted(resourceLocation.toString()));
            return tab;
        }
    }
}
