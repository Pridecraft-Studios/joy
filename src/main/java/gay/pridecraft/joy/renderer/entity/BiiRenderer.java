package gay.pridecraft.joy.renderer.entity;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.entity.custom.living.CustomBeeEntity;
import gay.pridecraft.joy.renderer.model.BiiEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BiiRenderer extends MobEntityRenderer<CustomBeeEntity.BiiEntity, BiiEntityModel<CustomBeeEntity.BiiEntity>> {
    private static final Identifier ANGRY_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/bee/bii_angry.png");
    private static final Identifier ANGRY_NECTAR_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/bee/bii_angry_nectar.png");
    private static final Identifier PASSIVE_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/bee/bii.png");
    private static final Identifier NECTAR_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/bee/bii_nectar.png");

    public BiiRenderer(EntityRendererFactory.Context context) {
        super(context, new BiiEntityModel<>(context.getPart(EntityModelLayers.BEE)), 0.4F);
    }

    @Override
    public Identifier getTexture(CustomBeeEntity.BiiEntity entity) {
        if (entity.hasAngerTime()) {
            return entity.hasNectar() ? ANGRY_NECTAR_TEXTURE : ANGRY_TEXTURE;
        } else {
            return entity.hasNectar() ? NECTAR_TEXTURE : PASSIVE_TEXTURE;
        }
    }
}
