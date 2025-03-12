package gay.pridecraft.joy.data;

import gay.pridecraft.joy.JoyUtil;
import gay.pridecraft.joy.registry.JoyBlocks;
import gay.pridecraft.joy.registry.JoyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateSupplier;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class JoyModelProvider extends FabricModelProvider {
    public JoyModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator gen) {
        registerBed(gen, JoyBlocks.GAY_BED);
        registerBed(gen, JoyBlocks.ENBY_BED);
        registerBed(gen, JoyBlocks.INTERSEX_BED);
        registerBed(gen, JoyBlocks.AGENDER_BED);
        registerBed(gen, JoyBlocks.BIGENDER_BED);
        registerBed(gen, JoyBlocks.BISEXUAL_BED);
        registerBed(gen, JoyBlocks.MLM_BED);
        registerBed(gen, JoyBlocks.ACE_BED);
        registerBed(gen, JoyBlocks.ARO_BED);
        registerBed(gen, JoyBlocks.APLATONIC_BED);
        registerBed(gen, JoyBlocks.GENDER_FLUID_BED);
        registerBed(gen, JoyBlocks.PAN_BED);
        registerBed(gen, JoyBlocks.TRANS_BED);
        registerBed(gen, JoyBlocks.AROACE_BED);
        registerBed(gen, JoyBlocks.LESBIAN_BED);
        registerBed(gen, JoyBlocks.PROGRESS_BED);
        gen.registerCandle(JoyBlocks.QUEER_CANDLE, JoyBlocks.QUEER_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.GAY_CANDLE, JoyBlocks.GAY_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.ENBY_CANDLE, JoyBlocks.ENBY_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.INTERSEX_CANDLE, JoyBlocks.INTERSEX_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.AGENDER_CANDLE, JoyBlocks.AGENDER_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.BIGENDER_CANDLE, JoyBlocks.BIGENDER_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.BISEXUAL_CANDLE, JoyBlocks.BISEXUAL_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.MLM_CANDLE, JoyBlocks.MLM_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.ACE_CANDLE, JoyBlocks.ACE_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.ARO_CANDLE, JoyBlocks.ARO_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.APLATONIC_CANDLE, JoyBlocks.APLATONIC_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.GENDER_FLUID_CANDLE, JoyBlocks.GENDER_FLUID_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.PAN_CANDLE, JoyBlocks.PAN_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.TRANS_CANDLE, JoyBlocks.TRANS_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.AROACE_CANDLE, JoyBlocks.AROACE_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.LESBIAN_CANDLE, JoyBlocks.LESBIAN_CANDLE_CAKE);
        gen.registerCandle(JoyBlocks.PROGRESS_CANDLE, JoyBlocks.PROGRESS_CANDLE_CAKE);
        registerCake(gen, JoyBlocks.PRIDE_CAKE);

        gen.registerFlowerPotPlant(JoyBlocks.PINK_ALLIUM, JoyBlocks.POTTED_PINK_ALLIUM, BlockStateModelGenerator.TintType.NOT_TINTED);
        gen.registerFlowerPotPlant(JoyBlocks.BLUE_ALLIUM, JoyBlocks.POTTED_BLUE_ALLIUM, BlockStateModelGenerator.TintType.NOT_TINTED);
        gen.registerFlowerPotPlant(JoyBlocks.WHITE_ALLIUM, JoyBlocks.POTTED_WHITE_ALLIUM, BlockStateModelGenerator.TintType.NOT_TINTED);
        gen.registerFlowerPotPlant(JoyBlocks.TRANS_ALLIUM, JoyBlocks.POTTED_TRANS_ALLIUM, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    private static void registerBed(BlockStateModelGenerator gen, Block block) {
        gen.registerBuiltin(block, Blocks.OAK_PLANKS);
        final var model = item("template_bed", TextureKey.TEXTURE);
        final var item = block.asItem();
        model.upload(
            ModelIds.getItemModelId(item),
            TextureMap.of(TextureKey.TEXTURE, TextureMap.getId(item)),
            gen.modelCollector);

        gen.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, ModelIds.getBlockModelId(block)));
    }

    public static void registerCake(BlockStateModelGenerator gen, Block cake) {
        gen.registerItemModel(cake.asItem());

        final var base = blockVanilla("cake", TextureKey.TOP);
        base.upload(
            ModelIds.getBlockModelId(cake),
            TextureMap.top(cake),
            gen.modelCollector
        );

        for (int i = 1; i <= 6; i++) {
            final var slice = blockVanilla("cake_slice" + i, TextureKey.TOP);
            slice.upload(
                ModelIds.getBlockSubModelId(cake, "_slice" + i),
                TextureMap.top(cake),
                gen.modelCollector
            );
        }

        gen.blockStateCollector.accept(cakeBlockState(cake, ModelIds.getBlockModelId(cake)));
    }

    private static BlockStateSupplier cakeBlockState(Block block, Identifier base) {
        final var supplier = MultipartBlockStateSupplier.create(block)
            .with(When.create().set(CakeBlock.BITES, 0), model(base));

        for (int i = 1; i <= 6; i++) {
            supplier.with(When.create().set(CakeBlock.BITES, i), model(base.withSuffixedPath("_slice" + i)));
        }

        return supplier;
    }

    private static BlockStateVariant model(Identifier model) {
        return BlockStateVariant.create()
            .put(VariantSettings.MODEL, model);
    }

    @Override
    public void generateItemModels(ItemModelGenerator gen) {
        for (final var bundle : JoyItems.BUNDLES) {
            gen.register(bundle, Models.GENERATED);
        }

        gen.register(JoyItems.TOTEM_OF_PRIDE, Models.GENERATED);
        gen.register(JoyItems.PRIDE_ELYTRA, Models.GENERATED);
        gen.register(JoyItems.PRIDE_BRUSH, Models.GENERATED);
        gen.register(JoyItems.SOCK_FOX_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        gen.register(JoyItems.BII_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        gen.register(JoyItems.ENBEE_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        gen.register(JoyItems.TRANS_BEE_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        gen.register(JoyItems.FROG_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        gen.register(JoyItems.SNIFFER_SPAWN_EGG, TEMPLATE_SPAWN_EGG);
        gen.register(JoyItems.DOUGLAS_DISC, Models.GENERATED);
        gen.register(JoyItems.MELANCOLIE_DISC, Models.GENERATED);
    }

    public static final Model TEMPLATE_SPAWN_EGG = new Model(Optional.of(Identifier.ofVanilla("item/template_spawn_egg")), Optional.empty());


    private static Model make(TextureKey... requiredTextureKeys) {
        return new Model(Optional.empty(), Optional.empty(), requiredTextureKeys);// 187
    }

    private static Model block(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(JoyUtil.id("block/" + parent)), Optional.empty(), requiredTextureKeys);// 191
    }

    private static Model blockVanilla(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.ofVanilla("block/" + parent)), Optional.empty(), requiredTextureKeys);// 191
    }

    private static Model item(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(JoyUtil.id("item/" + parent)), Optional.empty(), requiredTextureKeys);// 195
    }

    private static Model block(String parent, String variant, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.ofVanilla("block/" + parent)), Optional.of(variant), requiredTextureKeys);// 199
    }
}
