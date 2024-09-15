package gay.pridecraft.joy.renderer.entity;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.entity.custom.living.CustomSnifferEntity;
import gay.pridecraft.joy.renderer.model.SnifferEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SnifferRenderer extends MobEntityRenderer<CustomSnifferEntity.SnifferEntity, SnifferEntityModel<CustomSnifferEntity.SnifferEntity>> {
    private static final Identifier TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/sniffer/pride_sniffer.png");

    public SnifferRenderer(EntityRendererFactory.Context context) {
        super(context, new SnifferEntityModel<>(context.getPart(EntityModelLayers.SNIFFER)), 1.1F);
    }

    @Override
    public Identifier getTexture(CustomSnifferEntity.SnifferEntity entity) {
        return TEXTURE;
    }
}

