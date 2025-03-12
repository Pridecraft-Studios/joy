package gay.pridecraft.joy.render.entity;

import gay.pridecraft.joy.JoyUtil;
import gay.pridecraft.joy.entity.CustomFrogEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.FrogEntityModel;
import net.minecraft.util.Identifier;

public class FrogRenderer extends MobEntityRenderer<CustomFrogEntity.FrogEntity, FrogEntityModel<CustomFrogEntity.FrogEntity>> {
    private static final Identifier TEMPERATE_TEXTURE = JoyUtil.id("textures/entity/frog/temperate_frog.png");
    private static final Identifier WARM_TEXTURE = JoyUtil.id("textures/entity/frog/warm_frog.png");
    private static final Identifier COLD_TEXTURE = JoyUtil.id("textures/entity/frog/cold_frog.png");

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
