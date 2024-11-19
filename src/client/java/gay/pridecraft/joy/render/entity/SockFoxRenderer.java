package gay.pridecraft.joy.render.entity;

import gay.pridecraft.joy.Joy;
import gay.pridecraft.joy.entity.CustomFoxEntity;
import gay.pridecraft.joy.render.feature.SockFoxHeldItemFeatureRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.FoxEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@Environment(EnvType.CLIENT)
public class SockFoxRenderer extends MobEntityRenderer<CustomFoxEntity.SockFoxEntity, FoxEntityModel<CustomFoxEntity.SockFoxEntity>> {
    private static final Identifier TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/fox/sock_fox.png");
    private static final Identifier SLEEPING_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/fox/sock_fox_sleep.png");
    private static final Identifier SNOW_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/fox/snow_sock_fox.png");
    private static final Identifier SLEEPING_SNOW_TEXTURE = Identifier.of(Joy.MOD_ID, "textures/entity/fox/snow_sock_fox_sleep.png");

    public SockFoxRenderer(EntityRendererFactory.Context context) {
        super(context, new FoxEntityModel<>(context.getPart(EntityModelLayers.FOX)), 0.4F);
        this.addFeature(new SockFoxHeldItemFeatureRenderer(this, context.getHeldItemRenderer()));
    }

    protected void setupTransforms(CustomFoxEntity.SockFoxEntity sockFoxEntity, MatrixStack matrixStack, float animationProgress, float bodyYaw, float tickDelta, float scale) {
        super.setupTransforms(sockFoxEntity, matrixStack, animationProgress, bodyYaw, tickDelta, scale);
        if (sockFoxEntity.isChasing() || sockFoxEntity.isWalking()) {
            float i = -MathHelper.lerp(tickDelta, sockFoxEntity.prevPitch, sockFoxEntity.getPitch());
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(i));
        }
    }

    @Override
    public Identifier getTexture(CustomFoxEntity.SockFoxEntity entity) {
        if (entity.getVariant() == FoxEntity.Type.RED) {
            return entity.isSleeping() ? SLEEPING_TEXTURE : TEXTURE;
        } else {
            return entity.isSleeping() ? SLEEPING_SNOW_TEXTURE : SNOW_TEXTURE;
        }
    }
}
