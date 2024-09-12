package gay.pridecraft.joy.datagen;

import gay.pridecraft.joy.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.CANDLES)
                .add(ModBlocks.QUEER_CANDLE)
                .add(ModBlocks.GAY_CANDLE)
                .add(ModBlocks.ENBY_CANDLE)
                .add(ModBlocks.INTERSEX_CANDLE)
                .add(ModBlocks.AGENDER_CANDLE)
                .add(ModBlocks.BIGENDER_CANDLE)
                .add(ModBlocks.BISEXUAL_CANDLE)
                .add(ModBlocks.MLM_CANDLE)
                .add(ModBlocks.ACE_CANDLE)
                .add(ModBlocks.ARO_CANDLE)
                .add(ModBlocks.APLATONIC_CANDLE)
                .add(ModBlocks.GENDER_FLUID_CANDLE)
                .add(ModBlocks.PAN_CANDLE)
                .add(ModBlocks.TRANS_CANDLE)
                .add(ModBlocks.AROACE_CANDLE)
                .add(ModBlocks.LESBIAN_CANDLE)
                .add(ModBlocks.PROGRESS_CANDLE);

        getOrCreateTagBuilder(BlockTags.BEDS)
                .add(ModBlocks.GAY_BED)
                .add(ModBlocks.ENBY_BED)
                .add(ModBlocks.INTERSEX_BED)
                .add(ModBlocks.AGENDER_BED)
                .add(ModBlocks.BIGENDER_BED)
                .add(ModBlocks.BISEXUAL_BED)
                .add(ModBlocks.MLM_BED)
                .add(ModBlocks.ACE_BED)
                .add(ModBlocks.ARO_BED)
                .add(ModBlocks.APLATONIC_BED)
                .add(ModBlocks.GENDER_FLUID_BED)
                .add(ModBlocks.PAN_BED)
                .add(ModBlocks.TRANS_BED)
                .add(ModBlocks.AROACE_BED)
                .add(ModBlocks.LESBIAN_BED)
                .add(ModBlocks.PROGRESS_BED);


        getOrCreateTagBuilder(BlockTags.CANDLE_CAKES)
                .add(ModBlocks.QUEER_CANDLE_CAKE)
                .add(ModBlocks.GAY_CANDLE_CAKE)
                .add(ModBlocks.ENBY_CANDLE_CAKE)
                .add(ModBlocks.INTERSEX_CANDLE_CAKE)
                .add(ModBlocks.AGENDER_CANDLE_CAKE)
                .add(ModBlocks.BIGENDER_CANDLE_CAKE)
                .add(ModBlocks.BISEXUAL_CANDLE_CAKE)
                .add(ModBlocks.MLM_CANDLE_CAKE)
                .add(ModBlocks.ACE_CANDLE_CAKE)
                .add(ModBlocks.ARO_CANDLE_CAKE)
                .add(ModBlocks.APLATONIC_CANDLE_CAKE)
                .add(ModBlocks.GENDER_FLUID_CANDLE_CAKE)
                .add(ModBlocks.PAN_CANDLE_CAKE)
                .add(ModBlocks.TRANS_CANDLE_CAKE)
                .add(ModBlocks.AROACE_CANDLE_CAKE)
                .add(ModBlocks.LESBIAN_CANDLE_CAKE)
                .add(ModBlocks.PROGRESS_CANDLE_CAKE);
    }
}