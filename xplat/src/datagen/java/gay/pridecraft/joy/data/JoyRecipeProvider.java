package gay.pridecraft.joy.data;

import gay.pridecraft.joy.registry.JoyBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

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
    }

    private static void offerConversion(ItemConvertible base, Item dye, RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, dye)
            .input(base)
            .group(Registries.ITEM.getId(dye).getPath())
            .criterion(Registries.ITEM.getId(base.asItem())
                .withSuffixedPath("has_").toString(), conditionsFromItem(base))
            .offerTo(exporter);
    }
}
