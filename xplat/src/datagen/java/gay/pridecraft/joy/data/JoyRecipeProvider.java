package gay.pridecraft.joy.data;

import gay.pridecraft.joy.JoyUtil;
import gay.pridecraft.joy.block.BlahajBlocks;
import gay.pridecraft.joy.registry.JoyBlocks;
import gay.pridecraft.joy.registry.JoyItems;
import gay.pridecraft.joy.tags.JoyItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public class JoyRecipeProvider extends FabricRecipeProvider {
    public JoyRecipeProvider(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(final RecipeExporter exporter) {
        offerConversion(JoyBlocks.BLUE_ALLIUM, Items.BLUE_DYE, exporter);
        offerConversion(JoyBlocks.PINK_ALLIUM, Items.PINK_DYE, exporter);
        offerConversion(JoyBlocks.WHITE_ALLIUM, Items.WHITE_DYE, exporter);
        offerConversion(JoyBlocks.TRANS_ALLIUM, JoyItems.TRANS_DYE, exporter);

        stonecutting(exporter, RecipeCategory.MISC, JoyItemTags.SHARKS, 1,
            BlahajBlocks.PRIDE_ITEMS.toArray(Item[]::new));

        offerDye(ItemTags.BEDS, JoyItems.GAY_DYE, JoyBlocks.GAY_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.ENBY_DYE, JoyBlocks.ENBY_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.INTERSEX_DYE, JoyBlocks.INTERSEX_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.AGENDER_DYE, JoyBlocks.AGENDER_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.BIGENDER_DYE, JoyBlocks.BIGENDER_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.BISEXUAL_DYE, JoyBlocks.BISEXUAL_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.MLM_DYE, JoyBlocks.MLM_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.ACE_DYE, JoyBlocks.ACE_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.ARO_DYE, JoyBlocks.ARO_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.APLATONIC_DYE, JoyBlocks.APLATONIC_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.GENDERFLUID_DYE, JoyBlocks.GENDERFLUID_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.PAN_DYE, JoyBlocks.PAN_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.TRANS_DYE, JoyBlocks.TRANS_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.AROACE_DYE, JoyBlocks.AROACE_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.LESBIAN_DYE, JoyBlocks.LESBIAN_BED, exporter);
        offerDye(ItemTags.BEDS, JoyItems.PROGRESS_DYE, JoyBlocks.PROGRESS_BED, exporter);

        offerDye(Items.CANDLE, JoyItems.GAY_DYE, JoyBlocks.GAY_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.ENBY_DYE, JoyBlocks.ENBY_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.INTERSEX_DYE, JoyBlocks.INTERSEX_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.AGENDER_DYE, JoyBlocks.AGENDER_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.BIGENDER_DYE, JoyBlocks.BIGENDER_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.BISEXUAL_DYE, JoyBlocks.BISEXUAL_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.MLM_DYE, JoyBlocks.MLM_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.ACE_DYE, JoyBlocks.ACE_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.ARO_DYE, JoyBlocks.ARO_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.APLATONIC_DYE, JoyBlocks.APLATONIC_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.GENDERFLUID_DYE, JoyBlocks.GENDERFLUID_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.PAN_DYE, JoyBlocks.PAN_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.TRANS_DYE, JoyBlocks.TRANS_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.AROACE_DYE, JoyBlocks.AROACE_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.LESBIAN_DYE, JoyBlocks.LESBIAN_CANDLE, exporter);
        offerDye(Items.CANDLE, JoyItems.PROGRESS_DYE, JoyBlocks.PROGRESS_CANDLE, exporter);

        offerDye(Items.TOTEM_OF_UNDYING, JoyItems.GAY_DYE, JoyItems.TOTEM_OF_PRIDE, exporter);
        offerDye(Items.BRUSH, JoyItems.GAY_DYE, JoyItems.PRIDE_BRUSH, exporter);
        offerDye(Items.ELYTRA, JoyItems.GAY_DYE, JoyItems.PRIDE_ELYTRA, exporter);
        offerDye(Items.CAKE, JoyItems.GAY_DYE, JoyBlocks.PRIDE_CAKE, exporter);

        // offerDye(JoyItemTags.SHARKS, JoyItems.QUEER_DYE, joyItem("queer_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.GAY_DYE, joyItem("gay_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.ENBY_DYE, joyItem("enby_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.INTERSEX_DYE, joyItem("intersex_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.AGENDER_DYE, joyItem("agender_shark"), exporter);
        // offerDye(JoyItemTags.SHARKS, JoyItems.BIGENDER_DYE, joyItem("bigender_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.BISEXUAL_DYE, joyItem("bisexual_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.MLM_DYE, joyItem("mlm_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.ARO_DYE, joyItem("aro_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.ACE_DYE, joyItem("ace_shark"), exporter);
        // offerDye(JoyItemTags.SHARKS, JoyItems.APLATONIC_DYE, joyItem("aplatonic_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.DEMIROMANTIC_DYE, joyItem("demiromantic_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.DEMISEXUAL_DYE, joyItem("demisexual_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.GREYARO_DYE, joyItem("greyaro_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.GREYACE_DYE, joyItem("greyace_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.GREYROSE_DYE, joyItem("greyrose_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.GENDERFLUID_DYE, joyItem("genderfluid_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.GENDERQUEER_DYE, joyItem("genderqueer_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.PAN_DYE, joyItem("pan_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.TRANS_DYE, joyItem("trans_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.AROACE_DYE, joyItem("aroace_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.LESBIAN_DYE, joyItem("lesbian_shark"), exporter);
        // offerDye(JoyItemTags.SHARKS, JoyItems.PROGRESS_DYE, joyItem("progress_shark"), exporter);
        // offerDye(JoyItemTags.SHARKS, JoyItems.PLURAL_DYE, joyItem("plural_shark"), exporter);
        offerDye(JoyItemTags.SHARKS, JoyItems.POLYAM_DYE, joyItem("polyam_shark"), exporter);
    }

    private static void offerDye(TagKey<Item> base, ItemConvertible dye, ItemConvertible result, RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, result)
            .input(base)
            .input(dye)
            .group(base.id().getPath())
            .criterion("has_needed_dye", conditionsFromItem(dye))
            .offerTo(exporter, "dye_" + getItemPath(result));
    }

    private static void offerDye(ItemConvertible base, ItemConvertible dye, ItemConvertible result, RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, result)
            .input(base)
            .input(dye)
            .group(Registries.ITEM.getId(base.asItem()).getPath())
            .criterion("has_needed_dye", conditionsFromItem(dye))
            .offerTo(exporter, "dye_" + getItemPath(result));
    }

    private static void offerConversion(ItemConvertible base, Item dye, RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, dye)
            .input(base)
            .group(Registries.ITEM.getId(dye).getPath())
            .criterion(Registries.ITEM.getId(base.asItem())
                .withSuffixedPath("has_").toString(), conditionsFromItem(base))
            .offerTo(exporter);
    }

    private static void stonecutting(RecipeExporter exporter, RecipeCategory category, TagKey<Item> base, int count, ItemConvertible... results) {
        for (final var result : results) {
            offerStonecuttingRecipe(exporter, category, result, base, count);
        }
    }

    private static void offerStonecuttingRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, TagKey<Item> input, int count) {
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.fromTag(input), category, output, count)
            .criterion(hasTag(input), conditionsFromTag(input))
            .offerTo(exporter, "stonecutting/" + tagToItem(input, output));
    }

    private static String tagToItem(TagKey<?> input, ItemConvertible output) {
        return getItemPath(output) + "_from_" + input.id().getPath();
    }

    private static String hasTag(TagKey<?> tag) {
        return tag.id().withSuffixedPath("has_").toString();
    }

    private static Item joyItem(String id) {
        return Registries.ITEM.getOrEmpty(JoyUtil.id(id)).orElseThrow(() -> new IllegalArgumentException(id));
    }
}
