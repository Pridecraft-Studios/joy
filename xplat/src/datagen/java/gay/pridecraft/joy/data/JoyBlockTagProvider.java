package gay.pridecraft.joy.data;

import gay.pridecraft.joy.registry.JoyBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
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
                .add(JoyBlocks.QUEER_CANDLE)
                .add(JoyBlocks.GAY_CANDLE)
                .add(JoyBlocks.ENBY_CANDLE)
                .add(JoyBlocks.INTERSEX_CANDLE)
                .add(JoyBlocks.AGENDER_CANDLE)
                .add(JoyBlocks.BIGENDER_CANDLE)
                .add(JoyBlocks.BISEXUAL_CANDLE)
                .add(JoyBlocks.MLM_CANDLE)
                .add(JoyBlocks.ACE_CANDLE)
                .add(JoyBlocks.ARO_CANDLE)
                .add(JoyBlocks.APLATONIC_CANDLE)
                .add(JoyBlocks.GENDER_FLUID_CANDLE)
                .add(JoyBlocks.PAN_CANDLE)
                .add(JoyBlocks.TRANS_CANDLE)
                .add(JoyBlocks.AROACE_CANDLE)
                .add(JoyBlocks.LESBIAN_CANDLE)
                .add(JoyBlocks.PROGRESS_CANDLE);

        getOrCreateTagBuilder(BlockTags.BEDS)
                .add(JoyBlocks.GAY_BED)
                .add(JoyBlocks.ENBY_BED)
                .add(JoyBlocks.INTERSEX_BED)
                .add(JoyBlocks.AGENDER_BED)
                .add(JoyBlocks.BIGENDER_BED)
                .add(JoyBlocks.BISEXUAL_BED)
                .add(JoyBlocks.MLM_BED)
                .add(JoyBlocks.ACE_BED)
                .add(JoyBlocks.ARO_BED)
                .add(JoyBlocks.APLATONIC_BED)
                .add(JoyBlocks.GENDER_FLUID_BED)
                .add(JoyBlocks.PAN_BED)
                .add(JoyBlocks.TRANS_BED)
                .add(JoyBlocks.AROACE_BED)
                .add(JoyBlocks.LESBIAN_BED)
                .add(JoyBlocks.PROGRESS_BED);

        getOrCreateTagBuilder(BlockTags.CANDLE_CAKES)
                .add(JoyBlocks.QUEER_CANDLE_CAKE)
                .add(JoyBlocks.GAY_CANDLE_CAKE)
                .add(JoyBlocks.ENBY_CANDLE_CAKE)
                .add(JoyBlocks.INTERSEX_CANDLE_CAKE)
                .add(JoyBlocks.AGENDER_CANDLE_CAKE)
                .add(JoyBlocks.BIGENDER_CANDLE_CAKE)
                .add(JoyBlocks.BISEXUAL_CANDLE_CAKE)
                .add(JoyBlocks.MLM_CANDLE_CAKE)
                .add(JoyBlocks.ACE_CANDLE_CAKE)
                .add(JoyBlocks.ARO_CANDLE_CAKE)
                .add(JoyBlocks.APLATONIC_CANDLE_CAKE)
                .add(JoyBlocks.GENDER_FLUID_CANDLE_CAKE)
                .add(JoyBlocks.PAN_CANDLE_CAKE)
                .add(JoyBlocks.TRANS_CANDLE_CAKE)
                .add(JoyBlocks.AROACE_CANDLE_CAKE)
                .add(JoyBlocks.LESBIAN_CANDLE_CAKE)
                .add(JoyBlocks.PROGRESS_CANDLE_CAKE);
    }
}
