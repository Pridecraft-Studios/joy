package gay.pridecraft.joymod.renderer.entity;

import gay.pridecraft.joymod.JoyMod;
import gay.pridecraft.joymod.entity.custom.living.CustomSnifferEntity;
import gay.pridecraft.joymod.renderer.model.PrideSnifferEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class PrideSnifferRenderer extends MobEntityRenderer<CustomSnifferEntity.PrideSnifferEntity, PrideSnifferEntityModel<CustomSnifferEntity.PrideSnifferEntity>> {
    private static final Identifier TEXTURE = new Identifier(JoyMod.MOD_ID, "textures/entity/sniffer/pride_sniffer.png");

    public PrideSnifferRenderer(EntityRendererFactory.Context context) {
        super(context, new PrideSnifferEntityModel<>(context.getPart(EntityModelLayers.SNIFFER)), 1.1F);
    }

    @Override
    public Identifier getTexture(CustomSnifferEntity.PrideSnifferEntity entity) {
        return TEXTURE;
    }
}

