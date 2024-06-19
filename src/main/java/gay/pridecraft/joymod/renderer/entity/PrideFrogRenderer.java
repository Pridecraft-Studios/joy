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
    private static final Identifier TEMPERATE_TEXTURE = Identifier.of(JoyMod.MOD_ID, "textures/entity/frog/pride_temperate_frog.png");
    private static final Identifier WARM_TEXTURE = Identifier.of(JoyMod.MOD_ID, "textures/entity/frog/pride_warm_frog.png");
    private static final Identifier COLD_TEXTURE = Identifier.of(JoyMod.MOD_ID, "textures/entity/frog/pride_cold_frog.png");

    public PrideFrogRenderer(EntityRendererFactory.Context context) {
        super(context, new PrideFrogEntityModel<>(context.getPart(EntityModelLayers.FROG)), 0.3F);
    }

    @Override
    public Identifier getTexture(CustomFrogEntity.PrideFrogEntity entity) {
        if (entity.getVariant().getKey().isEmpty())
            return TEMPERATE_TEXTURE;

        return switch (entity.getVariant().getKey().get().getValue().getPath()) {
            case "warm" -> WARM_TEXTURE;
            case "cold" -> COLD_TEXTURE;
            default -> TEMPERATE_TEXTURE;
        };
    }
}
