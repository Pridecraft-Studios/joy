package gay.pridecraft.joy.datagen;

import gay.pridecraft.joy.block.ModBlocks;
import gay.pridecraft.joy.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCandle(ModBlocks.QUEER_CANDLE, ModBlocks.QUEER_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.GAY_CANDLE, ModBlocks.GAY_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.ENBY_CANDLE, ModBlocks.ENBY_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.INTERSEX_CANDLE, ModBlocks.INTERSEX_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.AGENDER_CANDLE, ModBlocks.AGENDER_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.BIGENDER_CANDLE, ModBlocks.BIGENDER_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.BISEXUAL_CANDLE, ModBlocks.BISEXUAL_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.MLM_CANDLE, ModBlocks.MLM_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.ACE_CANDLE, ModBlocks.ACE_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.ARO_CANDLE, ModBlocks.ARO_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.APLATONIC_CANDLE, ModBlocks.APLATONIC_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.GENDER_FLUID_CANDLE, ModBlocks.GENDER_FLUID_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.PAN_CANDLE, ModBlocks.PAN_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.TRANS_CANDLE, ModBlocks.TRANS_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.AROACE_CANDLE, ModBlocks.AROACE_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.LESBIAN_CANDLE, ModBlocks.LESBIAN_CANDLE_CAKE);
        blockStateModelGenerator.registerCandle(ModBlocks.PROGRESS_CANDLE, ModBlocks.PROGRESS_CANDLE_CAKE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TOTEM_OF_PRIDE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIDE_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIDE_BRUSH, Models.GENERATED);
//      itemModelGenerator.register(ModItems.SOCK_FOX_SPAWN_EGG, Models.GENERATED);
//      itemModelGenerator.register(ModItems.BII_SPAWN_EGG, Models.GENERATED);
//      itemModelGenerator.register(ModItems.ENBEE_SPAWN_EGG, Models.GENERATED);
//      itemModelGenerator.register(ModItems.TRANS_BEE_SPAWN_EGG, Models.GENERATED);
//      itemModelGenerator.register(ModItems.AXOLOTL_SPAWN_EGG, Models.GENERATED);
//      itemModelGenerator.register(ModItems.SNIFFER_SPAWN_EGG, Models.GENERATED);
    }
}