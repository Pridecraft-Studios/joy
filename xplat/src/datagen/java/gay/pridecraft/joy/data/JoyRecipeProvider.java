package gay.pridecraft.joy.data;

import gay.pridecraft.joy.block.BlahajBlocks;
import gay.pridecraft.joy.registry.JoyBlocks;
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

        stonecutting(exporter, RecipeCategory.MISC, JoyItemTags.SHARKS, 1,
            BlahajBlocks.PRIDE_ITEMS.toArray(Item[]::new));
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
}
