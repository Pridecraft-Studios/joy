package gay.pridecraft.joy.data;

import gay.pridecraft.joy.registry.JoyItems;
import gay.pridecraft.joy.tags.JoyItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public class JoyItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public JoyItemTagProvider(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(final RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(JoyItemTags.ELYTRA).add(
            Items.ELYTRA,
            JoyItems.PRIDE_ELYTRA
        );
        getOrCreateTagBuilder(JoyItemTags.GLIDERS).addTag(
            JoyItemTags.ELYTRA
        );
        getOrCreateTagBuilder(JoyItemTags.TOTEM_OF_UNDYING).add(
            Items.TOTEM_OF_UNDYING,
            JoyItems.TOTEM_OF_PRIDE
        );
    }
}
