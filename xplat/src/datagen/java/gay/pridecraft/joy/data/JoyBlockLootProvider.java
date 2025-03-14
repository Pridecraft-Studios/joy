package gay.pridecraft.joy.data;

import gay.pridecraft.joy.block.BlahajBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static gay.pridecraft.joy.registry.JoyBlocks.ACE_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.ACE_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.AGENDER_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.AGENDER_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.APLATONIC_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.APLATONIC_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.AROACE_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.AROACE_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.ARO_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.ARO_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.BEDS;
import static gay.pridecraft.joy.registry.JoyBlocks.BIGENDER_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.BIGENDER_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.BISEXUAL_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.BISEXUAL_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.CANDLES;
import static gay.pridecraft.joy.registry.JoyBlocks.ENBY_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.ENBY_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.GAY_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.GAY_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.GENDERFLUID_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.GENDERFLUID_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.INTERSEX_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.INTERSEX_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.LESBIAN_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.LESBIAN_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.MLM_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.MLM_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.PAN_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.PAN_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.PLANTS;
import static gay.pridecraft.joy.registry.JoyBlocks.POTTED_PLANTS;
import static gay.pridecraft.joy.registry.JoyBlocks.PRIDE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.PROGRESS_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.PROGRESS_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.QUEER_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.QUEER_CANDLE_CAKE;
import static gay.pridecraft.joy.registry.JoyBlocks.TRANS_CANDLE;
import static gay.pridecraft.joy.registry.JoyBlocks.TRANS_CANDLE_CAKE;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public class JoyBlockLootProvider extends FabricBlockLootTableProvider {
    protected JoyBlockLootProvider(final FabricDataOutput dataOutput, final CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        BEDS.forEach(this::addDrop);
        CANDLES.forEach(this::addDrop);

        addDrop(QUEER_CANDLE_CAKE, QUEER_CANDLE);
        addDrop(GAY_CANDLE_CAKE, GAY_CANDLE);
        addDrop(ENBY_CANDLE_CAKE, ENBY_CANDLE);
        addDrop(INTERSEX_CANDLE_CAKE, INTERSEX_CANDLE);
        addDrop(AGENDER_CANDLE_CAKE, AGENDER_CANDLE);
        addDrop(BIGENDER_CANDLE_CAKE, BIGENDER_CANDLE);
        addDrop(BISEXUAL_CANDLE_CAKE, BISEXUAL_CANDLE);
        addDrop(MLM_CANDLE_CAKE, MLM_CANDLE);
        addDrop(ACE_CANDLE_CAKE, ACE_CANDLE);
        addDrop(ARO_CANDLE_CAKE, ARO_CANDLE);
        addDrop(APLATONIC_CANDLE_CAKE, APLATONIC_CANDLE);
        addDrop(GENDERFLUID_CANDLE_CAKE, GENDERFLUID_CANDLE);
        addDrop(PAN_CANDLE_CAKE, PAN_CANDLE);
        addDrop(TRANS_CANDLE_CAKE, TRANS_CANDLE);
        addDrop(AROACE_CANDLE_CAKE, AROACE_CANDLE);
        addDrop(LESBIAN_CANDLE_CAKE, LESBIAN_CANDLE);
        addDrop(PROGRESS_CANDLE_CAKE, PROGRESS_CANDLE);

        PLANTS.forEach(this::addDrop);
        POTTED_PLANTS.forEach(this::addPottedPlantDrops);

        addDrop(BlahajBlocks.BLAHAJ_BLOCK);
        addDrop(BlahajBlocks.BLAVINGAD_BLOCK);
        addDrop(BlahajBlocks.BREAD_BLOCK);
        addDrop(BlahajBlocks.BROWN_BEAR_BLOCK);
        addDrop(BlahajBlocks.GRAY_SHARK_BLOCK);
        BlahajBlocks.PRIDE_BLOCKS.forEach(this::addDrop);

        addDrop(PRIDE_CAKE, dropsNothing());
    }
}
