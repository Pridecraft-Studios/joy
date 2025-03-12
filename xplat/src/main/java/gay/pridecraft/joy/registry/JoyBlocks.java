package gay.pridecraft.joy.registry;

import gay.pridecraft.joy.Pivot;
import gay.pridecraft.joy.block.JoyBedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.CandleBlock;
import net.minecraft.block.CandleCakeBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;

import static net.minecraft.block.AbstractBlock.Settings.copy;

public final class JoyBlocks {
    // region Beds
    public static final Block GAY_BED = registerBlock("gay_bed",
        new JoyBedBlock(copy(Blocks.RED_BED)));

    public static final Block ENBY_BED = registerBlock("enby_bed",
        new JoyBedBlock(copy(Blocks.BLACK_BED)));

    public static final Block INTERSEX_BED = registerBlock("intersex_bed",
        new JoyBedBlock(copy(Blocks.GREEN_BED)));

    public static final Block AGENDER_BED = registerBlock("agender_bed",
        new JoyBedBlock(copy(Blocks.BROWN_BED)));

    public static final Block BIGENDER_BED = registerBlock("bigender_bed",
        new JoyBedBlock(copy(Blocks.BLUE_BED)));

    public static final Block BISEXUAL_BED = registerBlock("bisexual_bed",
        new JoyBedBlock(copy(Blocks.PURPLE_BED)));

    public static final Block MLM_BED = registerBlock("mlm_bed",
        new JoyBedBlock(copy(Blocks.CYAN_BED)));

    public static final Block ACE_BED = registerBlock("ace_bed",
        new JoyBedBlock(copy(Blocks.LIGHT_GRAY_BED)));

    public static final Block ARO_BED = registerBlock("aro_bed",
        new JoyBedBlock(copy(Blocks.GRAY_BED)));

    public static final Block APLATONIC_BED = registerBlock("aplatonic_bed",
        new JoyBedBlock(copy(Blocks.PINK_BED)));

    public static final Block GENDER_FLUID_BED = registerBlock("gender_fluid_bed",
        new JoyBedBlock(copy(Blocks.LIME_BED)));

    public static final Block PAN_BED = registerBlock("pan_bed",
        new JoyBedBlock(copy(Blocks.YELLOW_BED)));

    public static final Block TRANS_BED = registerBlock("trans_bed",
        new JoyBedBlock(copy(Blocks.LIGHT_BLUE_BED)));

    public static final Block AROACE_BED = registerBlock("aroace_bed",
        new JoyBedBlock(copy(Blocks.MAGENTA_BED)));

    public static final Block LESBIAN_BED = registerBlock("lesbian_bed",
        new JoyBedBlock(copy(Blocks.ORANGE_BED)));

    public static final Block PROGRESS_BED = registerBlock("progress_bed",
        new JoyBedBlock(copy(Blocks.WHITE_BED)));
    // endregion

