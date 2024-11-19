package gay.pridecraft.joy.render.entity;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.entity.CustomBeeEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BeeEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class TransBeeRenderer extends MobEntityRenderer<CustomBeeEntity.TransBeeEntity, BeeEntityModel<CustomBeeEntity.TransBeeEntity>> {
    private static final Identifier ANGRY_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/bee/trans_bee_angry.png");
    private static final Identifier ANGRY_NECTAR_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/bee/trans_bee_angry_nectar.png");
    private static final Identifier PASSIVE_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/bee/trans_bee.png");
    private static final Identifier NECTAR_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/bee/trans_bee_nectar.png");

    public TransBeeRenderer(EntityRendererFactory.Context context) {
        super(context, new BeeEntityModel<>(context.getPart(EntityModelLayers.BEE)), 0.4F);
    }

    @Override
    public Identifier getTexture(CustomBeeEntity.TransBeeEntity entity) {
        if (entity.hasAngerTime()) {
            return entity.hasNectar() ? ANGRY_NECTAR_TEXTURE : ANGRY_TEXTURE;
        } else {
            return entity.hasNectar() ? NECTAR_TEXTURE : PASSIVE_TEXTURE;
        }
    }
}
