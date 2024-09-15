package gay.pridecraft.joy.renderer.entity;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.entity.custom.living.CustomFrogEntity;
import gay.pridecraft.joy.renderer.model.FrogEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class FrogRenderer extends MobEntityRenderer<CustomFrogEntity.FrogEntity, FrogEntityModel<CustomFrogEntity.FrogEntity>> {
    private static final Identifier TEMPERATE_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/frog/temperate_frog.png");
    private static final Identifier WARM_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/frog/warm_frog.png");
    private static final Identifier COLD_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/frog/cold_frog.png");

    public FrogRenderer(EntityRendererFactory.Context context) {
        super(context, new FrogEntityModel<>(context.getPart(EntityModelLayers.FROG)), 0.3F);
    }

    @Override
    public Identifier getTexture(CustomFrogEntity.FrogEntity entity) {
        if (entity.getVariant().getKey().isEmpty())
            return TEMPERATE_TEXTURE;

        return switch (entity.getVariant().getKey().get().getValue().getPath()) {
            case "warm" -> WARM_TEXTURE;
            case "cold" -> COLD_TEXTURE;
            default -> TEMPERATE_TEXTURE;
        };
    }
}