    // region Candles
    public static final Block QUEER_CANDLE = registerBlock("queer_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block GAY_CANDLE = registerBlock("gay_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block ENBY_CANDLE = registerBlock("enby_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block INTERSEX_CANDLE = registerBlock("intersex_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block AGENDER_CANDLE = registerBlock("agender_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block BIGENDER_CANDLE = registerBlock("bigender_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block BISEXUAL_CANDLE = registerBlock("bisexual_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block MLM_CANDLE = registerBlock("mlm_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block ACE_CANDLE = registerBlock("ace_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block ARO_CANDLE = registerBlock("aro_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block APLATONIC_CANDLE = registerBlock("aplatonic_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block GENDER_FLUID_CANDLE = registerBlock("gender_fluid_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block PAN_CANDLE = registerBlock("pan_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block TRANS_CANDLE = registerBlock("trans_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block AROACE_CANDLE = registerBlock("aroace_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block LESBIAN_CANDLE = registerBlock("lesbian_candle",
        new CandleBlock(copy(Blocks.CANDLE)));

    public static final Block PROGRESS_CANDLE = registerBlock("progress_candle",
        new CandleBlock(copy(Blocks.CANDLE)));
    // endregion

    // region Candle Cakes
    public static final Block QUEER_CANDLE_CAKE = registerBlock("queer_candle_cake",
        new CandleCakeBlock(QUEER_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block GAY_CANDLE_CAKE = registerBlock("gay_candle_cake",
        new CandleCakeBlock(GAY_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block ENBY_CANDLE_CAKE = registerBlock("enby_candle_cake",
        new CandleCakeBlock(ENBY_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block INTERSEX_CANDLE_CAKE = registerBlock("intersex_candle_cake",
        new CandleCakeBlock(INTERSEX_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block AGENDER_CANDLE_CAKE = registerBlock("agender_candle_cake",
        new CandleCakeBlock(AGENDER_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block BIGENDER_CANDLE_CAKE = registerBlock("bigender_candle_cake",
        new CandleCakeBlock(BIGENDER_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block BISEXUAL_CANDLE_CAKE = registerBlock("bisexual_candle_cake",
        new CandleCakeBlock(BISEXUAL_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block MLM_CANDLE_CAKE = registerBlock("mlm_candle_cake",
        new CandleCakeBlock(MLM_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block ACE_CANDLE_CAKE = registerBlock("ace_candle_cake",
        new CandleCakeBlock(ACE_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block ARO_CANDLE_CAKE = registerBlock("aro_candle_cake",
        new CandleCakeBlock(ARO_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block APLATONIC_CANDLE_CAKE = registerBlock("aplatonic_candle_cake",
        new CandleCakeBlock(APLATONIC_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block GENDER_FLUID_CANDLE_CAKE = registerBlock("gender_fluid_candle_cake",
        new CandleCakeBlock(GENDER_FLUID_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block PAN_CANDLE_CAKE = registerBlock("pan_candle_cake",
        new CandleCakeBlock(PAN_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block TRANS_CANDLE_CAKE = registerBlock("trans_candle_cake",
        new CandleCakeBlock(TRANS_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block AROACE_CANDLE_CAKE = registerBlock("aroace_candle_cake",
        new CandleCakeBlock(AROACE_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block LESBIAN_CANDLE_CAKE = registerBlock("lesbian_candle_cake",
        new CandleCakeBlock(LESBIAN_CANDLE, copy(Blocks.CANDLE_CAKE)));

    public static final Block PROGRESS_CANDLE_CAKE = registerBlock("progress_candle_cake",
        new CandleCakeBlock(PROGRESS_CANDLE, copy(Blocks.CANDLE_CAKE)));
    // endregion

    public static final Block PRIDE_CAKE = registerBlock("pride_cake",
        new CakeBlock(copy(Blocks.CAKE)));

    public static final Block
        PINK_ALLIUM = registerFlower("pink_allium", Blocks.ALLIUM),
        BLUE_ALLIUM = registerFlower("blue_allium", Blocks.ALLIUM),
        WHITE_ALLIUM = registerFlower("white_allium", Blocks.ALLIUM),
        TRANS_ALLIUM = registerFlower("trans_allium", Blocks.ALLIUM),
        POTTED_PINK_ALLIUM = registerFlowerPot(PINK_ALLIUM, Blocks.POTTED_ALLIUM),
        POTTED_BLUE_ALLIUM = registerFlowerPot(BLUE_ALLIUM, Blocks.POTTED_ALLIUM),
        POTTED_WHITE_ALLIUM = registerFlowerPot(WHITE_ALLIUM, Blocks.POTTED_ALLIUM),
        POTTED_TRANS_ALLIUM = registerFlowerPot(TRANS_ALLIUM, Blocks.POTTED_ALLIUM);

    // region Registration Helpers

    private static Block registerFlower(String name, Block block) {
        if (!(block instanceof FlowerBlock flower)) {
            throw new AssertionError(block + " not flower");
        }
        return registerBlock(name, new FlowerBlock(flower.getStewEffects(), copy(flower)));
    }

    private static Block registerFlowerPot(Block flower, Block block) {
        final String name = "potted_" + Registries.BLOCK.getId(flower).getPath();
        return register(name, new FlowerPotBlock(flower, copy(block)));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Pivot.INSTANCE.register(RegistryKeys.BLOCK, name, block);
    }

    private static Block register(String name, Block block) {
        return Pivot.INSTANCE.register(RegistryKeys.BLOCK, name, block);
    }

    private static Item registerBlockItem(String name, Block block) {
        // FIXME: This should have a permanent reference in JoyItems.
        return Pivot.INSTANCE.register(RegistryKeys.ITEM, name, new BlockItem(block, new Item.Settings()));
    }
    // endregion

    /**
     * Workaround to force classloading
     */
    public static void init() {
        // NO-OP
    }
}
