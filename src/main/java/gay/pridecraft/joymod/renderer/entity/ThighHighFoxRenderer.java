package gay.pridecraft.joymod.renderer.entity;

import gay.pridecraft.joymod.JoyMod;
import gay.pridecraft.joymod.entity.custom.living.CustomFoxEntity;
import gay.pridecraft.joymod.renderer.feature.ThighHighFoxHeldItemFeatureRenderer;
import gay.pridecraft.joymod.renderer.model.ThighHighFoxEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class ThighHighFoxRenderer extends MobEntityRenderer<CustomFoxEntity.ThighHighFoxEntity, ThighHighFoxEntityModel<CustomFoxEntity.ThighHighFoxEntity>> {
    private static final Identifier TEXTURE = new Identifier(JoyMod.MOD_ID, "textures/entity/fox/thigh_high_fox.png");
    private static final Identifier SLEEPING_TEXTURE = new Identifier(JoyMod.MOD_ID, "textures/entity/fox/thigh_high_fox_sleep.png");
    private static final Identifier SNOW_TEXTURE = new Identifier(JoyMod.MOD_ID, "textures/entity/fox/thigh_high_snow_fox.png");
    private static final Identifier SLEEPING_SNOW_TEXTURE = new Identifier(JoyMod.MOD_ID, "textures/entity/fox/thigh_high_snow_fox_sleep.png");

    public ThighHighFoxRenderer(EntityRendererFactory.Context context) {
        super(context, new ThighHighFoxEntityModel<>(context.getPart(EntityModelLayers.FOX)), 0.4F);
        this.addFeature(new ThighHighFoxHeldItemFeatureRenderer(this, context.getHeldItemRenderer()));
    }

    protected void setupTransforms(CustomFoxEntity.ThighHighFoxEntity thighHighFoxEntity, MatrixStack matrixStack, float f, float g, float h) {
        super.setupTransforms(thighHighFoxEntity, matrixStack, f, g, h);
        if (thighHighFoxEntity.isChasing() || thighHighFoxEntity.isWalking()) {
            float i = -MathHelper.lerp(h, thighHighFoxEntity.prevPitch, thighHighFoxEntity.getPitch());
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(i));
        }
    }

    @Override
    public Identifier getTexture(CustomFoxEntity.ThighHighFoxEntity entity) {
        if (entity.getVariant() == FoxEntity.Type.RED) {
            return entity.isSleeping() ? SLEEPING_TEXTURE : TEXTURE;
        } else {
            return entity.isSleeping() ? SLEEPING_SNOW_TEXTURE : SNOW_TEXTURE;
        }
    }
}
