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
import net.minecraft.item.BedItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;

import java.util.List;

import static net.minecraft.block.AbstractBlock.Settings.copy;

public final class JoyBlocks {
    // region Beds,
    public static final Block
        GAY_BED = registerBed("gay_bed", Blocks.RED_BED),
        ENBY_BED = registerBed("enby_bed", Blocks.BLACK_BED),
        INTERSEX_BED = registerBed("intersex_bed", Blocks.GREEN_BED),
        AGENDER_BED = registerBed("agender_bed", Blocks.BROWN_BED),
        BIGENDER_BED = registerBed("bigender_bed", Blocks.BLUE_BED),
        BISEXUAL_BED = registerBed("bisexual_bed", Blocks.PURPLE_BED),
        MLM_BED = registerBed("mlm_bed", Blocks.CYAN_BED),
        ACE_BED = registerBed("ace_bed", Blocks.LIGHT_GRAY_BED),
        ARO_BED = registerBed("aro_bed", Blocks.GRAY_BED),
        APLATONIC_BED = registerBed("aplatonic_bed", Blocks.PINK_BED),
        GENDER_FLUID_BED = registerBed("gender_fluid_bed", Blocks.LIME_BED),
        PAN_BED = registerBed("pan_bed", Blocks.YELLOW_BED),
        TRANS_BED = registerBed("trans_bed", Blocks.LIGHT_BLUE_BED),
        AROACE_BED = registerBed("aroace_bed", Blocks.MAGENTA_BED),
        LESBIAN_BED = registerBed("lesbian_bed", Blocks.ORANGE_BED),
        PROGRESS_BED = registerBed("progress_bed", Blocks.WHITE_BED);

    public static final List<Block> BEDS = List.of(
        GAY_BED,
        ENBY_BED,
        INTERSEX_BED,
        AGENDER_BED,
        BIGENDER_BED,
        BISEXUAL_BED,
        MLM_BED,
        ACE_BED,
        ARO_BED,
        APLATONIC_BED,
        GENDER_FLUID_BED,
        PAN_BED,
        TRANS_BED,
        AROACE_BED,
        LESBIAN_BED,
        PROGRESS_BED
    );

    private static Block registerBed(String name, Block src) {
        final var block = new JoyBedBlock(copy(src));
        Pivot.INSTANCE.register(RegistryKeys.ITEM, name, new BedItem(block, new Item.Settings().maxCount(1)));
        return register(name, block);
    }
    // endregion

    // region Candles
    public static final Block
        QUEER_CANDLE = registerCandle("queer_candle"),
        GAY_CANDLE = registerCandle("gay_candle"),
        ENBY_CANDLE = registerCandle("enby_candle"),
        INTERSEX_CANDLE = registerCandle("intersex_candle"),
        AGENDER_CANDLE = registerCandle("agender_candle"),
        BIGENDER_CANDLE = registerCandle("bigender_candle"),
        BISEXUAL_CANDLE = registerCandle("bisexual_candle"),
        MLM_CANDLE = registerCandle("mlm_candle"),
        ACE_CANDLE = registerCandle("ace_candle"),
        ARO_CANDLE = registerCandle("aro_candle"),
        APLATONIC_CANDLE = registerCandle("aplatonic_candle"),
        GENDER_FLUID_CANDLE = registerCandle("gender_fluid_candle"),
        PAN_CANDLE = registerCandle("pan_candle"),
        TRANS_CANDLE = registerCandle("trans_candle"),
        AROACE_CANDLE = registerCandle("aroace_candle"),
        LESBIAN_CANDLE = registerCandle("lesbian_candle"),
        PROGRESS_CANDLE = registerCandle("progress_candle");

