package gay.pridecraft.joy.datagen;

import gay.pridecraft.joy.registry.JoyBlocks;
import gay.pridecraft.joy.registry.JoyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class JoyModelProvider extends FabricModelProvider {
    public JoyModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCandle(JoyBlocks.QUEER_CANDLE, JoyBlocks.QUEER_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.GAY_CANDLE, JoyBlocks.GAY_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.ENBY_CANDLE, JoyBlocks.ENBY_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.INTERSEX_CANDLE, JoyBlocks.INTERSEX_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.AGENDER_CANDLE, JoyBlocks.AGENDER_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.BIGENDER_CANDLE, JoyBlocks.BIGENDER_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.BISEXUAL_CANDLE, JoyBlocks.BISEXUAL_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.MLM_CANDLE, JoyBlocks.MLM_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.ACE_CANDLE, JoyBlocks.ACE_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.ARO_CANDLE, JoyBlocks.ARO_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.APLATONIC_CANDLE, JoyBlocks.APLATONIC_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.GENDER_FLUID_CANDLE, JoyBlocks.GENDER_FLUID_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.PAN_CANDLE, JoyBlocks.PAN_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.TRANS_CANDLE, JoyBlocks.TRANS_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.AROACE_CANDLE, JoyBlocks.AROACE_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.LESBIAN_CANDLE, JoyBlocks.LESBIAN_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(JoyBlocks.PROGRESS_CANDLE, JoyBlocks.PROGRESS_CANDLE_CAKE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(JoyItems.TOTEM_OF_PRIDE, Models.GENERATED);
        itemModelGenerator.register(JoyItems.PRIDE_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(JoyItems.PRIDE_BRUSH, Models.GENERATED);
        itemModelGenerator.register(JoyItems.SOCK_FOX_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        itemModelGenerator.register(JoyItems.BII_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        itemModelGenerator.register(JoyItems.ENBEE_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        itemModelGenerator.register(JoyItems.TRANS_BEE_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        itemModelGenerator.register(JoyItems.FROG_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        itemModelGenerator.register(JoyItems.SNIFFER_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        itemModelGenerator.register(JoyItems.TEST_DISC, Models.GENERATED);
        itemModelGenerator.register(JoyItems.TEST_DISK, Models.GENERATED);
    }

    public static final Model TEMPLATE_SPAWN_EGG = new Model(Optional.of(Identifier.ofVanilla("item/template_spawn_egg")), Optional.empty());
}