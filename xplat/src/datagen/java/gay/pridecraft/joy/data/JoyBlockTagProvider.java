package gay.pridecraft.joy.data;

import gay.pridecraft.joy.block.BlahajBlocks;
import gay.pridecraft.joy.registry.JoyBlocks;
import gay.pridecraft.joy.tags.JoyBlockTags;
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

        getOrCreateTagBuilder(JoyBlockTags.SHARKS).add(
            BlahajBlocks.BLAHAJ_BLOCK,
            BlahajBlocks.GRAY_SHARK_BLOCK
        ).add(BlahajBlocks.PRIDE_BLOCKS.toArray(Block[]::new));

        getOrCreateTagBuilder(JoyBlockTags.PLUSHIES).add(
            BlahajBlocks.BLAVINGAD_BLOCK,
            BlahajBlocks.BREAD_BLOCK,
            BlahajBlocks.BROWN_BEAR_BLOCK
        ).addTag(JoyBlockTags.SHARKS);

        getOrCreateTagBuilder(JoyBlockTags.PRIDE_DYEABLE)
            .addTag(JoyBlockTags.SHARKS)
            .addTag(BlockTags.BEDS);
    }
}
