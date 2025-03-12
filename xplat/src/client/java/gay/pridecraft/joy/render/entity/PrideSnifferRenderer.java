package gay.pridecraft.joy.render.entity;

import gay.pridecraft.joy.JoyUtil;
import gay.pridecraft.joy.entity.CustomSnifferEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SnifferEntityModel;
import net.minecraft.util.Identifier;

public class PrideSnifferRenderer extends MobEntityRenderer<CustomSnifferEntity.SnifferEntity, SnifferEntityModel<CustomSnifferEntity.SnifferEntity>> {
    private static final Identifier TEXTURE = JoyUtil.id("textures/entity/sniffer/pride_sniffer.png");

    public PrideSnifferRenderer(EntityRendererFactory.Context context) {
        super(context, new SnifferEntityModel<>(context.getPart(EntityModelLayers.SNIFFER)), 1.1F);
    }

    @Override
    public Identifier getTexture(CustomSnifferEntity.SnifferEntity entity) {
        return TEXTURE;
    }
}

