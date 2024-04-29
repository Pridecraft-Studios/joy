package gay.pridecraft.joymod.renderer.entity;

import gay.pridecraft.joymod.JoyMod;
import gay.pridecraft.joymod.entity.custom.living.CustomFrogEntity;
import gay.pridecraft.joymod.renderer.model.PrideFrogEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class PrideFrogRenderer extends MobEntityRenderer<CustomFrogEntity.PrideFrogEntity, PrideFrogEntityModel<CustomFrogEntity.PrideFrogEntity>> {
    private static final Identifier TEMPERATE_TEXTURE = new Identifier(JoyMod.MOD_ID, "textures/entity/frog/temperate_frog.png");
    private static final Identifier WARM_TEXTURE = new Identifier(JoyMod.MOD_ID, "textures/entity/frog/warm_frog.png");
    private static final Identifier COLD_TEXTURE = new Identifier(JoyMod.MOD_ID, "textures/entity/frog/cold_frog.png");

    public PrideFrogRenderer(EntityRendererFactory.Context context) {
        super(context, new PrideFrogEntityModel<>(context.getPart(EntityModelLayers.FROG)), 0.3F);
    }

    @Override
    public Identifier getTexture(CustomFrogEntity.PrideFrogEntity entity) {
        String fullTexturePath = entity.getVariant().texture().toString().toLowerCase();
        String variant = fullTexturePath.substring(fullTexturePath.lastIndexOf("/") + 1);
        variant = variant.substring(0, variant.lastIndexOf("."));

        return switch (variant) {
            case "warm_frog" -> WARM_TEXTURE;
            case "cold_frog" -> COLD_TEXTURE;
            default -> TEMPERATE_TEXTURE;
        };
    }
}
