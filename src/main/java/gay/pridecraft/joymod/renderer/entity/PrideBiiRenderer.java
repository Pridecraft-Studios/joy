package gay.pridecraft.joymod.renderer.entity;

import gay.pridecraft.joymod.JoyMod;
import gay.pridecraft.joymod.entity.custom.living.CustomBeeEntity;
import gay.pridecraft.joymod.renderer.model.PrideBiiEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class PrideBiiRenderer extends MobEntityRenderer<CustomBeeEntity.PrideBiiEntity, PrideBiiEntityModel<CustomBeeEntity.PrideBiiEntity>> {
    private static final Identifier ANGRY_TEXTURE = new Identifier(JoyMod.MOD_ID, "textures/entity/bee/pride_bii_angry.png");
    private static final Identifier ANGRY_NECTAR_TEXTURE = new Identifier(JoyMod.MOD_ID, "textures/entity/bee/pride_bii_angry_nectar.png");
    private static final Identifier PASSIVE_TEXTURE = new Identifier(JoyMod.MOD_ID, "textures/entity/bee/pride_bii.png");
    private static final Identifier NECTAR_TEXTURE = new Identifier(JoyMod.MOD_ID, "textures/entity/bee/pride_bii_nectar.png");

    public PrideBiiRenderer(EntityRendererFactory.Context context) {
        super(context, new PrideBiiEntityModel<>(context.getPart(EntityModelLayers.BEE)), 0.4F);
    }

    @Override
    public Identifier getTexture(CustomBeeEntity.PrideBiiEntity entity) {
        if (entity.hasAngerTime()) {
            return entity.hasNectar() ? ANGRY_NECTAR_TEXTURE : ANGRY_TEXTURE;
        } else {
            return entity.hasNectar() ? NECTAR_TEXTURE : PASSIVE_TEXTURE;
        }
    }
}
