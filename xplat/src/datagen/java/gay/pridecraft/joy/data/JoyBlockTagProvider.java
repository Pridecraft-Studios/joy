package gay.pridecraft.joy.data;

import gay.pridecraft.joy.registry.JoyBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class JoyBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public JoyBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.CANDLES)
            .add(JoyBlocks.CANDLES.toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.BEDS)
            .add(JoyBlocks.BEDS.toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.CANDLE_CAKES)
            .add(JoyBlocks.CANDLE_CAKES.toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
            .add(JoyBlocks.PLANTS.toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
            .add(JoyBlocks.POTTED_PLANTS.toArray(Block[]::new));
    }
}
