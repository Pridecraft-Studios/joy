package gay.pridecraft.joy.data;

import gay.pridecraft.joy.registry.JoyEntities;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public class JoyEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {
    public JoyEntityTagProvider(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(final RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(EntityTypeTags.BEEHIVE_INHABITORS).add(
            JoyEntities.BII,
            JoyEntities.ENBEE,
            JoyEntities.TREE,
            JoyEntities.TRANS_BEE
        );
    }
}
