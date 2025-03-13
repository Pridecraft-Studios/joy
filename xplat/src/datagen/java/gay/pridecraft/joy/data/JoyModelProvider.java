package gay.pridecraft.joy.data;

import gay.pridecraft.joy.JoyUtil;
import gay.pridecraft.joy.block.BlahajBlocks;
import gay.pridecraft.joy.block.CuddlyBlock;
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
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.List;
import java.util.Optional;

public class JoyModelProvider extends FabricModelProvider {
    public JoyModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator gen) {
        JoyBlocks.BEDS.forEach(bed -> registerBed(gen, bed));
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

        registerProxy(gen,
            BlahajBlocks.BLAHAJ_BLOCK,
            BlahajBlocks.BLAVINGAD_BLOCK,
            BlahajBlocks.BREAD_BLOCK,
            BlahajBlocks.BROWN_BEAR_BLOCK
        );
        for (final var block : List.of(
            BlahajBlocks.BLAHAJ_BLOCK,
            BlahajBlocks.BLAVINGAD_BLOCK,
            BlahajBlocks.BREAD_BLOCK,
            BlahajBlocks.BROWN_BEAR_BLOCK)) {
            gen.blockStateCollector.accept(cuddlyBlockState(block, ModelIds.getBlockModelId(block), false));
        }
        registerShark(gen, BlahajBlocks.GRAY_SHARK_BLOCK, false);
        BlahajBlocks.PRIDE_BLOCKS.forEach(shark -> registerShark(gen, shark, true));
    }

    private static void registerShark(BlockStateModelGenerator gen, Block shark, boolean pride) {
        final var model = block("blue_shark", TextureKey.TEXTURE);
        final var id = ModelIds.getBlockModelId(shark);
        model.upload(
            id,
            pride ?
                TextureMap.texture(Registries.BLOCK.getId(shark)
                    .withPath(str -> "block/pride_sharks/" + str.substring(0, str.lastIndexOf('_')))) :
                TextureMap.texture(shark),
            gen.modelCollector
        );

        gen.registerParentedItemModel(shark, id);
        gen.blockStateCollector.accept(cuddlyBlockState(shark, id, false));
    }

    private static void registerProxy(BlockStateModelGenerator gen, Block... toProxy) {
        for (final var proxied : toProxy) {
            gen.registerParentedItemModel(proxied, ModelIds.getBlockModelId(proxied));
        }
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

    private static BlockStateSupplier cuddlyBlockState(Block block, Identifier model, boolean wall) {
        return MultipartBlockStateSupplier.create(block)
            .with(When.create().set(CuddlyBlock.FACING, Direction.NORTH),
                rotateVariant(model, VariantSettings.Rotation.R0, wall))

            .with(When.create().set(CuddlyBlock.FACING, Direction.EAST),
                rotateVariant(model, VariantSettings.Rotation.R90, wall))

            .with(When.create().set(CuddlyBlock.FACING, Direction.SOUTH),
                rotateVariant(model, VariantSettings.Rotation.R180, wall))

            .with(When.create().set(CuddlyBlock.FACING, Direction.WEST),
                rotateVariant(model, VariantSettings.Rotation.R270, wall));
    }

    private static BlockStateVariant rotateVariant(Identifier model, VariantSettings.Rotation Y, boolean wall) {
        final var var = BlockStateVariant.create()
            .put(VariantSettings.MODEL, model)
            .put(VariantSettings.Y, Y);
        if (wall) {
            var.put(VariantSettings.X, VariantSettings.Rotation.R90);
        }
        return var;
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

        for (final var rosette : JoyItems.ROSETTES) {
            gen.register(rosette, Models.GENERATED);
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
