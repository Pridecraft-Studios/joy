package net.pridestudios.pridemod.forge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLPaths;
import net.pridestudios.pridemod.Platform;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ForgePlatform implements Platform {
    private static final Platform PLATFORM = new ForgePlatform();
    public static void init() {
        Platform.init(PLATFORM);
    }
    public static Map<ResourceLocation, Block> resourceLocationBlockMap = new LinkedHashMap<>();
    public static Map<ResourceLocation, Block> blockMapForBlockItems = new LinkedHashMap<>();
    public static Map<ResourceLocation, Item> resourceLocationItemMap = new LinkedHashMap<>();
    public static Map<ResourceLocation, EntityType<?>> resourceLocationEntityTypeMap = new LinkedHashMap<>();
    public static Map<ResourceLocation, BlockEntityType<?>> resourceLocationBlockEntityTypeMap = new LinkedHashMap<>();

    @Override
    public <T extends Block> T registerBlock(ResourceLocation resourceLocation, T block, boolean registerBlockItem) {
        if (registerBlockItem) {
            blockMapForBlockItems.put(resourceLocation, block);
        }
        resourceLocationBlockMap.put(resourceLocation, block);
        return block;
    }

    @Override
    public <T extends Item> T registerItem(ResourceLocation resourceLocation, T item, CreativeTabContainer tabContainer) {
        tabContainer.itemList.add(item);
        resourceLocationItemMap.put(resourceLocation, item);
        return item;
    }

    @Override
    public CreativeTabContainer registerCreativeTabContainer(ResourceLocation resourceLocation, Supplier<Item> itemIcon) {
        TABS.put(resourceLocation, new CreativeTabContainer(resourceLocation, itemIcon));
        return TABS.get(resourceLocation);
    }

    @Override
    public <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(ResourceLocation resourceLocation, BlockEntityType.BlockEntitySupplier<T> factory, Block[] blocks) {
        BlockEntityType<T> blockEntityType = BlockEntityType.Builder.of(factory, blocks).build(null);
        resourceLocationBlockEntityTypeMap.put(resourceLocation, blockEntityType);
        return blockEntityType;
    }

    @Override
    public <T extends Entity> EntityType<T> registerEntityType(ResourceLocation resourceLocation, EntityType<T> entityType) {
        resourceLocationEntityTypeMap.put(resourceLocation, entityType);
        return entityType;
    }

    @Override
    public boolean isModLoaded(String id) {
        return ModList.get().isLoaded(id);
    }

    @Override
    public Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}