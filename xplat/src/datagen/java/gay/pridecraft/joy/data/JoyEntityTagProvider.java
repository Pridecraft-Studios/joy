package gay.pridecraft.joy.data;

import gay.pridecraft.joy.JoyUtil;
import gay.pridecraft.joy.registry.JoyEntities;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

/**
 * @author Ampflower
 * @since 1.0.0
 **/
public class JoyEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {

    public static final TagKey<EntityType<?>>
        BEES = joy("bees"),
        BARRICADE_PASSIVE = barricade("blocked_by_passive_barrier"),
        BARRICADE_HOSTILE = barricade("blocked_by_hostile_barrier"),
        BARRICADE_MOB = barricade("blocked_by_mob_barrier");

    private static TagKey<EntityType<?>> joy(String name) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, JoyUtil.id(name));
    }

    private static TagKey<EntityType<?>> barricade(String name) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of("barricade", name));
    }

    private static TagKey<EntityType<?>> common(String name) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of("c", name));
    }

    public JoyEntityTagProvider(final FabricDataOutput output, final CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(final RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BEES).add(
            JoyEntities.BII,
            JoyEntities.ENBEE,
            JoyEntities.TREE,
            JoyEntities.TRANS_BEE
        );

        getOrCreateTagBuilder(EntityTypeTags.BEEHIVE_INHABITORS)
            .addTag(BEES);

        getOrCreateTagBuilder(BARRICADE_PASSIVE)
            .addTag(BEES)
            .add(
                JoyEntities.FROG,
                JoyEntities.SNIFFER,
                JoyEntities.SOCK_FOX
            );
    }
}
