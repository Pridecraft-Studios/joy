package gay.pridecraft.joy.renderer.entity;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.entity.custom.living.CustomBeeEntity;
import gay.pridecraft.joy.renderer.model.EnbeeEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class EnbeeRenderer extends MobEntityRenderer<CustomBeeEntity.EnbeeEntity, EnbeeEntityModel<CustomBeeEntity.EnbeeEntity>> {
    private static final Identifier ANGRY_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/bee/enbee_angry.png");
    private static final Identifier ANGRY_NECTAR_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/bee/enbee_angry_nectar.png");
    private static final Identifier PASSIVE_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/bee/enbee.png");
    private static final Identifier NECTAR_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/bee/enbee_nectar.png");

    public EnbeeRenderer(EntityRendererFactory.Context context) {
        super(context, new EnbeeEntityModel<>(context.getPart(EntityModelLayers.BEE)), 0.4F);
    }

    @Override
    public Identifier getTexture(CustomBeeEntity.EnbeeEntity entity) {
        if (entity.hasAngerTime()) {
            return entity.hasNectar() ? ANGRY_NECTAR_TEXTURE : ANGRY_TEXTURE;
        } else {
            return entity.hasNectar() ? NECTAR_TEXTURE : PASSIVE_TEXTURE;
        }
    }
}