    public static final List<Block> CANDLES = List.of(
        QUEER_CANDLE,
        GAY_CANDLE,
        ENBY_CANDLE,
        INTERSEX_CANDLE,
        AGENDER_CANDLE,
        BIGENDER_CANDLE,
        BISEXUAL_CANDLE,
        MLM_CANDLE,
        ACE_CANDLE,
        ARO_CANDLE,
        APLATONIC_CANDLE,
        GENDER_FLUID_CANDLE,
        PAN_CANDLE,
        TRANS_CANDLE,
        AROACE_CANDLE,
        LESBIAN_CANDLE,
        PROGRESS_CANDLE
    );

    private static Block registerCandle(String name) {
        return registerBlock(name, new CandleBlock(copy(Blocks.CANDLE)));
    }
    // endregion

    // region Candle Cakes
    public static final Block
        QUEER_CANDLE_CAKE = registerCandleCake(QUEER_CANDLE),
        GAY_CANDLE_CAKE = registerCandleCake(GAY_CANDLE),
        ENBY_CANDLE_CAKE = registerCandleCake(ENBY_CANDLE),
        INTERSEX_CANDLE_CAKE = registerCandleCake(INTERSEX_CANDLE),
        AGENDER_CANDLE_CAKE = registerCandleCake(AGENDER_CANDLE),
        BIGENDER_CANDLE_CAKE = registerCandleCake(BIGENDER_CANDLE),
        BISEXUAL_CANDLE_CAKE = registerCandleCake(BISEXUAL_CANDLE),
        MLM_CANDLE_CAKE = registerCandleCake(MLM_CANDLE),
        ACE_CANDLE_CAKE = registerCandleCake(ACE_CANDLE),
        ARO_CANDLE_CAKE = registerCandleCake(ARO_CANDLE),
        APLATONIC_CANDLE_CAKE = registerCandleCake(APLATONIC_CANDLE),
        GENDER_FLUID_CANDLE_CAKE = registerCandleCake(GENDER_FLUID_CANDLE),
        PAN_CANDLE_CAKE = registerCandleCake(PAN_CANDLE),
        TRANS_CANDLE_CAKE = registerCandleCake(TRANS_CANDLE),
        AROACE_CANDLE_CAKE = registerCandleCake(AROACE_CANDLE),
        LESBIAN_CANDLE_CAKE = registerCandleCake(LESBIAN_CANDLE),
        PROGRESS_CANDLE_CAKE = registerCandleCake(PROGRESS_CANDLE);

    public static final List<Block> CANDLE_CAKES = List.of(
        QUEER_CANDLE_CAKE,
        GAY_CANDLE_CAKE,
        ENBY_CANDLE_CAKE,
        INTERSEX_CANDLE_CAKE,
        AGENDER_CANDLE_CAKE,
        BIGENDER_CANDLE_CAKE,
        BISEXUAL_CANDLE_CAKE,
        MLM_CANDLE_CAKE,
        ACE_CANDLE_CAKE,
        ARO_CANDLE_CAKE,
        APLATONIC_CANDLE_CAKE,
        GENDER_FLUID_CANDLE_CAKE,
        PAN_CANDLE_CAKE,
        TRANS_CANDLE_CAKE,
        AROACE_CANDLE_CAKE,
        LESBIAN_CANDLE_CAKE,
        PROGRESS_CANDLE_CAKE
    );

    private static Block registerCandleCake(Block candle) {
        final var name = Registries.BLOCK.getId(candle).getPath() + "_cake";
        return registerBlock(name, new CandleCakeBlock(candle, copy(Blocks.CANDLE_CAKE)));
    }
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

    public static final List<Block> PLANTS = List.of(
        PINK_ALLIUM,
        BLUE_ALLIUM,
        WHITE_ALLIUM,
        TRANS_ALLIUM
    );

    public static final List<Block> POTTED_PLANTS = List.of(
        POTTED_PINK_ALLIUM,
        POTTED_BLUE_ALLIUM,
        POTTED_WHITE_ALLIUM,
        POTTED_TRANS_ALLIUM
    );

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
        return register(name, block);
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
